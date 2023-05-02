package com.example;
import com.example.graph.*;
import java.util.Scanner;

public class ShortestPathAlgorithm {

	enum Messages{EnterGraph, Main, Exit, 
		PathAllAlgo, PathAllOpt,
		PathSrcAlgo, PathSrcOpt,
		NegCycle};
	enum Algorithm{Dij, Bellman, Floyd};

	static IGraph graph;
	static Algorithm chosenAlgo;
	static double[] costsArr = new double[0];
	static Integer[][] costsMat = new Integer[0][0];
	static int[] predsArr = new int[0];
	static int[][] succMat = new int[0][0];
	static boolean result = false;  
	static Scanner scn;


    public static void main( String[] args )
    {
        System.out.println( "[ Shortest Path Algorithms ]" );
		scn = new Scanner(System.in);
		Messages msg = Messages.EnterGraph;

		loop:
		while(true)
		{
			switch (msg) {
				case EnterGraph:
				msg = enter_graph_path();
				break;
				case Main:
				msg = main_menu();
				break;
				case PathSrcAlgo:
				msg = choose_algorithm(Messages.PathSrcOpt);
				break;
				case PathSrcOpt:
				msg = path_from_source_options();
				break;
				case PathAllAlgo:
				msg = choose_algorithm(Messages.PathAllOpt);
				break;
				case PathAllOpt:
				msg = path_to_all_options();
				break;
				case NegCycle:
				msg = find_neg_cycles();
				break;
				case Exit:
				break loop;
			}
		}

        System.out.println("Status: Program Completed");
		// scanner.close();
    }

	static Messages enter_graph_path()
	{
		Messages msg = null;
        System.out.print("Enter the path to the graph file: ");
        graph = new Graph();
        graph.loadGraphFromFile(scn.next());
        System.out.println("Status: Graph Loaded. (Size: " + graph.size() + ")");
		msg = Messages.Main;
		System.out.println("\n\n");
		return msg;
	}

	static Messages main_menu()
	{
		Messages msg = null;
		System.out.println("Choice 1: Find shortest path from source node to all other nodes.");
        System.out.println("Choice 2: Find shortest path between all pairs of nodes.");
        System.out.println("Choice 3: Check if graph contains a negative cycle.");
        System.out.println("Choice 4: Enter another graph.");
        System.out.print("Your Choice: ");
        int choice = scn.nextInt();
		switch (choice)
		{
			case 1:
			msg = Messages.PathSrcAlgo;
			break;
			case 2:
			msg = Messages.PathAllAlgo;
			break;
			case 3:
			msg = Messages.NegCycle;
			break;
			case 4:
			msg = Messages.EnterGraph;
			break;
		}
		System.out.println("\n\n");
		return msg;
	}

	static Messages choose_algorithm(Messages nextMenu)
	{
		System.out.println("Choose an algorithm:");
		System.out.println("1: Dijkstra");
		System.out.println("2: Bellman-Ford");
		System.out.println("3: Floyd-Warshall");
		System.out.println("4: Back");
		System.out.print("Your choice: ");
		Messages msg = null;
		int choice = scn.nextInt();
		switch (choice)
		{
			case 1:
			chosenAlgo = Algorithm.Dij;
			msg = nextMenu;
			break;
			case 2:
			chosenAlgo = Algorithm.Bellman;
			msg = nextMenu;
			break;
			case 3:
			chosenAlgo = Algorithm.Floyd;
			msg = nextMenu;
			break;
			case 4:
			msg = Messages.Main;
		}
		System.out.println("\n\n");
		return msg;
	}

	static int execute_algorithm()
	{
		int source = -1;
		while(true)
		{
			System.out.print("Choose a source between 0 and " + (graph.size()-1) + ": ");
			source = scn.nextInt();
			if (source < 0 || source >= graph.size()) continue;
			break;
		}
		switch (chosenAlgo)
		{
			case Bellman:
			case Dij:
			costsArr = new double[graph.size()];
			predsArr = new int[graph.size()];
			break;
			case Floyd:
			costsMat = new Integer[graph.size()][graph.size()];
			succMat = new int[graph.size()][graph.size()];
			break;
		}
		
		switch (chosenAlgo)
		{
			case Dij:
			graph.run_dijkstra(source, costsArr, predsArr);
			break;
			case Bellman:
			graph.run_bellman_ford(source, costsArr, predsArr);
			break;
			case Floyd:
			graph.run_floyd_warshall(costsMat, succMat);
			break;
		}
		return source;
	}

	static Messages path_from_source_options()
	{
		Messages msg = null;
		//Executing the algorithm
		int source = execute_algorithm();
		//Options
		while(msg == null)
		{
			System.out.println("1 : Show the path to a node.");
			System.out.println("2 : Show the cost of a node.");
			System.out.println("3 : Choose another source.");
			System.out.println("4 : Main menu.");
			System.out.print("Your choice: ");
			int choice = scn.nextInt();
			switch(choice)
			{
				case 1:
				path_to_node(source);
				break;
				case 2:
				cost_to_node(source);
				break;
				case 3:
				msg = Messages.PathSrcOpt;
				break;
				case 4:
				msg = Messages.Main;
				break;
			}
			
		}
		System.out.println("\n\n");
		return msg;
	}
	
	static void path_to_node(int source)
	{
		System.out.print("Choose destination within 0 and "+ (graph.size()-1) + ": ");
		int dest = scn.nextInt();
		int current;
		if(chosenAlgo != Algorithm.Floyd)
		{
			if (Double.isInfinite(costsArr[dest]))
			{
				System.out.println("No path exists.");
				System.out.println("\n");
				return;
			}
			current = dest;
			while (current != source)
			{
				System.out.print(current+"<-");
				current = predsArr[current];
			}
		}
		else
		{
			if (costsMat[source][dest] == Integer.MAX_VALUE)
			{
				System.out.println("No path exists.");
				System.out.println("\n");
				return;
			}
			current = source;
			while(current != dest)
			{
				System.out.print(current+ "->");
				current = succMat[current][dest];
			}
		}
		
		System.out.println(current);
		System.out.println("\n");
	}	
	
	static void cost_to_node(int source)
	{
		System.out.println("Choose destination within 0 and "+ (graph.size()-1) + ": ");
		int dest = scn.nextInt();
		if (chosenAlgo == Algorithm.Floyd)
		{
			if (costsMat[source][dest] == Integer.MAX_VALUE) System.out.println("infinity");
		}
		else
		{
			System.out.println(costsArr[dest]);
		}
		System.out.println("\n");
	}	


	// static Messages path_to_all_choose_algorithm()
	// {

	// 	return Messages.Main;
	// }

	static Messages path_to_all_options()
	{
		if (chosenAlgo == Algorithm.Floyd)
		{
			costsMat = new Integer[graph.size()][graph.size()];	
			succMat = new int[graph.size()][graph.size()];
			graph.run_floyd_warshall(costsMat, succMat);
		}
		Messages msg = null;
		while(msg == null)
		{
			System.out.println("1 : Show path from x to y");
			System.out.println("2 : Show cost of path from x to y");
			System.out.println("3 : Main menu.");
			System.out.print("Your choice: ");
			int choice = scn.nextInt();
			switch(choice)
			{
				case 1:
				path_between_pair();
				break;
				case 2:
				cost_between_pair();
				break;
				case 3:
				msg = Messages.Main;
				break;
			}
			
		}
		
		System.out.println("\n\n");
		return msg;
	}


	static void path_between_pair()
	{
		System.out.print("Enter x and y within 0 and " + (graph.size()-1) + ": ");
		int src = scn.nextInt(), dest = scn.nextInt();
		switch(chosenAlgo) 
		{
			case Dij:
			costsArr = new double[graph.size()];
			predsArr = new int[graph.size()];
			graph.run_dijkstra(src, costsArr, predsArr);
			
			break;
			case Bellman:
			costsArr = new double[graph.size()];
			predsArr = new int[graph.size()];
			graph.run_bellman_ford(src, costsArr, predsArr);
			break;
			case Floyd:	
			break;
		}
		int current;
		if(chosenAlgo != Algorithm.Floyd)
		{
			if (Double.isInfinite(costsArr[dest]))
			{
				System.out.println("No path exists.");
				System.out.println("\n");
				return;
			}
			current = dest;
			while (current != src)
			{
				System.out.print(current+"<-");
				current = predsArr[current];
			}
		}
		else
		{
			if (costsMat[src][dest] == Integer.MAX_VALUE)
			{
				System.out.println("No path exists.");
				System.out.println("\n");
				return;
			}
			current = src;
			while(current != dest)
			{
				System.out.print(current+ "->");
				current = succMat[current][dest];
			}
		}
		
		System.out.println(current);
		System.out.println("\n");

	}

	static void cost_between_pair()
	{
		System.out.print("Enter x and y within 0 and " + (graph.size()-1) + ": ");
		int src = scn.nextInt(), dest = scn.nextInt();
		switch(chosenAlgo) 
		{
			case Dij:
			costsArr = new double[graph.size()];
			predsArr = new int[graph.size()];
			graph.run_dijkstra(src, costsArr, predsArr);
			
			break;
			case Bellman:
			costsArr = new double[graph.size()];
			predsArr = new int[graph.size()];
			graph.run_bellman_ford(src, costsArr, predsArr);
			break;
			case Floyd:	
			break;
		}
		if (chosenAlgo == Algorithm.Floyd)
		{
			if (costsMat[src][dest] == Integer.MAX_VALUE) System.out.println("infinity");
		}
		else
		{
			System.out.println(costsArr[dest]);
		}
		System.out.println("\n");
	}

	static Messages find_neg_cycles()
	{
		System.out.println("Choose an algorithm:");
		System.out.println("1: Bellman-Ford");
		System.out.println("2: Floyd-Warshall");
		System.out.println("3: Back");
		System.out.print("Your choice: ");
		int choice = scn.nextInt();
		boolean result = false;
		switch(choice)
		{
			case 1:
			int[] preds = new int[graph.size()];
			double[] costsArr = new double[graph.size()];
			result = graph.run_bellman_ford(0, costsArr, preds);
			break;
			case 2:
			int[][] succs = new int[graph.size()][graph.size()];
			Integer[][] costsMat = new Integer[graph.size()][graph.size()];
			result = graph.run_floyd_warshall(costsMat, succs);
			break;
			case 3:
			return Messages.Main;
		}
		if (!result)
		{
			System.out.println("Negative cycle found.");
		}
		else
		{
			System.out.println("No negative cycles found.");
		}
		System.out.println("\n\n");
		return Messages.Main;
	}
}

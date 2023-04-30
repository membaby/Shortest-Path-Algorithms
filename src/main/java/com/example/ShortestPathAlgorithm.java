package com.example;
import com.example.graph.*;
import java.util.Scanner;

public class ShortestPathAlgorithm {
    public static void main( String[] args )
    {
        System.out.println( "[ Shortest Path Algorithms ]" );

        Scanner scanner = new Scanner(System.in);

        // Load Graph File
        System.out.println("Enter the path to the graph file: ");
        Graph graph = new Graph();
        graph.loadGraphFromFile(scanner.nextLine());
        System.out.println("Status: Graph Loaded. (Size: " + graph.size() + ")");

        
       // Run Algorithms
        System.out.println("Choice 1: Find shortest path from source node to all other nodes.");
        System.out.println("Choice 2: Find shortest path between all pairs of nodes.");
        System.out.println("Choice 3: Check if graph contains a negative cycle.");
        System.out.println("Your Choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // DO SOMETHING
                break;
            case 2:
                // DO SOMETHING
                break;
            case 3:
                // DO SOMETHING
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }


        // System.out.println("Status: Running Dijkstra's Algorithm");
        
        // int[] distances = new int[graph.size()];
        // int[] predecessors = new int[graph.size()];
        // graph.run_dijkstra(0, distances, predecessors);
        
        // System.out.println("Distances:");
        // for (int i = 0; i < distances.length; i++){
        //     System.out.println(distances[i]);
        // }
        // System.out.println("Predecessors:");
        // for (int i = 0; i < predecessors.length; i++){
        //     System.out.println(predecessors[i]);
        // }

        // System.out.println("Status: Dijkstra's Algorithm Completed");

        // System.out.println("Status: Running Bellman-Ford Algorithm");
        // // graph.run_bellman_ford();
        // System.out.println("Status: Bellman-Ford Algorithm Completed");

        // System.out.println("Status: Running Floyd-Warshall Algorithm");
        // // graph.run_floyd_warshall();
        // System.out.println("Status: Floyd-Warshall Algorithm Completed");

        System.out.println("Status: Program Completed");
    }
}

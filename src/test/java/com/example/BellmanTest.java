package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

import com.example.graph.Graph;
import com.example.graph.IGraph;


public class BellmanTest {
	
	@Test
	public void edge_traversal_test_1()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph1.txt");
		double[] distances = new double[graph.size()];
		int[] predecessors = new int[graph.size()];

		boolean result = graph.run_bellman_ford(0, distances, predecessors);
		assertEquals(0, (int)distances[0]);
		assertEquals(4, (int)distances[2]);
		assertEquals(1, (int)distances[3]);
		assertEquals(6, (int)distances[4]);
		assertEquals(2, (int)distances[5]);
		// assertTrue(result);

	}
	
	@Test
	public void edge_traversal_test_2()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph1.txt");
		double[] distances = new double[graph.size()];
		int[] predecessors = new int[graph.size()];

		boolean result = graph.run_bellman_ford(1, distances, predecessors);
		assertEquals(Integer.MAX_VALUE, (int) distances[0]);
		assertEquals(0, 				(int) distances[1]);
		assertEquals(Integer.MAX_VALUE, (int) distances[2]);
		assertEquals(Integer.MAX_VALUE, (int) distances[3]);
		assertEquals(Integer.MAX_VALUE, (int) distances[4]);
		assertEquals(Integer.MAX_VALUE, (int) distances[5]);
	}

	@Test
	public void edge_traversal_test_3()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph2.txt");
		double[] distances = new double[graph.size()];
		int[] predecessors = new int[graph.size()];

		boolean result = graph.run_bellman_ford(1, distances, predecessors);
		assertEquals(Integer.MAX_VALUE, (int) distances[0]);
	}

	@Test
	public void shortest_path_test_1()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph2.txt");
		double[] distances = new double[graph.size()];
		int[] predecessors = new int[graph.size()];

		boolean result = graph.run_bellman_ford(0, distances, predecessors);
		assertEquals(4, (int) distances[2]);
	}

	@Test
	public void shortest_path_test_2()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph2.txt");
		double[] distances = new double[graph.size()];
		int[] predecessors = new int[graph.size()];

		boolean result = graph.run_bellman_ford(0, distances, predecessors);
		assertEquals(24, (int) distances[3]);
	}

	@Test
	public void loops_test_1()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph3.txt");
		double[] distances = new double[graph.size()];
		int[] predecessors = new int[graph.size()];
		
		boolean result = graph.run_bellman_ford(0, distances, predecessors);
		//Check path to node 1 and 2 doesn't include loops. Currently can't do it because djikstra doesn't return paths.
	}

	@Test
	public void loops_test_2()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph5.txt");
		double[] distances = new double[graph.size()];
		int[] predecessors = new int[graph.size()];
		
		boolean result = graph.run_bellman_ford(0, distances, predecessors);
		//Check path to node 1 and 2 doesn't include loops. Currently can't do it because djikstra doesn't return paths.
	}

	@Test
	public void disconnected_graph_test()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph4.txt");
		double[] distances = new double[graph.size()];
		int[] predecessors = new int[graph.size()];
		
		boolean result = graph.run_bellman_ford(0, distances, predecessors);
		assertEquals(Integer.MAX_VALUE, (int) distances[4]);
		assertEquals(Integer.MAX_VALUE, (int) distances[5]);
		assertEquals(Integer.MAX_VALUE, (int) distances[6]);
		//Verify paths to all nodes
	}

	@Test
	public void negative_edge_path_test()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph6.txt");
		//Remainder of test will wait until bellman is finished.
	}

	@Test
	public void negative_loop_test_1()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph7.txt");
		//Remainder of test will wait until bellman is finished. source is 0
	}

	@Test
	public void negative_loop_test_2()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph7.txt");
		//Remainder of test will wait until bellman is finished. source is 2
	}
	
	@Test
	public void negative_loop_test_3()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph10.txt");
		//Remainder of test will wait until bellman is finished. source is 0
	}

}

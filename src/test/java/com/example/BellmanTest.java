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
		assertTrue(result);
		assertEquals(0, (int)distances[0]);
		assertEquals(4, (int)distances[2]);
		assertEquals(1, (int)distances[3]);
		assertEquals(6, (int)distances[4]);
		assertEquals(2, (int)distances[5]);

	}
	
	@Test
	public void edge_traversal_test_2()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph1.txt");
		double[] distances = new double[graph.size()];
		int[] predecessors = new int[graph.size()];

		boolean result = graph.run_bellman_ford(1, distances, predecessors);
		assertTrue(result);
		assertEquals(0, (int) distances[1]);
		assertTrue(Double.isInfinite(distances[2]));
		assertTrue(Double.isInfinite(distances[3]));
		assertTrue(Double.isInfinite(distances[4]));
		assertTrue(Double.isInfinite(distances[5]));
	}

	@Test
	public void edge_traversal_test_3()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph2.txt");
		double[] distances = new double[graph.size()];
		int[] predecessors = new int[graph.size()];

		boolean result = graph.run_bellman_ford(1, distances, predecessors);
		assertTrue(result);
		assertTrue(Double.isInfinite(distances[0]));
	}

	@Test
	public void shortest_path_test_1()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph2.txt");
		double[] costs = new double[graph.size()];
		int[] preds = new int[graph.size()];

		boolean result = graph.run_bellman_ford(0, costs, preds);
		assertTrue(result);
		assertEquals(4, (int) costs[2]);
		assertEquals(1, preds[2]);
		assertEquals(0, preds[1]);
		
	}

	@Test
	public void shortest_path_test_2()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph2.txt");
		double[] costs = new double[graph.size()];
		int[] preds = new int[graph.size()];

		boolean result = graph.run_bellman_ford(0, costs, preds);
		assertTrue(result);
		assertEquals(24, (int) costs[3]);
		assertEquals(2, (int) preds[3]);
	}

	@Test
	public void loops_test_1()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph3.txt");
		double[] distances = new double[graph.size()];
		int[] preds = new int[graph.size()];
		
		boolean result = graph.run_bellman_ford(0, distances, preds);
		assertTrue(result);
		assertEquals(0, preds[1]);
		assertEquals(1, preds[2]);
	}

	@Test
	public void loops_test_2()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph5.txt");
		double[] distances = new double[graph.size()];
		int[] preds = new int[graph.size()];
		
		boolean result = graph.run_bellman_ford(0, distances, preds);
		assertTrue(result);
		assertEquals(0, preds[1]);
		assertEquals(1, preds[2]);
	}

	@Test
	public void disconnected_graph_test()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph4.txt");
		double[] costs = new double[graph.size()];
		int[] preds = new int[graph.size()];
		
		boolean result = graph.run_bellman_ford(0, costs, preds);
		assertTrue(result);
		assertTrue(Double.isInfinite(costs[4]));
		assertTrue(Double.isInfinite(costs[5]));
		assertTrue(Double.isInfinite(costs[6]));
		assertTrue(Double.isInfinite(costs[2]));
		assertEquals(0, preds[1]);
		assertEquals(1, preds[3]);
	}

	@Test
	public void negative_edge_path_test()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph6.txt");
		double[] costs = new double[graph.size()];
		int[] preds = new int[graph.size()];
		
		boolean result = graph.run_bellman_ford(0, costs, preds);
		assertTrue(result);
		assertEquals(10, (int)costs[5]);
		assertEquals(4, preds[5]);
		assertEquals(2, preds[4]);
		assertEquals(0, preds[2]);

	}

	@Test
	public void negative_loop_test_1()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph7.txt");
		double[] costs = new double[graph.size()];
		int[] preds = new int[graph.size()];
		
		boolean result = graph.run_bellman_ford(0, costs, preds);
		assertFalse(result);
	}

	@Test
	public void negative_loop_test_2()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph7.txt");
		double[] costs = new double[graph.size()];
		int[] preds = new int[graph.size()];
		
		boolean result = graph.run_bellman_ford(0, costs, preds);
		assertFalse(result);
	}
	
	@Test
	public void negative_loop_test_3()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph11.txt");
		double[] costs = new double[graph.size()];
		int[] preds = new int[graph.size()];
		
		boolean result = graph.run_bellman_ford(0, costs, preds);
		assertFalse(result);
	}

}

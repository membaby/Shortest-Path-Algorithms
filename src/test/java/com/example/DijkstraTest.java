package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.graph.Graph;
import com.example.graph.IGraph;


public class DijkstraTest {

	@Test
	public void edge_traversal_test_1()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph1.txt");
		double[] distances = new double[graph.size()];
		int[] predecessors = new int[graph.size()];
		graph.run_dijkstra(0, distances, predecessors);
		assertEquals(0, (int)distances[0]);
		assertEquals(3, (int)distances[1]);
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
		graph.run_dijkstra(1, distances, predecessors);
		assertTrue(Double.isInfinite(distances[0]));
		assertEquals(0, (int)distances[1]);
		assertTrue(Double.isInfinite(distances[2]));
		assertTrue(Double.isInfinite(distances[3]));
		assertTrue(Double.isInfinite(distances[4]));
		assertTrue(Double.isInfinite(distances[5]));
	}

	// @Test
	// public void edge_traversal_test_3()
	// {
	// 	IGraph graph = new Graph();
	// 	graph.loadGraphFromFile("TestGraphs/graph2.txt");
	// 	double[] distances = new double[graph.size()];
	// 	int[] predecessors = new int[graph.size()];
	// 	graph.run_dijkstra(1, distances, predecessors);
	// 	assertTrue(Double.isInfinite(distances[0]));
	// }

	@Test
	public void shortest_path_test_1()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph2.txt");
		double[] distances = new double[graph.size()];
		int[] predecessors = new int[graph.size()];
		graph.run_dijkstra(0, distances, predecessors);
		assertEquals(4, (int)distances[2]);
	}

	@Test
	public void shortest_path_test_2()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph2.txt");
		double[] distances = new double[graph.size()];
		int[] predecessors = new int[graph.size()];
		graph.run_dijkstra(0, distances, predecessors);
		assertEquals(24, (int)distances[3]);
	}

	@Test
	public void loops_test_1()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph3.txt");
		double[] costs = new double[graph.size()];
		int[] preds = new int[graph.size()];
		graph.run_dijkstra(0, costs, preds);
		assertEquals(0, preds[1]);
		assertEquals(1, preds[2]);
	}
	
	@Test
	public void loops_test_2()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph5.txt");
		double[] costs = new double[graph.size()];
		int[] preds = new int[graph.size()];
		graph.run_dijkstra(0, costs, preds);
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
		graph.run_dijkstra(0, costs, preds);
		assertTrue(Double.isInfinite(costs[4]));
		assertTrue(Double.isInfinite(costs[5]));
		assertTrue(Double.isInfinite(costs[6]));
		//Verify paths to all nodes
		assertTrue(Double.isInfinite(costs[2]));
		assertEquals(0, preds[1]);
		assertEquals(1, preds[3]);
	}

}

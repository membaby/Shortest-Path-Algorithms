package com.example;

import static org.junit.Assert.assertEquals;
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
		assertEquals(0, Double.valueOf(distances[0]).intValue());
		assertEquals(4, Double.valueOf(distances[2]).intValue());
		assertEquals(1, Double.valueOf(distances[3]).intValue());
		assertEquals(6, Double.valueOf(distances[4]).intValue());
		assertEquals(2, Double.valueOf(distances[5]).intValue());
	}
	
	@Test
	public void edge_traversal_test_2()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph1.txt");
		double[] distances = new double[graph.size()];
		int[] predecessors = new int[graph.size()];
		graph.run_dijkstra(1, distances, predecessors);
		assertEquals(Integer.MAX_VALUE, Double.valueOf(distances[0]).intValue());
		assertEquals(0, Double.valueOf(distances[1]).intValue());
		assertEquals(Integer.MAX_VALUE, Double.valueOf(distances[2]).intValue());
		assertEquals(Integer.MAX_VALUE, Double.valueOf(distances[3]).intValue());
		assertEquals(Integer.MAX_VALUE, Double.valueOf(distances[4]).intValue());
		assertEquals(Integer.MAX_VALUE, Double.valueOf(distances[5]).intValue());
	}

	@Test
	public void edge_traversal_test_3()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph2.txt");
		double[] distances = new double[graph.size()];
		int[] predecessors = new int[graph.size()];
		graph.run_dijkstra(1, distances, predecessors);
		assertEquals(Integer.MAX_VALUE, Double.valueOf(distances[0]).intValue());
	}

	@Test
	public void shortest_path_test_1()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph2.txt");
		double[] distances = new double[graph.size()];
		int[] predecessors = new int[graph.size()];
		graph.run_dijkstra(0, distances, predecessors);
		assertEquals(4, Double.valueOf(distances[2]).intValue());
	}

	@Test
	public void shortest_path_test_2()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph2.txt");
		double[] distances = new double[graph.size()];
		int[] predecessors = new int[graph.size()];
		graph.run_dijkstra(0, distances, predecessors);
		assertEquals(24, Double.valueOf(distances[3]).intValue());
	}

	@Test
	public void loops_test_1()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph3.txt");
		double[] distances = new double[graph.size()];
		int[] predecessors = new int[graph.size()];
		graph.run_dijkstra(0, distances, predecessors);
		//Check path to node 1 and 2 doesn't include loops. Currently can't do it because djikstra doesn't return paths.
	}

	@Test
	public void loops_test_2()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph5.txt");
		double[] distances = new double[graph.size()];
		int[] predecessors = new int[graph.size()];
		graph.run_dijkstra(0, distances, predecessors);
		//Check path to node 1 and 2 doesn't include loops. Currently can't do it because djikstra doesn't return paths.
	}

	@Test
	public void disconnected_graph_test()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph4.txt");
		double[] distances = new double[graph.size()];
		int[] predecessors = new int[graph.size()];
		graph.run_dijkstra(0, distances, predecessors);
		assertEquals(Integer.MAX_VALUE, Double.valueOf(distances[4]).intValue());
		assertEquals(Integer.MAX_VALUE, Double.valueOf(distances[5]).intValue());
		assertEquals(Integer.MAX_VALUE, Double.valueOf(distances[6]).intValue());
		//Verify paths to all nodes
	}

}

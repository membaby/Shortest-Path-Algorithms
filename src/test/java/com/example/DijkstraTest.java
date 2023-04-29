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
		int[] result = graph.run_dijkstra(0);
		assertEquals(0, result[0]);
		assertEquals(4, result[2]);
		assertEquals(1, result[3]);
		assertEquals(6, result[4]);
		assertEquals(2, result[5]);
	}
	
	@Test
	public void edge_traversal_test_2()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraph/graph1.txt");
		
		int[] result = graph.run_dijkstra(1);
		assertEquals(Integer.MAX_VALUE, result[0]);
		assertEquals(0, result[1]);
		assertEquals(Integer.MAX_VALUE, result[2]);
		assertEquals(Integer.MAX_VALUE, result[3]);
		assertEquals(Integer.MAX_VALUE, result[4]);
		assertEquals(Integer.MAX_VALUE, result[5]);
	}

	@Test
	public void edge_traversal_test_3()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraph/graph2.txt");
		int[] result = graph.run_dijkstra(1);
		assertEquals(Integer.MAX_VALUE, result[0]);
	}

	@Test
	public void shortest_path_test_1()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraph/graph2.txt");
		int[] result = graph.run_dijkstra(0);
		assertEquals(4, result[2]);
	}

	@Test
	public void shortest_path_test_2()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraph/graph2.txt");
		int[] result = graph.run_dijkstra(0);
		assertEquals(24, result[3]);
	}

	@Test
	public void loops_test_1()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph3.txt");
		int[] result = graph.run_dijkstra(0);
		//Check path to node 1 and 2 doesn't include loops. Currently can't do it because djikstra doesn't return paths.
	}

	@Test
	public void loops_test_2()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph5.txt");
		int[] result = graph.run_dijkstra(0);
		//Check path to node 1 and 2 doesn't include loops. Currently can't do it because djikstra doesn't return paths.
	}

	@Test
	public void disconnected_graph_test()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph4.txt");
		int[] result = graph.run_dijkstra(0);
		assertEquals(Integer.MAX_VALUE, result[4]);
		assertEquals(Integer.MAX_VALUE, result[5]);
		assertEquals(Integer.MAX_VALUE, result[6]);
		//Verify paths to all nodes
	}

}

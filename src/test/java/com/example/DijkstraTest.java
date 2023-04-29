package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.ArrayList;


import com.example.graph.Graph;
import com.example.graph.IGraph;


public class DijkstraTest {
	
	@Test
	public void edge_traversal_test1()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph1.txt");
		ArrayList<Integer> result = graph.run_dijkstra(0);
		assertEquals(Integer.MAX_VALUE, result.get(0).intValue());
		assertEquals(3, result.get(1).intValue());
		assertEquals(4, result.get(2).intValue());
		assertEquals(1, result.get(3).intValue());
		assertEquals(6, result.get(4).intValue());
		assertEquals(2, result.get(5).intValue());
	}
	
	@Test
	public void edge_traversal_test2()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraph/graph1.txt");
		ArrayList<Integer> result = graph.run_dijkstra(1);
		assertEquals(Integer.MAX_VALUE, result.get(0).intValue());
		assertEquals(Integer.MAX_VALUE, result.get(1).intValue());
		assertEquals(Integer.MAX_VALUE, result.get(2).intValue());
		assertEquals(Integer.MAX_VALUE, result.get(3).intValue());
		assertEquals(Integer.MAX_VALUE, result.get(4).intValue());
		assertEquals(Integer.MAX_VALUE, result.get(5).intValue());
	}

	@Test
	public void shortest_path_test()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraph/graph2.txt");
		ArrayList<Integer> result = graph.run_dijkstra(0);
		assertEquals(4, result.get(2).intValue());
	}
}

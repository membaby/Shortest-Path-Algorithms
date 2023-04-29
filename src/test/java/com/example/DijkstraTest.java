package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


import com.example.graph.Graph;
import com.example.graph.IGraph;


public class DijkstraTest {

	IGraph graph;
	@Before
	public void setUp() throws Exception {
		graph = new Graph();
	}
	
	@Test
	public void edge_traversal_test1()
	{
		graph.loadGraphFromFile("TestGraphs/graph1.txt");
		int[] result = graph.run_dijkstra(0);
		assertEquals(0, result[0]);
		assertEquals(4, result[2]);
		assertEquals(1, result[3]);
		assertEquals(6, result[4]);
		assertEquals(2, result[5]);
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

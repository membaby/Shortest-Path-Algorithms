package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
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
		graph.loadGraphFromFile("TestGraphs/graph1.txt");
		int[] result = graph.run_dijkstra(1);
		assertEquals(Integer.MAX_VALUE, result[0]);
		assertEquals(0, result[1]);
		assertEquals(Integer.MAX_VALUE, result[2]);
		assertEquals(Integer.MAX_VALUE, result[3]);
		assertEquals(Integer.MAX_VALUE, result[4]);
		assertEquals(Integer.MAX_VALUE, result[5]);
	}

	@Test
	public void shortest_path_test()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph2.txt");
		int[] result = graph.run_dijkstra(0);
		assertEquals(4, result[2]);
	}
}

package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.example.graph.Graph;
import com.example.graph.IGraph;


public class GraphTest {
	

	@Test
	public void build_graph1_test()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph1.txt");
		//Confirm number of vertices.
		assertEquals(6, graph.size());
		boolean contains;
		ArrayList<Integer> vertices = graph.getVertices();
		contains = vertices.contains(0);
		assertTrue(contains);
		contains = vertices.contains(1);
		assertTrue(contains);
		contains = vertices.contains(2);
		assertTrue(contains);
		contains = vertices.contains(3);
		assertTrue(contains);
		contains = vertices.contains(4);
		assertTrue(contains);
		contains = vertices.contains(5);
		assertTrue(contains);
		
	}
}

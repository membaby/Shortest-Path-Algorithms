package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.example.graph.Graph;
import com.example.graph.IGraph;

public class WarshallTest {
	
	@Test
	public void simple_path_test_1()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph8.txt");
		int n = graph.size();
		Integer[][] costs = new Integer[n][n];
		int[][] preds = new int[n][n];
		boolean b = graph.run_floyd_warshall(costs, preds);
		assertTrue(b);
		//Cost assertions
		assertEquals(0, costs[0][0].intValue());
		assertEquals(0, costs[1][1].intValue());
		assertEquals(0, costs[2][2].intValue());
		assertEquals(0, costs[3][3].intValue());
		assertEquals(0, costs[4][4].intValue());
		assertEquals(1, costs[0][1].intValue());
		assertEquals(1, costs[0][2].intValue());
		assertEquals(2, costs[0][3].intValue());
		assertEquals(2, costs[0][4].intValue());
		assertEquals(2, costs[1][0].intValue());
		assertEquals(2, costs[1][2].intValue());
		assertEquals(1, costs[1][3].intValue());
		assertEquals(3, costs[1][4].intValue());
		assertEquals(3, costs[2][0].intValue());
		assertEquals(1, costs[2][1].intValue());
		assertEquals(2, costs[2][3].intValue());
		assertEquals(1, costs[2][4].intValue());
		assertEquals(1, costs[3][0].intValue());
		assertEquals(2, costs[3][1].intValue());
		assertEquals(1, costs[3][2].intValue());
		assertEquals(2, costs[3][4].intValue());
		assertEquals(3, costs[4][0].intValue());
		assertEquals(1, costs[4][1].intValue());
		assertEquals(3, costs[4][2].intValue());
		assertEquals(2, costs[4][3].intValue());
		//Parent assertions
		assertEquals(0, preds[0][1]);
		assertEquals(0, preds[0][2]);
		assertEquals(1, preds[0][3]);
		assertEquals(2, preds[0][4]);
		assertEquals(3, preds[1][0]);
		assertEquals(3, preds[1][2]);
		assertEquals(1, preds[1][3]);
		assertEquals(2, preds[1][4]);
		assertEquals(3, preds[2][0]);
		assertEquals(2, preds[2][1]);
		assertEquals(1, preds[2][3]);
		assertEquals(2, preds[2][4]);
		assertEquals(3, preds[3][0]);
		//Two possible paths from 3 to 1
		boolean expected = preds[3][1] == 0 || preds[3][1] == 2;
		assertTrue(expected);
		assertEquals(3, preds[3][2]);
		assertEquals(2, preds[3][4]);
		assertEquals(3, preds[4][0]);
		assertEquals(4, preds[4][1]);
		assertEquals(3, preds[4][2]);
		assertEquals(1, preds[4][3]);
	}

	@Test
	public void simple_path_test_2()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph9.txt");
		int n = graph.size();
		Integer[][] costs = new Integer[n][n];
		int[][] preds = new int[n][n];
		boolean b = graph.run_floyd_warshall(costs, preds);
		assertTrue(b);
		assertEquals(Integer.MAX_VALUE, costs[0][2].intValue());
		assertEquals(Integer.MAX_VALUE, costs[1][2].intValue());
		assertEquals(Integer.MAX_VALUE, costs[3][2].intValue());
		assertEquals(Integer.MAX_VALUE, costs[4][2].intValue());
	}

	@Test
	public void negative_loop_test_1()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph7.txt");
		int n = graph.size();
		Integer[][] costs = new Integer[n][n];
		int[][] preds = new int[n][n];
		boolean b = graph.run_floyd_warshall(costs, preds);
		assertFalse(b);
	}

	@Test
	public void negative_loop_test_2()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph11.txt");
		int n = graph.size();
		Integer[][] costs = new Integer[n][n];
		int[][] preds = new int[n][n];
		boolean b = graph.run_floyd_warshall(costs, preds);
		assertFalse(b);
	}

	@Test
	public void correct_paths_test()
	{
		IGraph graph = new Graph();
		graph.loadGraphFromFile("TestGraphs/graph10.txt");
		int n = graph.size();
		Integer[][] costs = new Integer[n][n];
		int[][] preds = new int[n][n];
		boolean b = graph.run_floyd_warshall(costs, preds);
		assertTrue(b);
		//Cost assertions
		assertEquals(0, costs[0][0].intValue());
		assertEquals(0, costs[1][1].intValue());
		assertEquals(0, costs[2][2].intValue());
		assertEquals(0, costs[3][3].intValue());
		assertEquals(3, costs[0][1].intValue());
		assertEquals(3, costs[0][2].intValue());
		assertEquals(3, costs[0][3].intValue());
		assertEquals(3, costs[1][1].intValue());
		assertEquals(3, costs[1][1].intValue());
		assertEquals(3, costs[1][1].intValue());
		assertEquals(3, costs[2][1].intValue());
		assertEquals(3, costs[2][2].intValue());
		assertEquals(3, costs[2][3].intValue());
		assertEquals(3, costs[3][1].intValue());
		assertEquals(3, costs[3][1].intValue());
		assertEquals(3, costs[3][1].intValue());
	}


}

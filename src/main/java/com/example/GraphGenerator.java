package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;


public class GraphGenerator
{
	final static int MAX_EDGE_WEIGHT = 50;

	public static void main(String[] args) 
	{
		generate(100, 0.75f);
	}


	public static void generate(int numOfNodes, float density)
	{
		int edgesPerNode = (int)((numOfNodes-1) * density);
		HashMap<Integer, HashSet<Integer>> adjMap = new HashMap<Integer, HashSet<Integer>>(numOfNodes);
		for (int i=0; i<numOfNodes; i++)// Creating nodes
		{
			adjMap.put(i, new HashSet<Integer>(edgesPerNode));
			if (density == 1)
			{
				for (int j=0; j < numOfNodes; j++)
				{
					if (j == i) continue;
					adjMap.get(i).add(j);
				}
				continue;
			}
			int created = 0;
			while (created < edgesPerNode)
			{
				int target = new Random().nextInt(numOfNodes);
				if (target == i) continue;
				else if (adjMap.get(i).contains(target)) continue;
				adjMap.get(i).add(target);
				created++;
			}
		}
		
		try
		{
			String name = "TimeComparison/" + numOfNodes + "-" + density + ".txt";
			FileWriter writer = new FileWriter(name);
			writer.write(numOfNodes + " " + numOfNodes*edgesPerNode + "\n");
			for (int i=0; i < numOfNodes; i++)
			{
				for (Integer j : adjMap.get(i))
				{
					int weight = new Random().nextInt(MAX_EDGE_WEIGHT);
					writer.write(i + " " + j.toString() + " " + weight + "\n");
				}
			}
			writer.close();
		} catch(IOException e)
		{
			System.out.println("Error while generating random graph");
		}

	}

}
package com.example;
import com.example.graph.*;

public class ShortestPathAlgorithm {
    public static void main( String[] args )
    {
        System.out.println( "[ Shortest Path Algorithms ]" );
        System.out.println("Status: Loading Graph");

        Graph graph = new Graph();
        graph.loadGraphFromFile("D:/Freelancer/Projects/Current/Shortest-Path-Algorithms/TestGraphs/graph4.txt");        
        System.out.println("Status: Graph Loaded. (Size: " + graph.size() + ")");

        System.out.println("Status: Running Dijkstra's Algorithm");
        
        int[] distances = new int[graph.size()];
        int[] predecessors = new int[graph.size()];
        graph.run_dijkstra(0, distances, predecessors);
        
        System.out.println("Distances:");
        for (int i = 0; i < distances.length; i++){
            System.out.println(distances[i]);
        }
        System.out.println("Predecessors:");
        for (int i = 0; i < predecessors.length; i++){
            System.out.println(predecessors[i]);
        }

        System.out.println("Status: Dijkstra's Algorithm Completed");

        System.out.println("Status: Running Bellman-Ford Algorithm");
        // graph.run_bellman_ford();
        System.out.println("Status: Bellman-Ford Algorithm Completed");

        System.out.println("Status: Running Floyd-Warshall Algorithm");
        // graph.run_floyd_warshall();
        System.out.println("Status: Floyd-Warshall Algorithm Completed");

        System.out.println("Status: Finished");
    }
}

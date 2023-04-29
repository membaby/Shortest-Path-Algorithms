package com.example;
import com.example.graph.*;

public class ShortestPathAlgorithm {
    public static void main( String[] args )
    {
        System.out.println( "[ Shortest Path Algorithms ]" );
        System.out.println("Status: Loading Graph");

        Graph graph = new Graph();
        graph.loadGraphFromFile("D:/Freelancer/Projects/Current/Shortest-Path-Algorithms/src/main/java/com/example/data/graph1.txt");        
        System.out.println("Status: Graph Loaded. (Size: " + graph.size() + ")");

        System.out.println("Status: Running Dijkstra's Algorithm");
        // graph.run_dijkstra();
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

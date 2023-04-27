package com.example;
import com.example.Graph;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Graph g = new Graph("D:/JavaProjects/Shortest-Path-Algorithms/graph1.txt");
        System.out.println(g.size());

        int[] costs = new int[g.size()];
        int[] parents = new int[g.size()];
        
        g.dijkstra(1, costs, parents);
    }
}

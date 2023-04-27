package com.example;
import com.example.Dijkstra;
import com.example.BellmanFord;
import com.example.FloydWarshall;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Graph {
    // Adjacency List to store the graph
    private Map<Integer, List<Edge>> adjList;
    
    // Edge class to represent edges in the graph
    static class Edge{
        int to;
        int weight;

        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    public Graph(String filePath) {
        adjList = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int numVertices = 0;
            int numEdges = 0;
            int lineNum = 0;

            while ((line = br.readLine()) != null) {
                if (lineNum == 0) {
                    // First line contains the number of vertices and edges
                    String[] tokens = line.split("\\s+");
                    numVertices = Integer.parseInt(tokens[0]);
                    numEdges = Integer.parseInt(tokens[1]);
                } else {
                    // Remaining lines contain the edges
                    String[] tokens = line.split("\\s+");
                    int u = Integer.parseInt(tokens[0]);
                    int v = Integer.parseInt(tokens[1]);
                    int weight = Integer.parseInt(tokens[2]);

                    if (!adjList.containsKey(u)) {
                        adjList.put(u, new ArrayList<>());
                    }
                    if (!adjList.containsKey(v)) {
                        adjList.put(v, new ArrayList<>());
                    }
                    adjList.get(u).add(new Edge(v, weight));
                }

                lineNum++;
            }

            if (lineNum - 1 != numEdges) {
                throw new IOException("Number of edges in the file does not match the given value.");
            }
            
            if (adjList.size() != numVertices) {
                System.out.println(numVertices);
                throw new IOException("Number of vertices in the file does not match the given value.");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            e.printStackTrace(); // or handle the exception as needed
        }
    }


    public int size(){
        return adjList.size();
    }

    public void dijkstra(int source, int[] costs, int[] parents){
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstra(source, costs, parents, adjList);
    }

    public void bellmanFord(int source, int[] costs, int[] parents){
        BellmanFord bellmanFord = new BellmanFord();
        bellmanFord.bellmanFord(source, costs, parents, adjList);
    }

    public void floydWarshall(int[][] costs, int[][] parents){
        FloydWarshall floydWarshall = new FloydWarshall();
        floydWarshall.floydWarshall(costs, parents, adjList);
    }
}

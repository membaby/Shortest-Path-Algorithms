package com.example.graph;
import com.example.algorithms.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graph implements IGraph {
    // adjacency list to store the graph
    private ArrayList<ArrayList<Node>> adjList = new ArrayList<ArrayList<Node>>();
    private ArrayList<Edge> edgeList = new ArrayList<Edge>();
    private Integer[][] graph;
    private int size, sizeTest;
    // private ArrayList<Integer> processedOrder;

    @Override
    public void loadGraphFromFile(String filePath){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int numVertices = 0;
            int numEdges = 0;
            int lineNum = 0;

            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("\\s+");
                if (lineNum == 0) {
                    // First line contains the number of vertices and edges
                    numVertices = Integer.parseInt(tokens[0]);
                    graph = new Integer[numVertices][numVertices];
                    numEdges = Integer.parseInt(tokens[1]);
                    sizeTest = numVertices;
                    size = numVertices;
                    for (int i = 0; i < numVertices; i++) {
                        adjList.add(new ArrayList<Node>());
                    }

                } else {
                    // Remaining lines contain the edges
                    int u = Integer.parseInt(tokens[0]);
                    int v = Integer.parseInt(tokens[1]);
                    int weight = Integer.parseInt(tokens[2]);

                    edgeList.add(new Edge(u, v, weight));
                    adjList.get(u).add(new Node(v, weight));
                    graph[u][v] = weight;
                }

                lineNum++;
            }
            
            if (lineNum - 1 != numEdges) {
                throw new IOException("Number of edges in the file does not match the given value.");
            }
            
            if (adjList.size() != numVertices) {
                System.out.println(numVertices);
                System.out.println(adjList.size());
                throw new IOException("Number of vertices in the file does not match the given value.");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            e.printStackTrace(); // or handle the exception as needed
        }
    }

    @Override
    public int size(){
        return sizeTest;
    }

    @Override
    public ArrayList<Integer> getVertices(){
        ArrayList<Integer> vertices = new ArrayList<Integer>();
        for (int i = 0; i < size; i++){
            vertices.add(i);
        }
        return vertices;
    }

    @Override
    public ArrayList<Integer> getNeighbors(int vertex){
        ArrayList<Integer> neighbors = new ArrayList<Integer>();
        for (int i = 0; i < edgeList.size(); i++){
            Edge e = edgeList.get(i);
            if (e.getFrom() == vertex){
                neighbors.add(e.getTo());
            }
        }
        return neighbors;
    }

    @Override
    public int[] run_dijkstra(int source){
        int[] distances = new int[sizeTest];
        dijkstra DijkstraSolver = new dijkstra(source, distances, adjList, graph);
        int[] shortest_path = DijkstraSolver.get_shortest_path();
        for (int i = 0; i < shortest_path.length; i++){
            System.out.println(shortest_path[i]);
        }
        return shortest_path;
    }
    
    @Override
    public int[] run_bellman_ford(int source){
        int[] distances = new int[sizeTest];
        bellmanford BellmanFordSolver = new bellmanford(source, distances, adjList, graph, edgeList);
        int[] shortest_path = BellmanFordSolver.get_shortest_path();
        for (int i = 0; i < shortest_path.length; i++){
            System.out.println(shortest_path[i]);
        }
        return shortest_path;
    }
    @Override
    public boolean run_floyd_warshall(){
        Integer[][] c = new Integer[size][size];
        int[][] p = new int[size][size];
        FloydWarshall floydWarshall = new FloydWarshall(graph);
        boolean Ncycles = floydWarshall.floyd_warshall(c,p);
        return Ncycles;
    }
}
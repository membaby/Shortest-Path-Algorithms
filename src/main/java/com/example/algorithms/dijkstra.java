package com.example.algorithms;
import com.example.graph.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class dijkstra {

    // Shortest path from source to all other vertices
    private ArrayList<Integer> shortestPath;

    public dijkstra(final int source, final int[] distances, final ArrayList<ArrayList<Node>> adjList, final Integer[][] graph){
        shortestPath = new ArrayList<Integer>();
        Arrays.fill(distances, Integer.MAX_VALUE / 2);
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        distances[source] = 0;
        queue.add(new Node(source, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            shortestPath.add(node.getV());
            
            for (int i = 0; i < adjList.get(node.getV()).size(); i++) {
                if (distances[adjList.get(node.getV()).get(i).getV()] > distances[node.getV()] + graph[node.getV()][adjList.get(node.getV()).get(i).getV()]){
                    queue.remove(new Node(adjList.get(node.getV()).get(i).getV(), distances[adjList.get(node.getV()).get(i).getV()]));
                    distances[adjList.get(node.getV()).get(i).getV()] = distances[node.getV()] + graph[node.getV()][adjList.get(node.getV()).get(i).getV()];
                    queue.add(new Node(adjList.get(node.getV()).get(i).getV(), distances[adjList.get(node.getV()).get(i).getV()]));
                }
            }
        }
    }

    public ArrayList<Integer> get_shortest_path() {
        return shortestPath;
    }
}

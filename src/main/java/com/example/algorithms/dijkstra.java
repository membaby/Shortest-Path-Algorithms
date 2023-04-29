package com.example.algorithms;
import com.example.graph.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class dijkstra {


    public dijkstra(final int source, final int[] distances, final int[] predecessors, final ArrayList<ArrayList<Node>> adjList, final Integer[][] graph){
        Arrays.fill(distances, Integer.MAX_VALUE);
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        distances[source] = 0;
        queue.add(new Node(source, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            for (int i = 0; i < adjList.get(node.getV()).size(); i++) {
                if (distances[adjList.get(node.getV()).get(i).getV()] > distances[node.getV()] + graph[node.getV()][adjList.get(node.getV()).get(i).getV()]){
                    queue.remove(new Node(adjList.get(node.getV()).get(i).getV(), distances[adjList.get(node.getV()).get(i).getV()]));
                    distances[adjList.get(node.getV()).get(i).getV()] = distances[node.getV()] + graph[node.getV()][adjList.get(node.getV()).get(i).getV()];
                    queue.add(new Node(adjList.get(node.getV()).get(i).getV(), distances[adjList.get(node.getV()).get(i).getV()]));
                    predecessors[adjList.get(node.getV()).get(i).getV()] = node.getV();
                }
            }
        }
    }
}

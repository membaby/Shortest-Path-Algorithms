package com.example.algorithms;
import com.example.graph.*;
import java.util.ArrayList;
import java.util.Arrays;

// int source, int[] costs, int[] parents, Map<Integer, List<Graph.Edge>> graph
public class bellmanford {

    private int[] final_distances;
    private boolean negative_cycle = false;

    public bellmanford(final int source, int[] distances, final ArrayList<ArrayList<Node>> adjList, final Integer[][] graph, final ArrayList<Edge> edgeList){
        final_distances = new int[distances.length];
        // Initialize the costs and parents arrays
        Arrays.fill(distances, Integer.MAX_VALUE);
        // Set the source vertex distance to 0
        distances[source] = 0;
        // set n to the number of vertices in the graph
        int n = distances.length;
        for (int i = 0; i < n - 1; i++) {
            for (int u = 0; u < edgeList.size(); u++) {
                Edge edge = edgeList.get(u);
                if (distances[edge.getFrom()] != Integer.MAX_VALUE && distances[edge.getFrom()] + edge.getWeight() < distances[edge.getTo()]){
                    distances[edge.getTo()] = distances[edge.getFrom()] + edge.getWeight();
                }
            }
        }

        /*
         * Run algorithm a second time to detect which nodes are part
         * of a negative cycle. A negative cycle has occurred if we
         * can find a better path beyond the optimal solution.
        */

        for (int i = 0; i < n - 1; i++) {
            for (int u = 0; u < edgeList.size(); u++) {
                Edge edge = edgeList.get(u);
                int v = edge.getTo();
                int w = edge.getWeight();
                if (distances[edge.getFrom()] != Integer.MAX_VALUE && distances[edge.getFrom()] + w < distances[v]){
                    distances[edge.getTo()] = Integer.MIN_VALUE;
                }
            }
        }
        final_distances = distances;

        //return if there is a negative cycle
        for (int i = 0; i < n; i++) {
            if (distances[i] == Integer.MIN_VALUE) {
                negative_cycle = true;
            }
        }
    }

    public boolean get_negative_cycle(){
        return negative_cycle;
    }

    public int[] get_shortest_path() {
        return final_distances;
    }
}

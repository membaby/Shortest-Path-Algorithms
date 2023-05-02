package com.example.algorithms;
import com.example.graph.*;
import java.util.ArrayList;
import java.util.Arrays;

public class bellmanford {

    private boolean negative_cycle = false;

    public bellmanford(final int source, final double[] distances, final int[] predecessors, final ArrayList<ArrayList<Node>> adjList, final Integer[][] graph, final ArrayList<Edge> edgeList){
        // Initialize the costs and parents arrays
        Arrays.fill(distances, Double.POSITIVE_INFINITY);
        // Set the source vertex distance to 0
        distances[source] = 0;
        // set n to the number of vertices in the graph
        int n = distances.length;
        for (int i = 0; i < n - 1; i++) {
            for (int u = 0; u < edgeList.size(); u++) {
                Edge edge = edgeList.get(u);
                if (distances[edge.getFrom()] != Double.POSITIVE_INFINITY && distances[edge.getFrom()] + edge.getWeight() < distances[edge.getTo()]){
                    distances[edge.getTo()] = distances[edge.getFrom()] + edge.getWeight();
                    predecessors[edge.getTo()] = edge.getFrom();
                }
            }
        }

        /*
         * Run algorithm a second time to detect which nodes are part
         * of a negative cycle. A negative cycle has occurred if we
         * can find a better path beyond the optimal solution.
        */

        for (int u = 0; u < edgeList.size(); u++) {
            Edge edge = edgeList.get(u);
            if (distances[edge.getFrom()] != Double.POSITIVE_INFINITY && distances[edge.getFrom()] + edge.getWeight() < distances[edge.getTo()]){
                distances[edge.getTo()] = Double.NEGATIVE_INFINITY;
            }
        }

        //return if there is a negative cycle
        for (int i = 0; i < n; i++) {
            if (distances[i] == Double.NEGATIVE_INFINITY) {
                negative_cycle = true;
            }
        }
    }
    
    public boolean getNegativeCycle(){
        return !negative_cycle;
    }

}

package com.example;
import java.util.*;

public class BellmanFord {
    public int[] bellmanFord(int source, int[] costs, int[] parents, Map<Integer, List<Graph.Edge>> graph) {
        // Initialize the costs and parents arrays
        Arrays.fill(costs, Integer.MAX_VALUE) ;
        // Set the source vertex distance to 0
        costs[source] = 0 ;
        // set n to the number of vertices in the graph
        int n = costs.length ;
        //for each vertex u in the graph apply relaxation for all the edges
        for ( int i = 0 ; i < n - 1 ; i++ ) {
            for ( int u = 0 ; u < n ; u++ ) {
                for ( Graph.Edge edge : graph.get(u) ) {
                    int v = edge.to ;
                    int w = edge.weight ;
                    if ( costs[u] != Integer.MAX_VALUE && costs[u] + w < costs[v] ) {
                        costs[v] = costs[u] + w ;
                        parents[v] = u ;
                    }
                }
            }
        }
        // Run algorithm a second time to detect which nodes are part
        // of a negative cycle. A negative cycle has occurred if we
        // can find a better path beyond the optimal solution.
        for ( int i = 0 ; i < n - 1 ; i++ ) {
            for ( int u = 0 ; u < n ; u++ ) {
                for ( Graph.Edge edge : graph.get(u) ) {
                    int v = edge.to ;
                    int w = edge.weight ;
                    if ( costs[u] != Integer.MAX_VALUE && costs[u] + w < costs[v] ) {
                        costs[v] = Integer.MIN_VALUE ;
                    }
                }
            }
        }
        return costs;
    }
}

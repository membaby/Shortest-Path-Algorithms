package com.example.algorithms;

import java.util.ArrayList;

public class FloydWarshall {
    private int num_v;//number of vertices
    private Integer[][] all_shortest_paths;//the costs matrix with the cost of the shortest path between all pairs of nodes
    private int[][] predecessors;//the predecessors matrix with the appropriate values to reconstruct the paths
    private boolean Ncycle = false;//checks the presence of the negative cycle
    private boolean run = false;//checks if the floyd_warshall has been run

    public FloydWarshall(Integer[][] graph){
        num_v = graph.length;
        predecessors = new int[num_v][num_v];
        //preparing both the predecessors and all_shortest_paths matrices
        for (int i = 0; i <num_v ; i++) {
            for (int j = 0; j < num_v; j++) {
                if(i == j){
                    graph[i][j] = 0;
                }
                if ((i != j && graph[i][j] == 0)||graph[i][j] == null){
                    graph[i][j] = Integer.MAX_VALUE;
                }
                if (graph[i][j] == Integer.MAX_VALUE) {
                    predecessors[i][j] = -1;
                }
                else {
                    predecessors[i][j] = j;
                }
            }
        }
        all_shortest_paths = graph;
    }

    //calculates the all_shortest_paths and predecessors matrices with time complexity of O(v^3) and space complexity of O(v^2)
    public boolean floyd_warshall(Integer [][]c, int [][]p){
        for (int k = 0; k < num_v; k++) {
            for (int i = 0; i < num_v; i++) {
                for (int j = 0; j < num_v; j++) {
                    if (all_shortest_paths[i][k] == Integer.MAX_VALUE || all_shortest_paths[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (all_shortest_paths[i][j] > all_shortest_paths[i][k] + all_shortest_paths[k][j]) {
                        all_shortest_paths[i][j] = all_shortest_paths[i][k] + all_shortest_paths[k][j];
                        predecessors[i][j] = predecessors[k][j];
                    }
                }
            }
        }
        //detects the presences of a negative cycle
        for (int i = 0; i < num_v; i++) {
            if (all_shortest_paths[i][i] < 0) {
                Ncycle = true;
                break;
            }
        }
        run = true;
        c = all_shortest_paths;
        p = predecessors;
        return Ncycle;
    }

    //calculates the path from u to e with time complexity(v)
    public ArrayList<Integer> GetShortestPath(int u,int e){
        ArrayList<Integer> path = new ArrayList<>();
        if (run) {
            if (predecessors[u][e] == -1){
                return path;
            }
            path.add(u);
            while (u != e){
                u = predecessors[u][e];
                path.add(u);
            }
        }
        else {
            floyd_warshall(all_shortest_paths,predecessors);
            GetShortestPath(u,e);
        }
        return path;
    }



}

package com.example.graph;
import java.util.ArrayList;
import java.util.List;

// The Interface IGraph is implemented by Graph.java
public interface IGraph {

    /*
     * Loads the graph from a file. The file is a text file. Each line of the file
     * contains a vertex followed by a list of adjacent vertices.
     * 
     * @param fileName - the name of the file
     */
    public void loadGraphFromFile(String fileName);
    
    
    /*
     * Returns the number of vertices in the graph.
     * @return size of the graph
     */
    public int size();

    /*
     * Returns the list of vertices in the graph.
     * @return list of vertices
     */
    public ArrayList<Integer> getVertices();

    /*
     * Returns the list of neighbors of a vertex.
     * @param vertex - the vertex
     * @return list of neighbors
     */
    public ArrayList<Integer> getNeighbors(int vertex);


	public int[] run_dijkstra(int source);

	public int[] run_bellman_ford(int source);

    public boolean run_floyd_warshall();

}

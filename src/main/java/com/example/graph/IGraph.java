package com.example.graph;
import java.util.ArrayList;

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


	public ArrayList<Integer> run_dijkstra();

	public int[] run_bellman_ford();

}

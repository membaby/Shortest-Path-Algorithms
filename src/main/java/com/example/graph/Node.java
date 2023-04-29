package com.example.graph;

public class Node implements Comparable<Node> {
    
    // Weight of the edge
    private Integer v, weight;

    /*
     * Constructor for Node class
     * @param v - the vertex
     * @param weight - the weight of the edge
     */
    public Node(final Integer v, final Integer weight) {
        this.v = v;
        this.weight = weight;
    }

    /*
     * Returns the vertex
     * @return the vertex
     */
    public int getV() {
        return v;
    }

    /*
     * Returns the weight of the edge
     * @return the weight of the edge
     */
    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(final Node o) {
        return this.weight.compareTo(o.weight);
    }
}

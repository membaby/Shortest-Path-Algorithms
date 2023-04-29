package com.example.graph;

public class Edge {
    // Edge class to represent edges in the graph

    private Integer from, to, weight;

    /*
     * Gets the vertex from
     * @return the vertex from
     */
    public Integer getFrom(){
        return from;
    }

    /*
     * Gets the vertex to
     * @return the vertex to
     */
    public Integer getTo(){
        return to;
    }

    /*
     * Gets the weight of the edge
     * @return the weight of the edge
     */
    public Integer getWeight(){
        return weight;
    }

    /*
     * Constructor for Edge class
     * @param from - the vertex from
     * @param to - the vertex to
     * @param weight - the weight of the edge
     */
    public Edge(final Integer from, final Integer to, final Integer weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

package com.matthewddiaz.datastructures.graphs;

/**
 * Created by matthewdiaz on 7/23/17.
 */
public class Edge<T> {
    private Vertex<T> source;
    private Vertex<T> destination;

    public Edge(Vertex<T> s, Vertex<T> d) {
        source = s;
        destination = d;
    }

    public Vertex<T> getSource() {
        return this.source;
    }

    public Vertex<T> getDestination() {
        return this.destination;
    }

    public void setSource(Vertex<T> source) {
        this.source = source;
    }

    public void setDestination(Vertex<T> destination) {
        this.destination = destination;
    }

    @Override
    public String toString(){
        return "source vertex: " + this.source.getId() +
                ", destination vertex: " + this.destination.getId();
    }
}

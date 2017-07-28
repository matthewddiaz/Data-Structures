package com.matthewddiaz.datastructures.graphs;

import com.matthewddiaz.datastructures.graphs.weightedGraphs.WeightedEdge;

import java.util.*;

/**
 * Created by matthewdiaz on 5/15/17.
 */
public abstract class Graph<T extends Comparable> {
    //vertexSet is a map that relates key: vertex id to value: vertex
    private Map<T, Vertex<T>> vertexSet;

    /**
     * Default Graph constructor with a list of vertices and creates an
     * empty edgeSet. The graph has no edges.
     */
    public Graph(Set<Vertex<T>> vertexSet){
        //convert input set into Map. Creates relation of vertex.id with the actual vertex
        this.vertexSet = transformSetToMap(vertexSet);
    }

    /**
     *
     * @param vertexSet input set of vertices
     * @return a map of the vertices; each entry has the relation key: vertex.id; value: vertex
     */
    private Map<T, Vertex<T>> transformSetToMap(Set<Vertex<T>> vertexSet){
        Map<T, Vertex<T>> map = new HashMap();

        for(Vertex<T> vertex: vertexSet){
            map.put(vertex.id, vertex);
        }
        return map;
    }

    /**
     *
     * @param source
     * @param destination
     * @return
     * @throws Exception
     */
    protected boolean validateEdge(Vertex<T> source, Vertex<T> destination) throws Exception{
        if(source == null || destination == null){
            return false;
        }

        //check if edge is valid. Depends on if Graph is Directed or UnDirected(self-loops are not allowed)
        if(!isEdgeValid(source, destination)){
            return false;
        }
        return true;
    }

    /**
     * Checks if edge is valid. Depends on the type of graph
     * @param source the first vertex in the pair
     * @param destination the second vertex in the pair
     * @return returns true if the edge is valid
     */
    protected abstract boolean isEdgeValid(Vertex<T> source, Vertex<T> destination);

    /**
     * @param edgeSet a set of edges
     * @return returns true if all of the edges in the set are valid.
     * Note: this method calls isEdgeValid(s,d) on each edge in the set.
     */
    protected boolean isEdgeSetValid(Set<Edge<T>> edgeSet){
        for(Edge<T> edge : edgeSet){
            if(!isEdgeValid(edge.getSource(), edge.getDestination())){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param edgeSet
     * @return
     */
    protected boolean isWeightedEdgeSetValid(Set<WeightedEdge<T>> edgeSet){
        for(Edge<T> edge : edgeSet){
            if(!isEdgeValid(edge.getSource(), edge.getDestination())){
                return false;
            }
        }
        return true;
    }

    public Set<Vertex<T>> getVertexSet(){
        return new TreeSet<>(this.vertexSet.values());
    }

    /**
     *
     * @return
     */
    protected Map<T, Vertex<T>> getVertexMap(){
        return  this.vertexSet;
    }

    /**
     *
     * @param vertex
     */
    public void setVertex(Vertex<T> vertex){
        this.vertexSet.replace(vertex.id, vertex);
    }

    /**
     *
     * @param vertex_id
     * @return
     */
    public Vertex getVertex(T vertex_id){
        return this.vertexSet.get(vertex_id);
    }
}

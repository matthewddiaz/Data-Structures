package com.matthewddiaz.datastructures.graphs;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by matthewdiaz on 5/15/17.
 */
public class UnDirectedGraph extends Graph{

    /**
     * Constructor for Undirected graph
     * @param vertexSet set of vertices of the graph
     * @param edgeSet set of edges of the graph
     */
    public UnDirectedGraph(Set<Vertex> vertexSet, Set<Edge> edgeSet){
        super(vertexSet, edgeSet);
    }

    /**
     *
     * @param source the first vertex in the pair
     * @param destination the second vertex in the pair
     * @return returns true if source vertex and destination vertex are not the same.
     * Note: self-loops are not allowed in the undirected graph.
     */
    @Override
    boolean isEdgeValid(Vertex source, Vertex destination) {
        return (source.id != destination.id);
    }

    /**
     *
     * @param adjArray adjacency array
     * @param source source vertex
     * @param adjacentVertex vertex that is adjacent to source vertex
     * Note: there exists a symmetric relation with adjacency vertices for an edge in
     * undirected graphs. That means that if u is adjacent to v; then v is also adjacent to u.
     */
    @Override
    void addAdjacentVertexToAdjArr(List<Vertex>[] adjArray, Vertex source, Vertex adjacentVertex) {
        if(isEdgeValid(source, adjacentVertex)){
            addAdjacentVertex(adjArray, source, adjacentVertex);
            addAdjacentVertex(adjArray, adjacentVertex, source);
        }
    }

    /**
     *
     * @param adjList adjacency array (map)
     * @param source  source vertex
     * @param adjacentVertex vertex that is adjacent to source vertex
     */
    @Override
    void addAdjacentVertexToAdjMap(Map<Integer, List<Vertex>> adjList, Vertex source, Vertex adjacentVertex) {
        addAdjacentVertex(adjList, source, adjacentVertex);
        addAdjacentVertex(adjList, adjacentVertex, source);
    }

    /**
     *
     * @param adjMatrix adjacent matrix 2D array
     * @param source source vertex
     * @param adjVertex vertex that is adjacent to source vertex
     */
    @Override
    void addAdjVertexToAdjMatrix(int[][] adjMatrix, Vertex source, Vertex adjVertex) {
        addVertexToAdjMatrix(adjMatrix, source.id, adjVertex.id);
        addVertexToAdjMatrix(adjMatrix, adjVertex.id, source.id);
    }

}



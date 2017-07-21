package com.matthewddiaz.datastructures.graphs;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by matthewdiaz on 5/15/17.
 */
public class DirectedGraph extends Graph {

    /**
     * Constructor for Directed graph
     * @param vertexSet set of vertices of the graph
     * @param edgeSet set of edges of the graph
     */
    public DirectedGraph(Set<Vertex> vertexSet, Set<Edge> edgeSet){
        super(vertexSet, edgeSet);
    }

    /**
     *
     * @param source the first vertex in the pair
     * @param destination the second vertex in the pair
     * @return always returns true. Self loops are also allowed
     */
    @Override
    boolean isEdgeValid(Vertex source, Vertex destination) {
        return true;
    }

    /**
     * Just adds adjacent vertex to source's adjacency list
     * @param adjArray adjacency array
     * @param source source vertex
     * @param adjacentVertex vertex that is adjacent to source vertex
     */
    @Override
    void addAdjacentVertexToAdjArr(List<Vertex>[] adjArray, Vertex source, Vertex adjacentVertex) {
        addAdjacentVertex(adjArray, source, adjacentVertex);
    }

    /**
     * Just adds adjacent vertex to source's adjacency list
     * @param adjList adjacency array (map)
     * @param source  source vertex
     * @param adjacentVertex vertex that is adjacent to source vertex
     */
    @Override
    void addAdjacentVertexToAdjMap(Map<Integer, List<Vertex>> adjList, Vertex source, Vertex adjacentVertex) {
        addAdjacentVertex(adjList, source, adjacentVertex);
    }

    /**
     * Just adds adjacent vertex to source's adjacency list
     * @param adjMatrix adjacent matrix 2D array
     * @param source source vertex
     * @param adjVertex vertex that is adjacent to source vertex
     */
    @Override
    void addAdjVertexToAdjMatrix(int[][] adjMatrix, Vertex source, Vertex adjVertex) {
        addVertexToAdjMatrix(adjMatrix, source.id, adjVertex.id);
    }
}

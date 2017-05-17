package com.matthewddiaz.datastructures.graphs;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by matthewdiaz on 5/15/17.
 */
public class DirectedGraph extends Graph {

    public DirectedGraph(Set<Vertex> vertexSet, Set<Edge> edgeSet){
        super(vertexSet, edgeSet);
    }

    @Override
    boolean isEdgeValid(Vertex source, Vertex destination) {
        return true;
    }

    @Override
    void addAdjacentVertexToAdjArr(List<Vertex>[] adjArray, Vertex source, Vertex adjacentVertex) {
        addAdjacentVertex(adjArray, source, adjacentVertex);
    }

    @Override
    void addAdjacentVertexToAdjMap(Map<Vertex, List<Vertex>> adjList, Vertex source, Vertex adjacentVertex) {
        addAdjacentVertex(adjList, source, adjacentVertex);
    }

    @Override
    void addAdjVertexToAdjMatrix(int[][] adjMatrix, Vertex source, Vertex adjVertex) {
        addVertexToAdjMatrix(adjMatrix, source.id, adjVertex.id);
    }
}

package com.matthewddiaz.datastructures.graphs;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by matthewdiaz on 5/15/17.
 */
public class UnDirectedGraph extends Graph{

    public UnDirectedGraph(Set<Vertex> vertexSet, Set<Edge> edgeSet){
        super(vertexSet, edgeSet);
    }

    @Override
    boolean isEdgeValid(Vertex source, Vertex destination) {
        return (source.id != destination.id);
    }

    @Override
    void addAdjacentVertexToAdjArr(List<Vertex>[] adjArray, Vertex source, Vertex adjacentVertex) {
        if(isEdgeValid(source, adjacentVertex)){
            addAdjacentVertex(adjArray, source, adjacentVertex);
            addAdjacentVertex(adjArray, adjacentVertex, source);
        }
    }

    @Override
    void addAdjacentVertexToAdjMap(Map<Integer, List<Vertex>> adjList, Vertex source, Vertex adjacentVertex) {
        addAdjacentVertex(adjList, source, adjacentVertex);
        addAdjacentVertex(adjList, adjacentVertex, source);
    }

    @Override
    void addAdjVertexToAdjMatrix(int[][] adjMatrix, Vertex source, Vertex adjVertex) {
        addVertexToAdjMatrix(adjMatrix, source.id, adjVertex.id);
        addVertexToAdjMatrix(adjMatrix, adjVertex.id, source.id);
    }

}



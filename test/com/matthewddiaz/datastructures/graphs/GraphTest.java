package com.matthewddiaz.datastructures.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Created by matthewdiaz on 5/15/17.
 */
class GraphTest {
    private Graph directedGraph;
    private Graph undirectedGraph;

    @BeforeEach
    void setUp() {
        directedGraph = Utils.createSimpleDirectedGraph();
        undirectedGraph = Utils.createSimpleUnDirectedGraph();
    }

    @Test
    void createAdjacencyListForDirectedGraph() {
        List<Graph.Vertex>[] adjArray = directedGraph.createAdjacencyList();
        //Map<Integer, List<Graph.Vertex>> adjList = directedGraph.createAdjacencyListStoredAsMap();
        Graph.traverseAdjArray(adjArray);
        //Graph.traverseAdjArray(adjList);
    }

    @Test
    void createAdjacencyListForUnDirectedGraph() {
        List<Graph.Vertex>[] adjArray = undirectedGraph.createAdjacencyList();
        Graph.traverseAdjArray(adjArray);
    }

    @Test
    void createAdjacencyMatrixForDirectedGraph() {
        int[][] adjMatrix = directedGraph.createAdjMatrix();
        Graph.traverseAdjMatrix(adjMatrix);
    }

    @Test
    void createAdjacencyMatrixForUnDirectedGraph() {
        int[][] adjMatrix = undirectedGraph.createAdjMatrix();
        Graph.traverseAdjMatrix(adjMatrix);
    }
}
package com.matthewddiaz.datastructures.graphs;

import com.matthewddiaz.designpatterns.behavioralPatterns.Iterator;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by matthewdiaz on 5/17/17.
 */
class BreadFirstSearchTest {
    @Test
    void breadFirstSearch() {
        Graph undirectedGraph = Utils.createSimpleUnDirectedGraph();
        List<Graph.Vertex>[] adjacencyList = undirectedGraph.createAdjacencyList();
        Graph.Vertex source = undirectedGraph.getVertex(0);
        String graphBFSString = BreadFirstSearch.breadFirstSearch(adjacencyList, source);
        System.out.println(graphBFSString);
    }


    @Test
    void shortestDistance() {
        Graph undirectedGraph = Utils.createSimpleUnDirectedGraph();
        List<Graph.Vertex>[] adjacencyList = undirectedGraph.createAdjacencyList();
        Graph.Vertex source = undirectedGraph.getVertex(0);
        BreadFirstSearch.breadFirstSearch(adjacencyList, source);

        for(Graph.Vertex vertex : undirectedGraph.getVertexSet()){
            System.out.println("Vertex " + vertex.id + ": shortest path from source " + source.id + " is:" +
                    BreadFirstSearch.shortestDistance(source,vertex));
        }
    }
}
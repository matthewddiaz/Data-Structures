package com.matthewddiaz.datastructures.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by matthewdiaz on 5/18/17.
 */
class DepthFirstSearchTest {

    @Test
    void depthFirstSearch() {
        //create directed graph
        Graph directedGraph = Utils.createSimpleDirectedGraph();
        DepthFirstSearch.depthFirstSearch(directedGraph);
    }

}
package com.matthewddiaz.datastructures.graphs;

import org.junit.jupiter.api.Test;

/**
 * Created by matthewdiaz on 5/18/17.
 */
class DepthFirstSearchTest {

    @Test
    void depthFirstSearch() {
        //create directed graph
        Graph directedGraph = GraphFactory.createSimpleDirectedGraph();
        DepthFirstSearch.depthFirstSearch(directedGraph);
    }

}
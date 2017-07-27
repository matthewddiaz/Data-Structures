package com.matthewddiaz.datastructures.graphs;

import com.matthewddiaz.datastructures.graphs.unWeightedGraphs.UnWeightedDirectedGraph;
import com.matthewddiaz.datastructures.graphs.unWeightedGraphs.UnWeightedUnDirectedGraph;
import com.matthewddiaz.datastructures.graphs.weightedGraphs.WeightedDirectedGraph;
import com.matthewddiaz.datastructures.graphs.weightedGraphs.WeightedUnDirectedGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by matthewdiaz on 7/24/17.
 */
class GraphFactoryTest {
    private UnWeightedUnDirectedGraph<Integer> unWeightedUnDirectedGraph;
    private UnWeightedDirectedGraph<Integer> unWeightedDirectedGraph;

    private WeightedUnDirectedGraph<String> weightedUnDirectedGraph;
    private WeightedDirectedGraph<Integer> weightedDirectedGraph;

    @BeforeEach
    void setUp() throws Exception {
        unWeightedUnDirectedGraph = GraphFactory.createUnWeightedUnDirectedGraph();
        unWeightedDirectedGraph = GraphFactory.createUnWeightedDirectedGraph();

        weightedUnDirectedGraph = GraphFactory.createWeightedUnDirectedGraph();
        weightedDirectedGraph = GraphFactory.createWeightedDirectedGraph();
    }

    @Test
    void createUnWeightedDirectedGraph() {
        String graphAdjacencyListStr = unWeightedDirectedGraph.toString();
        System.out.println(graphAdjacencyListStr);
    }

    @Test
    void createUnWeightedUnDirectedGraph() {
        String graphAdjacencyListStr = unWeightedUnDirectedGraph.toString();
        System.out.println(graphAdjacencyListStr);
    }

    @Test
    void createWeightedUnDirectedGraph(){
        String graphAdjacencyListStr = weightedUnDirectedGraph.toString();
        System.out.println(graphAdjacencyListStr);
    }

    @Test
    void createWeightedDirectedGraph(){
        String graphAdjacencyListStr = weightedDirectedGraph.toString();
        System.out.println(graphAdjacencyListStr);
    }

}
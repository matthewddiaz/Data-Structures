package com.matthewddiaz.datastructures.graphs;

import com.matthewddiaz.datastructures.graphs.unWeightedGraphs.UnWeightedDirectedGraph;
import com.matthewddiaz.datastructures.graphs.unWeightedGraphs.UnWeightedGraph;
import com.matthewddiaz.datastructures.graphs.unWeightedGraphs.UnWeightedUnDirectedGraph;
import com.matthewddiaz.datastructures.graphs.weightedGraphs.WeightedDirectedGraph;
import com.matthewddiaz.datastructures.graphs.weightedGraphs.WeightedGraph;
import com.matthewddiaz.datastructures.graphs.weightedGraphs.WeightedUnDirectedGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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
        //adjacency list
        printAdjacencyList(unWeightedDirectedGraph);

        //adjacency matrix
        printUnWeightedAdjacencyMatrix(unWeightedDirectedGraph);
    }

    @Test
    void createUnWeightedUnDirectedGraph() {
        //adjacency list
        printAdjacencyList(unWeightedUnDirectedGraph);

        //adjacency matrix
        printUnWeightedAdjacencyMatrix(unWeightedUnDirectedGraph);
    }

    @Test
    void createWeightedUnDirectedGraph(){
        //adjacency list
        printAdjacencyList(weightedUnDirectedGraph);

        //adjacency matrix
        printWeightedAdjacencyMatrix(weightedUnDirectedGraph);
    }

    @Test
    void createWeightedDirectedGraph(){
        //adjacency list
        printAdjacencyList(weightedDirectedGraph);

        //adjacency matrix
        printWeightedAdjacencyMatrix(weightedDirectedGraph);
    }

    /**
     *
     * @param graph
     */
    private void printAdjacencyList(Graph graph){
        String graphAdjacencyListStr = graph.toString();
        System.out.println(graphAdjacencyListStr);
    }

    /**
     *
     * @param weightedGraph
     */
    private void printWeightedAdjacencyMatrix(WeightedGraph weightedGraph){
        Integer[][] adjacencyMatrix = weightedGraph.createAdjacencyMatrix();
        String graphAdjacencyMatrixStr = WeightedGraph.traverseAdjacencyMatrix(adjacencyMatrix);
        System.out.println(graphAdjacencyMatrixStr);
    }

    /**
     *
     * @param unWeightedGraph
     */
    private void printUnWeightedAdjacencyMatrix(UnWeightedGraph unWeightedGraph){
        boolean[][] adjacencyMatrix = unWeightedGraph.createAdjacencyMatrix();
        String graphAdjacencyMatrixStr = UnWeightedGraph.traverseAdjacencyMatrix(adjacencyMatrix);
        System.out.println(graphAdjacencyMatrixStr);
    }

}
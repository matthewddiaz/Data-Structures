package com.matthewddiaz.datastructures.graphs;

import com.matthewddiaz.datastructures.graphs.unWeightedGraphs.UnWeightedDirectedGraph;
import com.matthewddiaz.datastructures.graphs.unWeightedGraphs.UnWeightedUnDirectedGraph;
import com.matthewddiaz.datastructures.graphs.weightedGraphs.WeightedDirectedGraph;
import com.matthewddiaz.datastructures.graphs.weightedGraphs.WeightedUnDirectedGraph;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by matthewdiaz on 5/17/17.
 */
public class GraphFactory {

    /**
     *
     * @return Creates and returns a new unweighted undirected graph.
     * @throws Exception throws exception if an edge is invalid
     */
    public static UnWeightedUnDirectedGraph<Integer> createUnWeightedUnDirectedGraph() throws Exception {
        Set<Vertex<Integer>> vertexSet = createVertexSet(0,4);

        UnWeightedUnDirectedGraph<Integer> unWeightedUnDirectedGraph = new UnWeightedUnDirectedGraph(vertexSet);

        unWeightedUnDirectedGraph.addEdge(0,1);
        unWeightedUnDirectedGraph.addEdge(0,4);
        unWeightedUnDirectedGraph.addEdge(1,2);
        unWeightedUnDirectedGraph.addEdge(1,3);
        unWeightedUnDirectedGraph.addEdge(1,4);
        unWeightedUnDirectedGraph.addEdge(2,3);
        unWeightedUnDirectedGraph.addEdge(3,4);

        return unWeightedUnDirectedGraph;
    }

    /**
     *
     * @return Creates and returns a new unweighted directed graph.
     * @throws Exception throws exception if an edge is invalid
     */
    public static UnWeightedDirectedGraph<Integer> createUnWeightedDirectedGraph() throws Exception {
        Set<Vertex<Integer>> vertexSet = createVertexSet(0, 5);
        UnWeightedDirectedGraph<Integer> unWeightedUnDirectedGraph = new UnWeightedDirectedGraph(vertexSet);

        unWeightedUnDirectedGraph.addEdge(0,1);
        unWeightedUnDirectedGraph.addEdge(0,3);
        unWeightedUnDirectedGraph.addEdge(1,4);
        unWeightedUnDirectedGraph.addEdge(2,4);
        unWeightedUnDirectedGraph.addEdge(2,5);
        unWeightedUnDirectedGraph.addEdge(3,1);
        unWeightedUnDirectedGraph.addEdge(4,3);
        unWeightedUnDirectedGraph.addEdge(5,5);

        return unWeightedUnDirectedGraph;
    }

    /**
     *
     * @return Creates and returns a new weighted directed graph.
     * @throws Exception throws exception if an edge is invalid
     */
    public static WeightedDirectedGraph<Integer> createWeightedDirectedGraph() throws Exception {
        Set<Vertex<Integer>> vertexSet = createVertexSet(0, 4);
        WeightedDirectedGraph<Integer> weightedDirectedGraph = new WeightedDirectedGraph(vertexSet);

        weightedDirectedGraph.addWeightedEdge(0,1,5);
        weightedDirectedGraph.addWeightedEdge(0,2,3);
        weightedDirectedGraph.addWeightedEdge(1,3,3);
        weightedDirectedGraph.addWeightedEdge(2,1,2);
        weightedDirectedGraph.addWeightedEdge(2,3,5);
        weightedDirectedGraph.addWeightedEdge(2,4,6);
        weightedDirectedGraph.addWeightedEdge(4,3,1);
        return weightedDirectedGraph;
    }

    /**
     *
     * @return Creates and returns a new weighted undirected graph.
     * @throws Exception throws exception if an edge is invalid
     */
    public static WeightedUnDirectedGraph<String> createWeightedUnDirectedGraph() throws Exception {
        Set<Vertex<String>> vertexSet = new HashSet<>();
        vertexSet.add(new Vertex<>("Miami"));
        vertexSet.add(new Vertex<>("NYC"));
        vertexSet.add(new Vertex<>("Orlando"));
        vertexSet.add(new Vertex<>("Boston"));
        vertexSet.add(new Vertex<>("Las Vegas"));

        WeightedUnDirectedGraph<String> weightedUnDirectedGraph = new WeightedUnDirectedGraph<String>(vertexSet);

        weightedUnDirectedGraph.addWeightedEdge("Miami", "Orlando", 1);
        weightedUnDirectedGraph.addWeightedEdge("Miami", "NYC", 6);
        weightedUnDirectedGraph.addWeightedEdge("NYC", "Orlando", 2);
        weightedUnDirectedGraph.addWeightedEdge("NYC", "Las Vegas", 3);
        weightedUnDirectedGraph.addWeightedEdge("NYC", "Boston", 1);
        weightedUnDirectedGraph.addWeightedEdge("Orlando", "Las Vegas", 8);
        weightedUnDirectedGraph.addWeightedEdge("Las Vegas", "Boston", 6);

        return weightedUnDirectedGraph;
    }

    /**
     *
     * @param startIndex starting index for vertex set
     * @param endIndex ending index for vertex set
     * @return creates and returns a new Set with the vertices's id ranging from start index to end index
     */
    private static Set<Vertex<Integer>> createVertexSet(int startIndex, int endIndex){
        Set<Vertex<Integer>> vertexSet = new HashSet<>();
        for(int index = startIndex; index <= endIndex; index++){
            vertexSet.add(new Vertex(index));
        }
        return vertexSet;
    }
}

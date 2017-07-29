package com.matthewddiaz.datastructures.graphs.weightedGraphs;

import com.matthewddiaz.datastructures.graphs.Vertex;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by matthewdiaz on 7/23/17.
 */
public class WeightedDirectedGraph<T extends Comparable> extends WeightedGraph<T>{

    /**
     * Constructor that given a vertexSet creates a new WeightedDirectedGraph with no edges.
     * @param vertexSet
     * @throws Exception
     */
    public WeightedDirectedGraph(Set<Vertex<T>> vertexSet) throws Exception {
        super(vertexSet);
    }

    /**
     * Constructor that given a vertexSet and weightedEdges creates a new WeightedDirectedGraph.
     * @param vertexSet
     * @param weightedEdges
     * @throws Exception
     */
    public WeightedDirectedGraph(Set<Vertex<T>> vertexSet, Set<WeightedEdge<T>> weightedEdges) throws Exception {
        super(vertexSet, weightedEdges);
    }

    /**
     *
     * @param source the first vertex in the pair
     * @param destination the second vertex in the pair
     * @return
     */
    @Override
    protected boolean isEdgeValid(Vertex<T> source, Vertex<T> destination) {
        return true;
    }

    /**
     *
     * @param adjacencyList adjacency list
     * @param weightedEdge weighted edge to be added to adjacency list
     */
    @Override
    protected void addAdjacentVertexToAdjacencyList(Map<T, List<WeightedEdge<T>>> adjacencyList, WeightedEdge<T> weightedEdge) {
        insertAdjacentVertexToSourceAdjacencyList(adjacencyList, weightedEdge.getSource(), weightedEdge);
    }

    /**
     *
     * @param adjacencyMatrix graph's adjacency matrix
     * @param row value's row index for adjacency matrix
     * @param col value's col index for adjacency matrix
     * @param value weight of edge
     */
    @Override
    protected void addWeightedEdgeToAdjacencyMatrix(Integer[][] adjacencyMatrix, int row, int col, int value) {
        populateAdjacencyMatrixSlot(adjacencyMatrix, row, col, value);
    }
}

package com.matthewddiaz.datastructures.graphs.weightedGraphs;

import com.matthewddiaz.datastructures.graphs.Vertex;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by matthewdiaz on 7/23/17.
 */
public class WeightedUnDirectedGraph<T extends Comparable> extends WeightedGraph<T> {

    /**
     * Constructor that given a vertexSet creates a new WeightedUnDirectedGraph with no edges.
     * @param vertexSet
     * @throws Exception
     */
    public WeightedUnDirectedGraph(Set<Vertex<T>> vertexSet) throws Exception {
        super(vertexSet);
    }

    /**
     * Constructor that given a vertexSet and weightedEdges creates a new WeightedUnDirectedGraph.
     * @param vertexSet
     * @param weightedEdges
     * @throws Exception
     */
    public WeightedUnDirectedGraph(Set<Vertex<T>> vertexSet, Set<WeightedEdge<T>> weightedEdges) throws Exception {
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
        if(source == destination){
            return false;
        }else{
            return true;
        }
    }

    /**
     *
     * @param adjacencyList adjacency list
     * @param weightedEdge weighted edge to be added to adjacency list
     */
    @Override
    public void addAdjacentVertexToAdjacencyList(Map<T, List<WeightedEdge<T>>> adjacencyList, WeightedEdge<T> weightedEdge) {
        insertAdjacentVertexToSourceAdjacencyList(adjacencyList, weightedEdge.getSource(), weightedEdge);
        insertAdjacentVertexToSourceAdjacencyList(adjacencyList, weightedEdge.getDestination(), weightedEdge);
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
        populateAdjacencyMatrixSlot(adjacencyMatrix, col, row, value);
    }
}

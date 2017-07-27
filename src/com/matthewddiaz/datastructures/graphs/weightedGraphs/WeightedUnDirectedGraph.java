package com.matthewddiaz.datastructures.graphs.weightedGraphs;

import com.matthewddiaz.datastructures.graphs.Vertex;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by matthewdiaz on 7/23/17.
 */
public class WeightedUnDirectedGraph<T> extends WeightedGraph<T> {
    public WeightedUnDirectedGraph(Set<Vertex<T>> vertexSet) throws Exception {
        super(vertexSet);
    }

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
     * @param adjacencyList
     * @param weightedEdge
     */
    @Override
    public void addAdjacentVertexToAdjacencyList(Map<T, List<WeightedEdge<T>>> adjacencyList, WeightedEdge<T> weightedEdge) {
        insertAdjacentVertexToSourceAdjacencyList(adjacencyList, weightedEdge.getSource(), weightedEdge);
        insertAdjacentVertexToSourceAdjacencyList(adjacencyList, weightedEdge.getDestination(), weightedEdge);
    }
}

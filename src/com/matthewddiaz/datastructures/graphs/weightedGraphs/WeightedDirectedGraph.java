package com.matthewddiaz.datastructures.graphs.weightedGraphs;


import com.matthewddiaz.datastructures.graphs.Edge;
import com.matthewddiaz.datastructures.graphs.Graph;
import com.matthewddiaz.datastructures.graphs.Vertex;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by matthewdiaz on 7/23/17.
 */
public class WeightedDirectedGraph<T extends Comparable> extends WeightedGraph<T>{

    public WeightedDirectedGraph(Set<Vertex<T>> vertexSet) throws Exception {
        super(vertexSet);
    }

    public WeightedDirectedGraph(Set<Vertex<T>> vertexSet, Set<WeightedEdge<T>> weightedEdges) throws Exception {
        super(vertexSet, weightedEdges);
    }

    @Override
    protected boolean isEdgeValid(Vertex<T> source, Vertex<T> destination) {
        return true;
    }

    @Override
    public void addAdjacentVertexToAdjacencyList(Map<T, List<WeightedEdge<T>>> adjacencyList, WeightedEdge<T> weightedEdge) {
        insertAdjacentVertexToSourceAdjacencyList(adjacencyList, weightedEdge.getSource(), weightedEdge);
    }
}

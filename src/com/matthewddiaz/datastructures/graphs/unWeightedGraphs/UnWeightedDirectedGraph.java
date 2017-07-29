package com.matthewddiaz.datastructures.graphs.unWeightedGraphs;

import com.matthewddiaz.datastructures.graphs.Edge;
import com.matthewddiaz.datastructures.graphs.Vertex;

import java.util.Map;
import java.util.Set;

/**
 * Created by matthewdiaz on 7/24/17.
 */
public class UnWeightedDirectedGraph<T extends Comparable> extends UnWeightedGraph<T>{

    /**
     * Default Unweighted Directed Graph Constructor.
     * Note: Creates an empty edgeSet and empty adjacency list.
     * @param vertexSet list of vertices.
     */
    public UnWeightedDirectedGraph(Set<Vertex<T>> vertexSet) throws Exception {
        super(vertexSet);
    }

    /**
     * Constructor for Directed graph
     * @param vertexSet set of vertices of the graph
     * @param edgeSet set of edges of the graph
     */
    public UnWeightedDirectedGraph(Set<Vertex<T>> vertexSet, Set<Edge<T>> edgeSet) throws Exception {
        super(vertexSet, edgeSet);
    }

    /**
     *
     * @param source the first vertex in the pair
     * @param destination the second vertex in the pair
     * @return always returns true. Self loops are also allowed
     */
    @Override
    protected boolean isEdgeValid(Vertex source, Vertex destination) {
        return true;
    }

    /**
     *
     * @param adjacencyList adjacency list (stored using a map instead of a backing array)
     * @param source source vertex
     * @param adjacentVertex vertex that is adjacent to source vertex
     */
    @Override
    protected void addAdjacentVertexToAdjacencyList(Map adjacencyList, Vertex source, Vertex adjacentVertex) {
        insertAdjacentVertexToAdjacencyList(adjacencyList, source, adjacentVertex);
    }
}

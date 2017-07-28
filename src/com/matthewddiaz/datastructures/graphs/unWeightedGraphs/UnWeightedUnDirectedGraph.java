package com.matthewddiaz.datastructures.graphs.unWeightedGraphs;

import com.matthewddiaz.datastructures.graphs.Edge;
import com.matthewddiaz.datastructures.graphs.Vertex;

import java.util.Map;
import java.util.Set;

/**
 * Created by matthewdiaz on 7/24/17.
 */
public class UnWeightedUnDirectedGraph<T extends Comparable> extends UnWeightedGraph<T>{

    /**
     * Default Unweighted Directed Graph Constructor.
     * Note: Creates an empty edgeSet and empty adjacency list.
     * @param vertexSet list of vertices.
     */
    public UnWeightedUnDirectedGraph(Set<Vertex<T>> vertexSet) throws Exception {
        super(vertexSet);
    }

    /**
     * Constructor for Directed graph
     * @param vertexSet set of vertices of the graph
     * @param edgeSet set of edges of the graph
     */
    public UnWeightedUnDirectedGraph(Set<Vertex<T>> vertexSet, Set<Edge<T>> edgeSet) throws Exception {
        super(vertexSet, edgeSet);
    }

    /**
     *
     * @param source the first vertex in the pair
     * @param destination the second vertex in the pair
     * @return returns true if source vertex and destination vertex are not the same.
     * Note: self-loops are not allowed in the undirected graph.
     */
    @Override
    protected boolean isEdgeValid(Vertex source, Vertex destination) {
        return (source.getId() != destination.getId());
    }

    @Override
    protected void addAdjacentVertexToAdjacencyList(Map adjacencyList, Vertex source, Vertex adjacentVertex) {
        insertAdjacentVertexToAdjacencyList(adjacencyList,source,adjacentVertex);
        insertAdjacentVertexToAdjacencyList(adjacencyList, adjacentVertex, source);
    }

//    /**
//     * Constructor for Undirected graph
//     * @param vertexSet set of vertices of the graph
//     * @param edgeSet set of edges of the graph
//     */
//    public UnDirectedGraph(Set<Vertex> vertexSet, Set<Edge> edgeSet){
//        super(vertexSet, edgeSet);
//    }
//
//
//    /**
//     *
//     * @param adjArray adjacency array
//     * @param source source vertex
//     * @param adjacentVertex vertex that is adjacent to source vertex
//     * Note: there exists a symmetric relation with adjacency vertices for an edge in
//     * undirected graphs. That means that if u is adjacent to v; then v is also adjacent to u.
//     */
//    @Override
//    protected void addAdjacentVertexToAdjArr(List<Vertex>[] adjArray, Vertex source, Vertex adjacentVertex) {
//        if(isEdgeValid(source, adjacentVertex)){
//            insertAdjacentVertexToAdjacencyList(adjArray, source, adjacentVertex);
//            insertAdjacentVertexToAdjacencyList(adjArray, adjacentVertex, source);
//        }
//    }
//
//    /**
//     *
//     * @param adjList adjacency array (map)
//     * @param source  source vertex
//     * @param adjacentVertex vertex that is adjacent to source vertex
//     */
//    @Override
//    protected void addAdjacentVertexToAdjMap(Map<Integer, List<Vertex>> adjList, Vertex source, Vertex adjacentVertex) {
//        insertAdjacentVertexToAdjacencyList(adjList, source, adjacentVertex);
//        insertAdjacentVertexToAdjacencyList(adjList, adjacentVertex, source);
//    }
//
//    /**
//     *
//     * @param adjMatrix adjacent matrix 2D array
//     * @param source source vertex
//     * @param adjVertex vertex that is adjacent to source vertex
//     */
//    @Override
//    protected void addAdjVertexToAdjMatrix(int[][] adjMatrix, Vertex source, Vertex adjVertex) {
//        addVertexToAdjMatrix(adjMatrix, source.id, adjVertex.id);
//        addVertexToAdjMatrix(adjMatrix, adjVertex.id, source.id);
//    }
}

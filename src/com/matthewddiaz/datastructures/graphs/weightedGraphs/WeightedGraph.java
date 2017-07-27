package com.matthewddiaz.datastructures.graphs.weightedGraphs;

import com.matthewddiaz.datastructures.graphs.Graph;
import com.matthewddiaz.datastructures.graphs.Vertex;

import java.util.*;

/**
 * Created by matthewdiaz on 7/24/17.
 */
public abstract class WeightedGraph<T> extends Graph<T>{
    //adjacency list. graph representation
    private Map<T, List<WeightedEdge<T>>> adjacencyList;

    //weighted edge set
    private Set<WeightedEdge<T>> weightedEdgeSet;

    /**
     * Default Weighted Graph Constructor.
     * Note: Creates an empty edgeSet and empty adjacency list.
     * @param vertexSet list of vertices.
     */
    public WeightedGraph(Set<Vertex<T>> vertexSet) throws Exception {
        super(vertexSet);
        //initializes a new empty adjacency list
        this.weightedEdgeSet = new HashSet<>();
        this.adjacencyList = createAdjacencyList(this.weightedEdgeSet);
    }

    /**
     * Weighted Graph Constructor.
     * Note: Creates and populates the adjacency list.
     * @param vertexSet list of vertices
     * @param weightedEdgeSet list of edges
     * @throws Exception throws exception if edgeSet is invalid
     */
    public WeightedGraph(Set<Vertex<T>> vertexSet, Set<WeightedEdge<T>> weightedEdgeSet) throws Exception {
        super(vertexSet);
        if(!isWeightedEdgeSetValid(weightedEdgeSet)){
            throw new Exception("Input edge set is not valid");
        }

        this.weightedEdgeSet = weightedEdgeSet;
        //initializes and populates the adjacency list
        this.adjacencyList = createAdjacencyList(this.weightedEdgeSet);
    }

    /**
     *
     * @param edgeSet list of edges
     * @return an adjacency list of the graph. Stored in a map
     */
    private Map<T,List<WeightedEdge<T>>> createAdjacencyList(Set<WeightedEdge<T>> edgeSet) throws Exception {
        Map<T, List<WeightedEdge<T>>> adjacencyList = new HashMap<>();

        //iterate through the edge set
        for(WeightedEdge<T> weightedEdge: edgeSet){
            //functionality to add vertices correctly to adjacency list depending on the type of graph
            if(validateEdge(weightedEdge.getSource(), weightedEdge.getDestination())){
                addAdjacentVertexToAdjacencyList(this.adjacencyList, weightedEdge);
            }else{
                throw new Exception("Invalid edge set");
            }
        }
        return adjacencyList;
    }

    /**
     *
     * @param adjacencyList
     * @param weightedEdge
     */
    public abstract void addAdjacentVertexToAdjacencyList(Map<T, List<WeightedEdge<T>>> adjacencyList,
                                                          WeightedEdge<T> weightedEdge);

    /**
     *
     * @param source
     * @param destination
     * @param weight
     */
    public void addWeightedEdge(Vertex<T> source, Vertex<T> destination, int weight) throws Exception {
        //check if source and destination vertex are valid vertices for an edge.
        validateEdge(source, destination);
        //create a new edge
        WeightedEdge<T> weightedEdge = new WeightedEdge<T>(source, destination, weight);

        //add it to the graphs edge set
        this.weightedEdgeSet.add(weightedEdge);

        //update adjacency list
        addAdjacentVertexToAdjacencyList(this.adjacencyList, weightedEdge);
    }

    /**
     *
     * @param sourceID
     * @param destinationID
     * @param weight
     */
    public void addWeightedEdge(T sourceID, T destinationID, int weight) throws Exception {
        Vertex<T> source = getVertex(sourceID);
        Vertex<T> destination = getVertex(destinationID);
        addWeightedEdge(source, destination, weight);
    }

    protected void insertAdjacentVertexToSourceAdjacencyList(Map<T, List<WeightedEdge<T>>> adjacencyList,
                                                             Vertex<T> source, WeightedEdge<T> weightedEdge){
        //if source vertex does not have an entry; create a new adjacency list for it
        if(!adjacencyList.containsKey(source.getId())){
            List<WeightedEdge<T>> sourceAdjacencyList = new LinkedList<>();
            adjacencyList.put(source.getId(), sourceAdjacencyList);
        }

        List<WeightedEdge<T>> sourceAdjacencyList = adjacencyList.get(source.getId());
        sourceAdjacencyList.add(weightedEdge);
    }

    @Override
    public String toString(){
        return traverseAdjacencyList(this.adjacencyList, this.getVertexSet());
    }

    public static<T> String traverseAdjacencyList(Map<T, List<WeightedEdge<T>>> adjacencyList, Set<Vertex<T>> vertexSet){
        StringBuffer adjacencyListBuffer = new StringBuffer();

        //iterate through all vertices in the set
        for(Vertex<T> vertex : vertexSet){
            T sourceVertexID = vertex.getId();
            //opening brace for current source vertex
            adjacencyListBuffer.append(sourceVertexID + ": [ ");
            //case were current source vertex adjacency list is empty
            if(!adjacencyList.containsKey(sourceVertexID)){
                adjacencyListBuffer.append("Empty Set");
            } else{
                List<WeightedEdge<T>> sourceVertexAdjacencyList = adjacencyList.get(sourceVertexID);

                WeightedEdge<T> firstWeightedEdge = sourceVertexAdjacencyList.get(0);

                adjacencyListBuffer.append("{" + firstWeightedEdge.toString() + "}");

                for(int  index = 1; index < sourceVertexAdjacencyList.size(); index++){
                    adjacencyListBuffer.append(", {" + sourceVertexAdjacencyList.get(index).toString() + "}");
                }
            }
            //closing brace for current source adjacency list
            adjacencyListBuffer.append(" ]\n");
        }

        return adjacencyListBuffer.toString();
    }

//    private static<T> String printWeightedAdjacentVertex(WeightedEdge<T> weightedEdge){
//        return "{ Adjacent vertex: " + weightedEdge.getDestination().getId() + ", weight: " + weightedEdge.getWeight();
//    }
}

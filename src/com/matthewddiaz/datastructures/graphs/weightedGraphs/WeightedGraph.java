package com.matthewddiaz.datastructures.graphs.weightedGraphs;

import com.matthewddiaz.datastructures.graphs.Graph;
import com.matthewddiaz.datastructures.graphs.Vertex;

import java.util.*;

/**
 * Created by matthewdiaz on 7/24/17.
 */
public abstract class WeightedGraph<T extends Comparable> extends Graph<T>{
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
     * @param adjacencyList adjacency list
     * @param weightedEdge weighted edge to be added to adjacency list
     * Note: the functionality is decided by subclasses
     */
    protected abstract void addAdjacentVertexToAdjacencyList(Map<T, List<WeightedEdge<T>>> adjacencyList,
                                                          WeightedEdge<T> weightedEdge);

    /**
     * Checks if source and destination vertex is valid; if so creates a weighted edge
     * and adds it to the graphs edge set and adjacency list
     * @param source source vertex
     * @param destination destination vertex
     * @param weight weight of edge
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
     * @param sourceID id of source vertex
     * @param destinationID id of source destination
     * @param weight weight of edge
     * NOTE: this method is used if client does not have the actual vertices; but does have their ids
     */
    public void addWeightedEdge(T sourceID, T destinationID, int weight) throws Exception {
        Vertex<T> source = getVertex(sourceID);
        Vertex<T> destination = getVertex(destinationID);
        addWeightedEdge(source, destination, weight);
    }

    /**
     *
     * @param adjacencyList graphs adjacency list
     * @param source source vertex
     * @param weightedEdge weighted edge added to adjacency list
     */
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

    /**
     *NOTE: static method
     * @param adjacencyList graph's adjacency list
     * @param vertexSet graph's vertex set
     * @param <T> generic type must extend Comparable interface
     * @return a String representation of the graph's adjacency list
     * with the format: "currentVertex.id [ {source.id, destination.id, weight }, ... ]
     */
    public static<T extends Comparable> String traverseAdjacencyList(Map<T, List<WeightedEdge<T>>> adjacencyList,
                                                                     Set<Vertex<T>> vertexSet){
        StringBuffer adjacencyListBuffer = new StringBuffer();

        //iterate through all vertices in the set
        for(Vertex<T> vertex : vertexSet){
            //Note: the vertex's id is the key used in the adjacencyList entry pairing.
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

    /**
     *
     * @return Creates and returns the graph's adjacency matrix 2D Array.
     * Note: If two vertices u and v have a connecting edge (u,v) then that weight's edge is stored in
     * that slot matrix[u][v] = edge weight
     */
    public Integer[][] createAdjacencyMatrix(){
        SortedSet<Vertex<T>> sortedVertexSet = this.getVertexSet();
        int matrixDimension = sortedVertexSet.size();
        //creating the adjacency matrix. All values are initialized to null
        Integer[][] adjacencyMatrix = new Integer[matrixDimension][matrixDimension];

        //insert all of the elements into a list to be able to index them based on their id sorted in non-decreasing order
        List<Vertex<T>> sortedVertexList = new ArrayList<>();
        for (Vertex<T> vertex : sortedVertexSet) {
            sortedVertexList.add(vertex);
        }

        //iterate through all of the edges in the graphs edge set
        for(WeightedEdge<T> weightedEdge : this.weightedEdgeSet){
            Vertex<T> sourceVertex = weightedEdge.getSource();
            Vertex<T> destinationVertex = weightedEdge.getDestination();
            int edgeWeight = weightedEdge.getWeight();
            //leaves functionality of inserting edge to adjacency matrix to subclasses
            addWeightedEdgeToAdjacencyMatrix(adjacencyMatrix, sortedVertexList.indexOf(sourceVertex),
                    sortedVertexList.indexOf(destinationVertex), edgeWeight);
        }

        return adjacencyMatrix;
    }

    /**
     *
     * @param adjacencyMatrix graph's adjacency matrix
     * @param row value's row index for adjacency matrix
     * @param col value's col index for adjacency matrix
     * @param value weight of edge
     * Note: this method leaves functionality of how to add edge to adjacency matrix to subclasses
     */
    protected abstract void addWeightedEdgeToAdjacencyMatrix(Integer[][] adjacencyMatrix, int row, int col, int value);

    /**
     *
     * @param adjacencyMatrix graph's adjacency matrix
     * @param row index row of value to be inserted in adjacency matrix
     * @param col index col of value to be inserted in adjacency matrix
     * @param value weight of edge
     */
    protected void populateAdjacencyMatrixSlot(Integer[][] adjacencyMatrix, int row, int col, int value){
        adjacencyMatrix[row][col] = value;
    }

    /**
     *
     * @param adjacencyMatrix graph's adjacency matrix
     * @return String representation of the graph's adjacency matrix
     */
    public static String traverseAdjacencyMatrix(Integer[][] adjacencyMatrix){
        StringBuffer adjacencyMatrixBuffer = new StringBuffer();
        //traversing every slot in the adjacency matrix
        for(int rowIndex = 0; rowIndex < adjacencyMatrix.length; rowIndex++){
            for (int colIndex = 0; colIndex < adjacencyMatrix[0].length; colIndex++){
                Integer edgeWeight = adjacencyMatrix[rowIndex][colIndex];
                //case were edge is present at the given slot
                if(edgeWeight != null){
                    adjacencyMatrixBuffer.append(edgeWeight + " ");
                }//case were edge is not present in the given slot
                else{
                    adjacencyMatrixBuffer.append("X ");
                }
            }
            adjacencyMatrixBuffer.append("\n");
        }
        return adjacencyMatrixBuffer.toString();
    }

    public Map<T, List<WeightedEdge<T>>> getAdjacencyList() {
        return adjacencyList;
    }

    public Set<WeightedEdge<T>> getWeightedEdgeSet() {
        return weightedEdgeSet;
    }
}

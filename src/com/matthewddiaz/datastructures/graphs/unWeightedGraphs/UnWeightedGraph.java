package com.matthewddiaz.datastructures.graphs.unWeightedGraphs;

import com.matthewddiaz.datastructures.graphs.Edge;
import com.matthewddiaz.datastructures.graphs.Graph;
import com.matthewddiaz.datastructures.graphs.Vertex;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by matthewdiaz on 7/24/17.
 */
public abstract class UnWeightedGraph<T extends Comparable> extends Graph<T> {
    //adjacency list. graph representation
    private Map<T, List<Vertex<T>>> adjacencyList;
    private Set<Edge<T>> edgeSet;

    /**
     * Default Unweighted Graph Constructor.
     * Note: Creates an empty edgeSet and empty adjacency list.
     *
     * @param vertexSet list of vertices.
     */
    public UnWeightedGraph(Set<Vertex<T>> vertexSet) throws Exception {
        super(vertexSet);
        //initializes a new empty adjacency list
        this.edgeSet = new HashSet<>();
        this.adjacencyList = createAdjacencyList(this.edgeSet);
    }

    /**
     * UnWeighted Graph Constructor.
     * Note: Creates and populates the adjacency list.
     *
     * @param vertexSet list of vertices
     * @param edgeSet   list of edges
     * @throws Exception throws exception if edgeSet is invalid
     */
    public UnWeightedGraph(Set<Vertex<T>> vertexSet, Set<Edge<T>> edgeSet) throws Exception {
        super(vertexSet);
        if (!isEdgeSetValid(edgeSet)) {
            throw new Exception("Input edge set is not valid");
        }

        this.edgeSet = edgeSet;
        //initializes and populates the adjacency list
        this.adjacencyList = createAdjacencyList(this.edgeSet);
    }

    /**
     * @param edgeSet list of edges
     * @return an adjacency list of the graph. Stored in a map
     */
    private Map<T, List<Vertex<T>>> createAdjacencyList(Set<Edge<T>> edgeSet) throws Exception {
        Map<T, List<Vertex<T>>> adjacencyList = new HashMap<>();

        //iterate through the edge set
        for (Edge<T> edge : edgeSet) {
            //obtain the source vertex
            Vertex<T> source = edge.getSource();
            //obtain the destination vertex
            Vertex<T> destination = edge.getDestination();
            //check if edge is valid.
            validateEdge(source, destination);
            //functionality to add vertices correctly to adjacency list depending on the type of graph
            addAdjacentVertexToAdjacencyList(adjacencyList, source, destination);
        }
        return adjacencyList;
    }

    /**
     * @param source      first vertex in pair
     * @param destination second vertex in pair
     * @throws Exception throws exception if source vertex and destination vertex are not compatible to be an edge
     */
    public void addEdge(Vertex<T> source, Vertex<T> destination) throws Exception {
        //check if source and destination vertex are valid vertices for an edge.
        validateEdge(source, destination);

        //create a new edge
        Edge<T> edge = new Edge(source, destination);

        //add it to the graphs edge set
        this.getEdgeSet().add(edge);

        //update adjacency list
        addAdjacentVertexToAdjacencyList(this.adjacencyList, source, destination);
    }

    /**
     * @param sourceID      id of source vertex
     * @param destinationID id of destination vertex
     */
    public void addEdge(T sourceID, T destinationID) throws Exception {
        Vertex<T> source = getVertex(sourceID);
        Vertex<T> destination = getVertex(destinationID);

        addEdge(source, destination);
    }

    /**
     * Abstract method. Depending on the type of graph calls insertAdjacentVertexToAdjacencyList once or twice
     *
     * @param adjacencyList  adjacency list (stored using a map instead of a backing array)
     * @param source         source vertex
     * @param adjacentVertex vertex that is adjacent to source vertex
     */
    protected abstract void addAdjacentVertexToAdjacencyList(Map<T, List<Vertex<T>>> adjacencyList,
                                                             Vertex source, Vertex adjacentVertex);

    /**
     * Inserts adjacentVertex to source's vertexList
     *
     * @param adjacencyList  (stored using a map instead of a backing array)
     * @param source         source vertex
     * @param adjacentVertex vertex that is adjacent to source vertex
     */
    protected void insertAdjacentVertexToAdjacencyList(Map<T, List<Vertex<T>>> adjacencyList,
                                                       Vertex<T> source, Vertex<T> adjacentVertex) {
        //if source vertex does not have a adjacency vertex list create one
        if (!adjacencyList.containsKey(source.getId())) {
            List<Vertex<T>> sourceVertexAdjList = new LinkedList<>();
            adjacencyList.put(source.getId(), sourceVertexAdjList);
        }
        //insert the adjacent vertex source's adjacency vertex list
        List<Vertex<T>> sourceVertexAdjList = adjacencyList.get(source.getId());
        sourceVertexAdjList.add(adjacentVertex);
        adjacencyList.replace(source.getId(), sourceVertexAdjList);
    }

    @Override
    public String toString() {
        return traverseAdjacencyList(this.adjacencyList, this.getVertexSet());
    }

    /**
     * Static Method.
     *
     * @param adjacencyList
     * @param <T>
     * @return String representation of adjacencyList. Format for adjacency list: "vertex.id: [ adjV1, adjV2 ]"
     */
    public static <T extends Comparable> String traverseAdjacencyList(Map<T, List<Vertex<T>>> adjacencyList, Set<Vertex<T>> vertexSet) {
        //iterate through each vertex of the input adjacent array
        StringBuffer adjacencyListBuffer = new StringBuffer();

        for (Vertex<T> currentVertex : vertexSet) {
            T currentVertexID = currentVertex.getId();
            adjacencyListBuffer.append(currentVertexID + ": [ ");

            //case were currentVertex adjacency list is empty
            if (!adjacencyList.containsKey(currentVertexID)) {
                adjacencyListBuffer.append("Empty Set");
            } else {
                List<Vertex<T>> currentVertexAdjacencyList = adjacencyList.get(currentVertexID);
                //append each adjacent vertex to the buffer
                adjacencyListBuffer.append(currentVertexAdjacencyList.get(0).getId());
                for (int index = 1; index < currentVertexAdjacencyList .size(); index++) {
                    Vertex<T> adjacentVertex = currentVertexAdjacencyList .get(index);
                    adjacencyListBuffer.append(", " + adjacentVertex.getId());
                }
            }
            adjacencyListBuffer.append(" ]\n");
        }

        return adjacencyListBuffer.toString();
    }

    public boolean[][] createAdjacencyMatrix(){
        return createAdjacencyMatrix(this.adjacencyList, (SortedSet<Vertex<T>>) this.getVertexSet());
    }

    /**
     * An adjacency matrix has length and width equal to the number of vertices
     * and each slot represents if the edge between those two vertices exist or not.
     * @return an adjacency matrix (2D array) of the graph
     */
    public static<T extends Comparable> boolean[][] createAdjacencyMatrix(Map<T, List<Vertex<T>>> adjacencyList,
                                                                          SortedSet<Vertex<T>> sortedVertexSet){
        //create a relation between vertex id and an index position.
        int numOfVertices = sortedVertexSet.size();
        boolean[][] adjMatrix = new boolean[numOfVertices][numOfVertices];

        List<Vertex<T>> sortedVertexList = new ArrayList<>();
        for(Vertex<T> vertex : sortedVertexSet){
            sortedVertexList.add(vertex);
        }

        for(int currentVertexIndex = 0; currentVertexIndex < sortedVertexList.size(); currentVertexIndex++){
            Vertex<T> currentVertex = sortedVertexList.get(currentVertexIndex);
            T currentVertexID = currentVertex.getId();

            if(adjacencyList.containsKey(currentVertexID)){
                List<Vertex<T>> currentVertexAdjacencyList = adjacencyList.get(currentVertexID);
                for(Vertex<T> adjacentVertex : currentVertexAdjacencyList){
                    //get index of adjacent Vertex (col variable in matrix)
                    int adjacentVertexIndex = sortedVertexList.indexOf(adjacentVertex);
                    adjMatrix[currentVertexIndex][adjacentVertexIndex] = true;
                }
            }
        }

        return adjMatrix;
    }

    public static String traverseAdjacencyMatrix(boolean[][] adjacencyMatrix){
        StringBuffer adjacencyMatrixBuffer = new StringBuffer();

        for(int rowIndex = 0; rowIndex < adjacencyMatrix.length; rowIndex++){
            for(int colIndex = 0; colIndex < adjacencyMatrix[0].length; colIndex++){
                if(adjacencyMatrix[rowIndex][colIndex]){
                    adjacencyMatrixBuffer.append(1 + " ");
                }else{
                    adjacencyMatrixBuffer.append(0 + " ");
                }
            }
            adjacencyMatrixBuffer.append("\n");
        }
        return adjacencyMatrixBuffer.toString();
    }

    public Set<Edge<T>> getEdgeSet() {
        return this.edgeSet;
    }

    public Map<T, List<Vertex<T>>> getAdjacencyList() {
        return this.adjacencyList;
    }
}

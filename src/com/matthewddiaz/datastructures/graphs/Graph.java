package com.matthewddiaz.datastructures.graphs;

import java.util.*;

/**
 * Created by matthewdiaz on 5/15/17.
 */
public abstract class Graph {
    public static class Vertex{
        int id;
        //Distance from source vertex. Used in BFS.
        int distance;
        //parent vertex
        Vertex parent;
        //either 0,1, or 2 for undiscovered, discovered, and finished
        int visit_state;

        public void setId(int id) {this.id = id;}

        public int getDistance() {return distance;}

        public void setDistance(int distance) {this.distance = distance;}

        public Vertex getParent() {return parent;}

        public void setParent(Vertex parent) {this.parent = parent;}

        public int getVisit_state() {return visit_state;}

        public void setVisit_state(int visit_state) {this.visit_state = visit_state;}

        public int getDiscoveredTimeStamp() {return discoveredTimeStamp;}

        public void setDiscoveredTimeStamp(int discoveredTimeStamp) {this.discoveredTimeStamp = discoveredTimeStamp;}

        public int getFinishedTimeStamp() {return finishedTimeStamp;}

        public void setFinishedTimeStamp(int finishedTimeStamp) {this.finishedTimeStamp = finishedTimeStamp;}

        //used in DFS
        int discoveredTimeStamp;
        //used in DFS
        int finishedTimeStamp;

        Vertex(int id){
            this.id = id;
            distance = Integer.MAX_VALUE;
            parent = null;
            visit_state = 0;
            discoveredTimeStamp = 0;
            finishedTimeStamp = 0;
        }

        @Override
        public String toString(){
            StringBuffer buffer = new StringBuffer("Vector ID: " + this.id + "\n");
            buffer.append("Distance From source: " + this.distance + "\n");
            buffer.append("Predecessor: ");
            if(this.parent == null){
                buffer.append("null");
            }else{
                buffer.append(this.parent.id);
            }
            buffer.append("\n");
            buffer.append("Discovered time stamp: "  + this.discoveredTimeStamp + "\n");
            buffer.append("Finished time stamp: " + this.finishedTimeStamp);
            buffer.append("\n");

            return buffer.toString();
        }

        public int getId(){
            return this.id;
        }
    }

    public static class Edge{
        Vertex source;
        Vertex destination;

        Edge(Vertex s, Vertex d){
            source = s;
            destination = d;
        }

        public Vertex getSource(){
            return this.source;
        }

        public Vertex getDestination(){
            return this.destination;
        }

        public void setSource(Vertex source) {
            this.source = source;
        }

        public void setDestination(Vertex destination) {
            this.destination = destination;
        }
    }

    //vertexSet is a map that relates key: vertex id to value: vertex
    private Map<Integer, Vertex> vertexSet;
    //edgeSet of Graph
    private Set<Edge> edgeSet;

    /**
     * Default Graph constructor that creates an empty vertexSet and empty edgeSet
     */
    public Graph(){
        this.vertexSet = new HashMap<>();
        this.edgeSet = new HashSet<>();
    }

    /**
     * Constructor where inputs are the graphs vertex set and edge set
     * @param vertexSet
     * @param edgeSet
     */
    public Graph(Set<Vertex> vertexSet, Set<Edge> edgeSet){
        this.vertexSet = new HashMap<>();
        //converts the input vertexSet into a Map
        transformInputSetToMap(vertexSet);
        this.edgeSet = edgeSet;
    }

    /**
     * Converts the input set into a map pairing.
     * @param vertexSet
     */
    private void transformInputSetToMap(Set<Vertex> vertexSet){
        for(Vertex vertex: vertexSet){
            this.vertexSet.put(vertex.id, vertex);
        }
    }

    /**
     * Constructor where inputs are the graphs vertex set (map) and edge set
     * @param vertexSet Map representation of vertex Set
     * @param edgeSet edge Set
     */
    public Graph(Map<Integer, Vertex> vertexSet, Set<Edge> edgeSet){
        this.vertexSet = vertexSet;
        this.edgeSet = edgeSet;
    }

    /**
     * Adds vertex set to vertex set
     * @param vertex
     */
    public void addVertex(Vertex vertex){
        int vertexID = vertex.id;
        this.vertexSet.put(vertexID, vertex);
    }

    /**
     * Checks if edge is valid. Depends on the type of graph
     * @param source the first vertex in the pair
     * @param destination the second vertex in the pair
     * @return returns true if the edge is valid
     */
    abstract boolean isEdgeValid(Vertex source, Vertex destination);

    /**
     *
     * @param source first vertex in pair
     * @param destination second vertex in pair
     * @throws Exception throws exception if source vertex and destination vertex are not compatible to be an edge
     */
    public void addEdge(Vertex source, Vertex destination) throws Exception {
        //check if edge is valid
        if(!isEdgeValid(source, destination)){
            throw new Exception("Note a valid Edge");
        }

        //create a new edge
        Edge edge = new Edge(source, destination);
        //add it to the graphs edge set
        edgeSet.add(edge);
    }

    /**
     *
     * @return an adjacency list of the graph. It is an array of lists. Each vertex in the vertexSet has a
     * slot in the array; the slot contains a list of that vertex's adjacent vertices in the graph.
     */
    public List<Vertex>[] createAdjacencyList() {
        List<Vertex>[] adjacencyList = new LinkedList[getVertexSet().size()];

        //iterate through the edge set
        for(Edge edge: edgeSet){
            //obtain the source vertex
            Vertex source = edge.source;
            //obtain the destination vertex
            Vertex destination = edge.destination;
            //functionality to add vertices correctly to adjacency list depending on the type of graph
            addAdjacentVertexToAdjArr(adjacencyList, source , destination);
        }
        return adjacencyList;
    }

    /**
     * Abstract method. Depending on the type of graph calls addAdjacentVertex once or twice
     * @param adjArray adjacency array
     * @param source source vertex
     * @param adjacentVertex vertex that is adjacent to source vertex
     */
    abstract void addAdjacentVertexToAdjArr(List<Vertex>[] adjArray, Vertex source, Vertex adjacentVertex );

    /**
     * Inserts adjacentVertex to source's vertexList
     * @param adjArray adjacency array
     * @param source source vertex
     * @param adjacentVertex vertex that is adjacent to source vertex
     */
    void addAdjacentVertex(List<Vertex>[] adjArray, Vertex source, Vertex adjacentVertex ){
        //if source vertex does not have a adjacency vertex list create one
        if(adjArray[source.id] == null){
            adjArray[source.id] = new LinkedList<>();
        }
        //insert the adjacent vertex source's adjacency vertex list
        adjArray[source.id].add(adjacentVertex);
    }

    /**
     * @return an adjacency list of the graph in Map format. Where the key: vertex.id
     * and the value: List of adjacent vertices for that vertex
     */
    public Map<Integer, List<Vertex>> createAdjacencyListStoredAsMap(){
        Map<Integer, List<Vertex>> adjList = new HashMap<>();
        for(Edge e : edgeSet){
            Vertex sourceVertex = e.source;
            Vertex adjacentVertex = e.destination;
            //functionality to add vertices correctly to adjacency list depending on the type of graph
            addAdjacentVertexToAdjMap(adjList, sourceVertex, adjacentVertex);
        }
        return adjList;
    }

    /**
     * Abstract method. Depending on the type of graph calls addAdjacentVertex once or twice
     * @param adjList adjacency array (map)
     * @param source  source vertex
     * @param adjacentVertex vertex that is adjacent to source vertex
     */
    abstract void addAdjacentVertexToAdjMap(Map<Integer, List<Vertex>> adjList, Vertex source, Vertex adjacentVertex);

    /**
     * Inserts adjacentVertex to source's vertexList
     * @param adjList adjacency array (map)
     * @param source source vertex
     * @param adjacentVertex vertex that is adjacent to source vertex
     */
    void addAdjacentVertex(Map<Integer, List<Vertex>> adjList, Vertex source, Vertex adjacentVertex ){
        //if map does not have an entry for the source vertex; put an entry of the source id with
        //an empty list
        if(!adjList.containsKey(source.id)){
            adjList.put(source.id, new LinkedList<>());
        }

        //add adjacent vertex to vertex adjacent list
        List<Vertex> vertexList = adjList.get(source);
        vertexList.add(adjacentVertex);
        adjList.replace(source.id, vertexList);
    }

    /**
     * Static Method.
     * Print format for adjacency list: "vertex.id: [adjacent vertices]"
     * @param adjArray Adjacency List of an array
     */
    public static void traverseAdjArray(List<Vertex>[] adjArray){
        //iterate through each vertex of the input adjacent array
        StringBuffer adjArrayBuffer = new StringBuffer();
        for(int index = 0; index < adjArray.length; index++){
            List<Vertex> vertexList = adjArray[index];
            adjArrayBuffer.append(index + ": [");
            //append all of vertex's adjacent vertices.
            for(Vertex vertex : vertexList){
                adjArrayBuffer.append(vertex.id + " ");
            }
            adjArrayBuffer.append("]\n");
        }
        System.out.println(adjArrayBuffer.toString());
    }

    /**
     * An adjacency matrix has length and width equal to the number of vertices
     * and each slot represents if the edge between those two vertices exist or not.
     * @return an adjacency matrix (2D array) of the graph
     */
    public int[][] createAdjMatrix(){
        int[][] adjMatrix = new int[vertexSet.size()][vertexSet.size()];
        //iterate through all of the edges in the graphs edge set
        for(Edge edge : edgeSet){
            Vertex source = edge.source;
            Vertex adjVertex = edge.destination;
            //functionality to add vertices correctly to adjacency matrix depends on the type of graph
            addAdjVertexToAdjMatrix(adjMatrix, source, adjVertex);
        }
        return adjMatrix;
    }

    /**
     * Abstract method. Functionality depends on type of graph
     * @param adjMatrix adjacent matrix 2D array
     * @param source source vertex
     * @param adjVertex vertex that is adjacent to source vertex
     */
    abstract void addAdjVertexToAdjMatrix(int[][] adjMatrix, Vertex source, Vertex adjVertex);

    /**
     * Sets the slot adjMatrix[s][d] to true. The graph contains on edge from vertex s to vertex d
     * @param adjMatrix adjacent matrix 2D array
     * @param source_id source vertex
     * @param adjVertex_id vertex that is adjacent to source vertex
     */
    void addVertexToAdjMatrix(int[][] adjMatrix, int source_id, int adjVertex_id){
        adjMatrix[source_id][adjVertex_id] = 1;
    }

    /**
     *
     * @param adjMap
     */
    public static void traverseAdjArray(Map<Integer, List<Vertex>> adjMap){
       adjMap.forEach((vertex, vertexAdjVertices)->{
           StringBuffer buffer = new StringBuffer(vertex + ": ");

           for(Vertex adjVertex : vertexAdjVertices){
              buffer.append(adjVertex.id + " ");
           }
           System.out.println(buffer.toString());
       });
    }

    /**
     * Static Method.
     * Print format: row by row of the matrix
     * @param adjMatrix adjacency matrix of the input graph
     */
    public static void traverseAdjMatrix(int[][] adjMatrix){
        StringBuffer buffer = new StringBuffer();
        for(int[] vertexPathList : adjMatrix){
            for(int presentPath : vertexPathList){
                buffer.append(presentPath + " ");
            }
            buffer.append("\n");
        }
        System.out.println(buffer.toString());
    }

    public Collection<Vertex> getVertexSet(){
        return this.vertexSet.values();
    }

    public Set<Edge> getEdgeSet(){
        return this.edgeSet;
    }

    public void setVertex(Vertex vertex){
        this.vertexSet.replace(vertex.id, vertex);
    }

    public Vertex getVertex(int vertex_id){
        return this.vertexSet.get(vertex_id);
    }
}

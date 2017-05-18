package com.matthewddiaz.datastructures.graphs;

import java.util.*;

/**
 * Created by matthewdiaz on 5/15/17.
 */
public abstract class Graph {
    static class Vertex{
        int id;
        //used in BFS
        int distance;
        Vertex parent;
        //either 0,1, or 2
        int visit_state;
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
    }

    static class Edge{
        Vertex source;
        Vertex destination;

        Edge(Vertex s, Vertex d){
            source = s;
            destination = d;
        }
    }

    private Map<Integer, Vertex> vertexSet;
    private Set<Edge> edgeSet;

    public Graph(){
        this.vertexSet = new HashMap<>();
        this.edgeSet = new HashSet<>();
    }

    public Graph(Set<Vertex> vertexSet, Set<Edge> edgeSet){
        this.vertexSet = new HashMap<>();
        transformInputSetToMap(vertexSet);
        this.edgeSet = edgeSet;
    }

    private void transformInputSetToMap(Set<Vertex> vertexSet){
        for(Vertex vertex: vertexSet){
            this.vertexSet.put(vertex.id, vertex);
        }
    }

    public Graph(Map<Integer, Vertex> vertexSet, Set<Edge> edgeSet){
        this.vertexSet = vertexSet;
        this.edgeSet = edgeSet;
    }

    public void addVertex(Vertex vertex){
        int vertexID = vertex.id;
        this.vertexSet.put(vertexID, vertex);
    }

    abstract boolean isEdgeValid(Vertex source, Vertex destination);

    public void addEdge(Vertex source, Vertex destination) throws Exception {
        if(!isEdgeValid(source, destination)){
            throw new Exception("Note a valid Edge");
        }

        Edge edge = new Edge(source, destination);
        edgeSet.add(edge);
    }

    public List<Vertex>[] createAdjacencyList() {
        List<Vertex>[] adjacencyList = new LinkedList[getVertexSet().size()];

        Set<Edge> edgeSet = getEdgeSet();
        for(Edge edge: edgeSet){
            Vertex source = edge.source;
            Vertex destination = edge.destination;
            addAdjacentVertexToAdjArr(adjacencyList, source , destination);
        }
        return adjacencyList;
    }

    abstract void addAdjacentVertexToAdjArr(List<Vertex>[] adjArray, Vertex source, Vertex adjacentVertex );

    void addAdjacentVertex(List<Vertex>[] adjArray, Vertex source, Vertex adjacentVertex ){
        List<Vertex> vertexList = adjArray[source.id];
        if(vertexList == null){
            vertexList = new LinkedList<>();
            adjArray[source.id] = vertexList;
        }
        vertexList.add(adjacentVertex);
    }

    public Map<Integer, List<Vertex>> createAdjacencyListStoredAsMap(){
        Map<Integer, List<Vertex>> adjList = new HashMap<>();
        for(Edge e : edgeSet){
            Vertex sourceVertex = e.source;
            Vertex adjacentVertex = e.destination;
            addAdjacentVertexToAdjMap(adjList, sourceVertex, adjacentVertex);
        }
        return adjList;
    }

    abstract void addAdjacentVertexToAdjMap(Map<Integer, List<Vertex>> adjList, Vertex source, Vertex adjacentVertex);

    void addAdjacentVertex(Map<Integer, List<Vertex>> adjList, Vertex source, Vertex adjacentVertex ){
        if(!adjList.containsKey(source.id)){
            adjList.put(source.id, new LinkedList<>());
        }

        List<Vertex> vertexList = adjList.get(source);
        vertexList.add(adjacentVertex);
        adjList.replace(source.id, vertexList);
    }

    /**
     *
     * @param adjArray
     */
    public static void traverseAdjArray(List<Vertex>[] adjArray){
        for(int index = 0; index < adjArray.length; index++){
            List<Vertex> vertexList = adjArray[index];
            StringBuffer buffer = new StringBuffer(index + ": ");

            for(Vertex vertex : vertexList){
                buffer.append(vertex.id + " ");
            }
            System.out.println(buffer.toString());
        }
    }

    public int[][] createAdjMatrix(){
        int[][] adjMatrix = new int[vertexSet.size()][vertexSet.size()];
        for(Edge edge : edgeSet){
            Vertex source = edge.source;
            Vertex adjVertex = edge.destination;
            addAdjVertexToAdjMatrix(adjMatrix, source, adjVertex);
        }
        return adjMatrix;
    }

    abstract void addAdjVertexToAdjMatrix(int[][] adjMatrix, Vertex source, Vertex adjVertex);

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

package com.matthewddiaz.datastructures.graphs;

import java.util.*;

/**
 * Created by matthewdiaz on 5/15/17.
 */
public abstract class Graph {
    static class Vertex{
        int id;

        Vertex(int id){
            this.id = id;
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

    private Set<Vertex> vertexSet;
    private Set<Edge> edgeSet;

    public Graph(){
        this.vertexSet = new HashSet<>();
        this.edgeSet = new HashSet<>();
    }

    public Graph(Set<Vertex> vertexSet, Set<Edge> edgeSet){
        this.vertexSet = vertexSet;
        this.edgeSet = edgeSet;
    }

    public void addVertex(Vertex vertex){
        vertexSet.add(vertex);
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

    public Map<Vertex, List<Vertex>> createAdjacencyListStoredAsMap(){
        Map<Vertex, List<Vertex>> adjList = new HashMap<>();
        for(Edge e : edgeSet){
            Vertex sourceVertex = e.source;
            Vertex adjacentVertex = e.destination;
            addAdjacentVertexToAdjMap(adjList, sourceVertex, adjacentVertex);
        }
        return adjList;
    }

    abstract void addAdjacentVertexToAdjMap(Map<Vertex, List<Vertex>> adjList, Vertex source, Vertex adjacentVertex);

    void addAdjacentVertex(Map<Vertex, List<Vertex>> adjList, Vertex source, Vertex adjacentVertex ){
        if(!adjList.containsKey(source)){
            adjList.put(source, new LinkedList<>());
        }

        List<Vertex> vertexList = adjList.get(source);
        vertexList.add(adjacentVertex);
        adjList.replace(source, vertexList);
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
    public static void traverseAdjArray(Map<Vertex, List<Vertex>> adjMap){
       adjMap.forEach((vertex, vertexAdjVertices)->{
           StringBuffer buffer = new StringBuffer(vertex.id + ": ");

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

    public Set<Vertex> getVertexSet(){
        return this.vertexSet;
    }

    public Set<Edge> getEdgeSet(){
        return this.edgeSet;
    }
}

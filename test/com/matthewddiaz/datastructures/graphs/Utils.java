package com.matthewddiaz.datastructures.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by matthewdiaz on 5/17/17.
 */
public class Utils {
    public static Graph createSimpleUnDirectedGraph(){
        Set<Graph.Vertex> vertexSet = new HashSet<>();
        Set<Graph.Edge> edgeSet = new HashSet<>();
        Graph.Vertex v0 = new Graph.Vertex(0);
        Graph.Vertex v1 = new Graph.Vertex(1);
        Graph.Vertex v2 = new Graph.Vertex(2);
        Graph.Vertex v3 = new Graph.Vertex(3);
        Graph.Vertex v4 = new Graph.Vertex(4);

        vertexSet.add(v0);
        vertexSet.add(v1);
        vertexSet.add(v2);
        vertexSet.add(v3);
        vertexSet.add(v4);

        edgeSet.add(new Graph.Edge(v0, v1));
        edgeSet.add(new Graph.Edge(v0, v4));
        edgeSet.add(new Graph.Edge(v1, v2));
        edgeSet.add(new Graph.Edge(v1, v3));
        edgeSet.add(new Graph.Edge(v1, v4));
        edgeSet.add(new Graph.Edge(v2, v3));
        edgeSet.add(new Graph.Edge(v3, v4));
        return new UnDirectedGraph(vertexSet, edgeSet);
    }

    public static Graph createSimpleDirectedGraph(){
        Set<Graph.Vertex> vertexSet = new HashSet<>();
        Set<Graph.Edge> edgeSet = new HashSet<>();
        Graph.Vertex v0 = new Graph.Vertex(0);
        Graph.Vertex v1 = new Graph.Vertex(1);
        Graph.Vertex v2 = new Graph.Vertex(2);
        Graph.Vertex v3 = new Graph.Vertex(3);
        Graph.Vertex v4 = new Graph.Vertex(4);
        Graph.Vertex v5 = new Graph.Vertex(5);


        vertexSet.add(v0);
        vertexSet.add(v1);
        vertexSet.add(v2);
        vertexSet.add(v3);
        vertexSet.add(v4);
        vertexSet.add(v5);

        edgeSet.add(new Graph.Edge(v0, v1));
        edgeSet.add(new Graph.Edge(v0, v3));
        edgeSet.add(new Graph.Edge(v1, v4));
        edgeSet.add(new Graph.Edge(v2, v4));
        edgeSet.add(new Graph.Edge(v2, v5));
        edgeSet.add(new Graph.Edge(v3, v1));
        edgeSet.add(new Graph.Edge(v4, v3));
        edgeSet.add(new Graph.Edge(v5, v5));
        return new DirectedGraph(vertexSet, edgeSet);
    }
}

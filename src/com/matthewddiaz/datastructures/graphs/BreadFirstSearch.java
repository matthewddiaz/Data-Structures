package com.matthewddiaz.datastructures.graphs;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * Created by matthewdiaz on 5/17/17.
 */
public class BreadFirstSearch {

    public static String breadFirstSearch(List<Graph.Vertex>[] adjList, Graph.Vertex source){
        source.distance = 0;
        source.visit_state = 1;

        Queue<Graph.Vertex> queue = new ArrayDeque<>();
        queue.add(source);

        StringBuffer graphBFS = new StringBuffer();
        while(!queue.isEmpty()){
            Graph.Vertex currentVertex = queue.remove();
            graphBFS.append(currentVertex.toString() + "\n");
            List<Graph.Vertex> currentVertexAdjVertices = adjList[currentVertex.id];
            for(Graph.Vertex adjVertex : currentVertexAdjVertices){
                if(adjVertex.visit_state == 0){
                    adjVertex.visit_state = 1;
                    adjVertex.distance = currentVertex.distance + 1;
                    adjVertex.parent = currentVertex;
                    queue.add(adjVertex);
                }
                currentVertex.visit_state = 2;
            }
        }
        return graphBFS.toString();
    }


    public static String shortestDistance(Graph.Vertex source, Graph.Vertex destination){
        if(source.equals(destination)){
            return source.id + "";
        }else if(destination.parent == null){
            return "NO PATH";
        }else{
            return shortestDistance(source, destination.parent) + " " + destination.id;
        }
    }
}

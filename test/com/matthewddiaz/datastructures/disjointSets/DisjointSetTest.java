package com.matthewddiaz.datastructures.disjointSets;

import com.matthewddiaz.datastructures.graphs.Graph;
import com.matthewddiaz.datastructures.graphs.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.security.provider.certpath.Vertex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by matthewdiaz on 6/1/17.
 */
class DisjointSetTest {
    private DisjointSet disjointSet;

//    @BeforeEach
//    void setUp() {
//
//    }

    @Test
    void sample1(){
        List<LinkedList.Node<Integer>> list = new ArrayList<>();
        for(int num = 0; num < 16; num++){
            LinkedList.Node<Integer> node = new LinkedList.Node(num);
            list.add(node);
        }

        disjointSet = new DisjointSet(list);
        for(int index = 0; index < list.size(); index = index + 2){
            disjointSet.union(list.get(index), list.get(index + 1));
        }

        disjointSet.union(list.get(0), list.get(2));
        disjointSet.union(list.get(3), list.get(14));
        System.out.println("HI");

        //for(int num )

    }

    @Test
    void sample2(){
        Graph graph = Utils.createUnDirectedDisjointGraph();


        List<LinkedList.Node<Graph.Vertex>> list = new ArrayList<>();
        //creating a disjoint set for each vertex in graph
        for(Graph.Vertex vertex : graph.getVertexSet()){
            LinkedList.Node<Graph.Vertex> node = new LinkedList.Node(vertex);
            list.add(node);
        }

        disjointSet =  new DisjointSet(list);

        //call join on all edges. Note: for a given edge (u,v) the join will
        // only occur if which vertex u and vertex v are not in the same set.
        for(Graph.Edge edge : graph.getEdgeSet()){
            int sourceID = edge.getSource().getId();
            int destinationID = edge.getDestination().getId();

            disjointSet.union(list.get(sourceID), list.get(destinationID));
        }

        System.out.println("HI");
    }

}
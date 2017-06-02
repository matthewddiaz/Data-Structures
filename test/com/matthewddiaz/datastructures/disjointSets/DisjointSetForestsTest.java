package com.matthewddiaz.datastructures.disjointSets;

import com.matthewddiaz.datastructures.graphs.Graph;
import com.matthewddiaz.datastructures.graphs.Utils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by matthewdiaz on 6/2/17.
 */
class DisjointSetForestsTest {
    private DisjointSetForests disjointSet;

    @Test
    void sample2(){
        Graph graph = Utils.createUnDirectedDisjointGraph();


        List<DisjointRootedTree.Node> list = new ArrayList<>();
        //creating a disjoint set for each vertex in graph
        for(Graph.Vertex vertex : graph.getVertexSet()){
            DisjointRootedTree.Node<Graph.Vertex> node = new DisjointRootedTree.Node(vertex);
            list.add(node);
        }

        disjointSet =  new DisjointSetForests(list);

        //call join on all edges. Note: for a given edge (u,v) the join will
        // only occur if which vertex u and vertex v are not in the same set.
        for(Graph.Edge edge : graph.getEdgeSet()){
            int sourceID = edge.getSource().getId();
            int destinationID = edge.getDestination().getId();

            disjointSet.union(list.get(sourceID), list.get(destinationID));
        }

        Collection<DisjointRootedTree> disjointCompressedSets = disjointSet.getDisjointSets();

        for(Graph.Vertex vertex : graph.getVertexSet()){
            DisjointRootedTree.Node root = disjointSet.findSet(list.get(vertex.getId()));
            Graph.Vertex vertexAtRoot = (Graph.Vertex) root.member;
            System.out.println("Vertex: v" + vertex.getId() + " belongs in set " + vertexAtRoot.getId());
        }

        System.out.println("HI");
    }
}
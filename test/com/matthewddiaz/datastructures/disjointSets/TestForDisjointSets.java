package com.matthewddiaz.datastructures.disjointSets;

import com.matthewddiaz.datastructures.graphs.Graph;
import com.matthewddiaz.datastructures.graphs.GraphFactory;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by matthewdiaz on 6/11/17.
 */
public class TestForDisjointSets {
    /**
     * Testing the union operation of the disjointSet.
     * @param disjointSets
     */
    public static void testingUnion(DisjointSets disjointSets){
        String expectedResult =
                        "[ 4, 3, 2, 1 ]\n" +
                        "[ 8, 7, 6, 5 ]\n" +
                        "[ 12, 11, 10, 9 ]\n" +
                        "[ 16, 15, 14, 13 ]\n";

        //16 single element disjoint sets are created ranging from [1, 16]
        for(int num = 1; num <= 16; num++){
            disjointSets.makeSet(num);
        }

        //Every pair of disjoint set are merged
        for(int index = 1; index < 16; index = index + 2){
            disjointSets.union(index, index + 1);
        }

        //Every 3rd element from 1 to 14 is in a separate set and are unioned
        for(int index = 1; index < 14; index = index + 4){
            disjointSets.union(index, index + 2);
        }

        //expecting 4 disjoint sets
        assertEquals(expectedResult, disjointSets.toString());
    }

    /**
     * Determines the connected components (connected vertices) of an undirected graph
     * @param disjointSets
     */
    public static void connectedComponents(DisjointSets disjointSets){
        List<Set> expectedDisjointSets = correctDisjointSets();

        Graph graph = GraphFactory.createUnDirectedDisjointGraph();

        //creating a disjoint set for each vertex in graph
        for(Graph.Vertex vertex : graph.getVertexSet()){
            disjointSets.makeSet(vertex.getId());
        }

        //call join on all edges. Note: for a given edge (u,v) the join will
        //only occur if vertex u and vertex v are not in the same set.
        for(Graph.Edge edge : graph.getEdgeSet()){
            Graph.Vertex source = edge.getSource();
            Graph.Vertex destination = edge.getDestination();

            disjointSets.union(source.getId(), destination.getId());
        }

        assertEquals(expectedDisjointSets,  disjointSets.getDisjointSets());
    }

    private static List<Set> correctDisjointSets(){
        List<Set> expectedDisjointSets = new ArrayList<>();

        Set set1 = new HashSet();
        set1.add(0);
        set1.add(1);
        set1.add(2);
        set1.add(3);
        expectedDisjointSets.add(set1);


        Set set2 = new HashSet();
        set2.add(4);
        set2.add(5);
        set2.add(6);
        expectedDisjointSets.add(set2);

        Set set3 = new HashSet();
        set3.add(7);
        set3.add(8);
        expectedDisjointSets.add(set3);

        Set set4 = new HashSet();
        set4.add(9);
        expectedDisjointSets.add(set4);

        return expectedDisjointSets;
    }
}

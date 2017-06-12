package com.matthewddiaz.datastructures.disjointSets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.matthewddiaz.datastructures.disjointSets.TestForDisjointSets.connectedComponents;
import static com.matthewddiaz.datastructures.disjointSets.TestForDisjointSets.testingUnion;

/**
 * Created by matthewdiaz on 6/2/17.
 */
class DisjointSetsBackByForestsTest {
    private DisjointSets disjointSetsBackedByForest;

    @BeforeEach
    void setUp() {
        disjointSetsBackedByForest = new DisjointSetsBackedByForest();
    }

    @Test
    void union(){
        testingUnion(disjointSetsBackedByForest);
    }

    @Test
    void graphConnectedComponents(){
        connectedComponents(disjointSetsBackedByForest);
    }
}
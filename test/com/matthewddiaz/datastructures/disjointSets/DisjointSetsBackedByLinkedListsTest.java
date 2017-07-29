package com.matthewddiaz.datastructures.disjointSets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.matthewddiaz.datastructures.disjointSets.TestForDisjointSets.*;

/**
 * Created by matthewdiaz on 6/1/17.
 */
class DisjointSetsBackedByLinkedListsTest {
    private DisjointSets disjointSetsBackByLinkedLists;

    @BeforeEach
    void setUp() {
        disjointSetsBackByLinkedLists = new DisjointSetsBackedByLinkedLists();
    }

    @Test
    void union(){
        testingUnion(disjointSetsBackByLinkedLists);
    }

    @Test
    void graphConnectedComponents() throws Exception {
        connectedComponents(disjointSetsBackByLinkedLists);
    }
}
package com.matthewddiaz.datastructures.disjointSets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.matthewddiaz.datastructures.disjointSets.TestForDisjointSets.*;

/**
 * Created by matthewdiaz on 6/1/17.
 */
class DisjointSetsBackByLinkedListsTest {
    private DisjointSets disjointSetsBackByLinkedLists;

    @BeforeEach
    void setUp() {
        disjointSetsBackByLinkedLists = new DisjointSetsBackByLinkedLists();
    }

    @Test
    void union(){
        testingUnion(disjointSetsBackByLinkedLists);
    }

    @Test
    void graphConnectedComponents(){
        connectedComponents(disjointSetsBackByLinkedLists);
    }
}
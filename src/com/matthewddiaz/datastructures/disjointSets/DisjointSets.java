package com.matthewddiaz.datastructures.disjointSets;

import java.util.List;
import java.util.Set;

/**
 * Created by matthewdiaz on 6/9/17.
 */
public interface DisjointSets<T> {

    /**
     * Creates a new Set with T as the only element
     * @param element
     */
    void makeSet(T element);

    /**
     * Returns the representative element of the set that the input element is in.
     * NOTE: If input element is not in any of the sets null is returned
     * @param element
     * @return
     */
    T findSet(T element);

    /**
     *If elementX and elementY are not part of the same set; then
     * these two sets are union into a set.
     */
    void union(T elementX, T elementY);

    /**
     * Returns the number of disjoint sets
     * @return
     */
    int numOfDisjointSets();

    /**
     * Returns a list of all of the disjoint sets
     * @return
     */
    List<Set<T>> getDisjointSets();
}

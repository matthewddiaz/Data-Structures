package com.matthewddiaz.datastructures.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by matthewdiaz on 2/27/17.
 */
class MaxHeapTest {
    private MaxHeap maxHeap;
    private int[] array = {7,1,45,19,100,20,11,15};

    @BeforeEach
    void setUp() {
        maxHeap = new MaxHeap();
    }

    /**
     * Turns array into a max heap
     */
    @Test
    void buildMaxHeap() {
        int[] expectedArray = {100,19,45,15,1,20,11,7};
        maxHeap.buildMaxHeap(array);
        assertArrayEquals(expectedArray, array);
    }

    /**
     * Testing MaxHeap.maxHeapify() method. This method enforces
     * max heap's property of parent being larger than both left
     * and right child.
     *
     * Testing maxHeapify() on index 0
     * A[0] = 7 which is not larger than its right child thus max
     * heap rule is current not correct for index 0
     * thus step
     * A[0] is swapped with A[2]
     * now 7 is in A[2]
     * here we check if the rule is broken once again
     * A[2] is swapped with A[5]
     * now 7 is in A[5]
     *
     */
    @Test
    void maxHeapify() {
        int[] expectedArray = {45,1,20,19,100,7,11,15};
        maxHeap.setHeapSize(array.length - 1);
        maxHeap.maxHeapify(array,0);
        assertArrayEquals(expectedArray, array);
    }
}
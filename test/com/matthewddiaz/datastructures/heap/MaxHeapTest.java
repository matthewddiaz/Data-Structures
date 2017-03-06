package com.matthewddiaz.datastructures.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

    @Test
    void buildMaxHeapify() {
        int[] expectedArray = {100,19,45,15,1,20,11,7};
        maxHeap.buildMaxHeapify(array);
        assertArrayEquals(expectedArray, array);
    }
}
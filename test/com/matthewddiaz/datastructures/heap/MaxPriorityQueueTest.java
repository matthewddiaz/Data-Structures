package com.matthewddiaz.datastructures.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by matthewdiaz on 3/6/17.
 */
class MaxPriorityQueueTest {
    private MaxPriorityQueue maxPriorityQueue;

    @BeforeEach
    void setUp() {
        int[] data = {1,15,-10,-21,318,4,13,1,3,15,100,27,2};
        maxPriorityQueue = new MaxPriorityQueue(data);
    }

    @Test
    void maximum() {
        int expectedMaxElement = 318;
        int actualMaxElement = maxPriorityQueue.maximum();
        assertEquals(expectedMaxElement,actualMaxElement);
    }

    @Test
    void extractMaximum() throws Exception {
        int expectedMaxElement = 318;
        int secondMaxElement = 100;
        int actualMaxElement = maxPriorityQueue.extractMaximum();
        assertEquals(expectedMaxElement,actualMaxElement);

        int newMaxElement = maxPriorityQueue.maximum();
        assertEquals(secondMaxElement,newMaxElement);
    }

    /**
     * Note: HeapSize is set equal to the length of the array which is not 100% correct
     * heapSize should be the set of elements in the input array at are in the heap.
     * The problem that is that the current implemented does not allow you to insert
     * until you have removed elements from the original data set.
     */
    @Test
    void insertElement() throws Exception {
        assertThrows(Exception.class, () -> {
            maxPriorityQueue.insertElement(1000);
        });

        maxPriorityQueue.extractMaximum();
        maxPriorityQueue.extractMaximum();
        maxPriorityQueue.insertElement(1000);
        int expectedMaxElement = 1000;
        int actualMaxElement = maxPriorityQueue.maximum();
       assertEquals(expectedMaxElement, actualMaxElement);
    }

    @Test
    void increaseKey() throws Exception {
        maxPriorityQueue.increaseKey(4,67);
    }
}
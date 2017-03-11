package com.matthewddiaz.datastructures.heap;

import data.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by matthewdiaz on 2/27/17.
 */
class MaxHeapTest {
    private MaxHeap maxHeap;
    private Integer[] ages;
    private String[] students;
    private Double[] grades;

    @BeforeEach
    void setUp() {
        maxHeap = new MaxHeap();
        ages = TestData.getIntegerArray();
        students = TestData.getStringArray();
        grades = TestData.getDoubleArray();
    }

    /**
     * Turns Integer array into a max heap
     */
    @Test
    void buildIntegerMaxHeap() {
        Integer[] expectedArray = {180, 103, 105, 16, 20, 100, 15, 1, 11, 4, 17, 19};
        maxHeap.buildMaxHeap(ages);
        assertArrayEquals(expectedArray, ages);
    }

    /**
     * Turns String array into a max heap
     */
    @Test
    void buildStringMaxHeap() {
        String[] expectedArray = {"Vegeta", "Master Roshi", "Piccolo", "Krillian", "Goku", "Gohan", "Bulma", "Cell"};
        maxHeap.buildMaxHeap(students);
        assertArrayEquals(expectedArray, students);
    }

    /**
     * Turns Double array into a max heap
     */
    @Test
    void buildDoubleMaxHeap() {
        Double[] expectedArray = {105.4, 103.2, 17.4, 100.4, 19.3, 16.6, 1.1, 18.18, 16.5, 15.1, 11.1, 4.3, 2.3, -180.2};
        maxHeap.buildMaxHeap(grades);
        assertArrayEquals(expectedArray, grades);
    }
}
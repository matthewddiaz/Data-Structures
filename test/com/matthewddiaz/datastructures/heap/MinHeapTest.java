package com.matthewddiaz.datastructures.heap;

import data.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by matthewdiaz on 7/31/17.
 */
class MinHeapTest {

    private Heap minHeap;
    private Integer[] ages;
    private String[] students;
    private Double[] grades;

    @BeforeEach
    void setUp() {
        minHeap = new MinHeap();
        ages = TestData.getIntegerArray();
        students = TestData.getStringArray();
        grades = TestData.getDoubleArray();
    }

    /**
     * Turns Integer array into a min heap
     */
    @Test
    void buildIntegerMinHeap() {
        Integer[] expectedArray = {1, 4, 19, 11, 15, 100, 105, 103, 16, 17, 20, 180};
        minHeap.buildHeap(ages);
        assertArrayEquals(expectedArray, ages);
    }

    /**
     * Turns String array into a min heap
     */
    @Test
    void buildStringMinHeap() {
        String[] expectedArray = {"Bulma", "Cell", "Gohan", "Krillian", "Master Roshi", "Piccolo", "Goku", "Vegeta"};
        minHeap.buildHeap(students);
        assertArrayEquals(expectedArray, students);
    }

    /**
     * Turns Double array into a min heap
     */
    @Test
    void buildDoubleMinHeap() {
        Double[] expectedArray = {-180.2, 11.1, 1.1, 16.5, 18.18, 2.3, 15.1, 100.4, 105.4, 103.2, 19.3, 4.3, 16.6, 17.4};
        minHeap.buildHeap(grades);
        assertArrayEquals(expectedArray, grades);
    }

    @Test
    void testBuildMinHeapWithNotFullEvenElementsArray() {
        Double[] expectedResult = {1.4, 19.3, 10.4, 50.1, 103.2, 23.6, null, null, null, null};
        Double[] partialClassGrades = TestData.generatePartialGradesArray();

        try {
            minHeap.buildHeap(partialClassGrades, 6);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedResult, partialClassGrades);
    }

    @Test
    void testBuildMinHeapWithNotFullOddElementsArray() {
        Integer[] expectedResult = {11, 19, 15, 30, 21, null, null, null, null, null};

        Integer[] studentAges = TestData.generatePartialAgesArray();

        try {
            minHeap.buildHeap(studentAges, 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertArrayEquals(expectedResult, studentAges);
    }

}
package com.matthewddiaz.datastructures.heap;

import data.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by matthewdiaz on 3/6/17.
 */
class MaxPriorityQueueTest {
    private MaxPriorityQueue mpqForStudents;
    private MaxPriorityQueue mpqForGrades;
    private String[] students;
    private Double[] grades;

    @BeforeEach
    void setUp() {
        students = TestData.getStringArray();
        grades = TestData.getDoubleArray();
        mpqForStudents = new MaxPriorityQueue(students);
        mpqForGrades = new MaxPriorityQueue(grades);
    }

    @Test
    void testingMaximumForTypeDouble() {
        Double expectedMaxElement = 105.4;
        Comparable<Double> actualMaxElement = mpqForGrades.maximum();
        assertEquals(expectedMaxElement, actualMaxElement);
    }

    @Test
    void testingMaximumForTypeString() {
        String expectedMaxElement = "Vegeta";
        Comparable<String> actualMaxElement = mpqForStudents.maximum();
        assertEquals(expectedMaxElement,actualMaxElement);
    }

    @Test
    void extractMaximumForTypeDouble() throws Exception {
        Double expectedMaxElement = 105.4;
        Double secondMaxElement = 103.2;
        Comparable<Double> actualMaxElement = mpqForGrades.extractMaximum();
        assertEquals(expectedMaxElement,actualMaxElement);

        Comparable<Double> newMaxElement = mpqForGrades.extractMaximum();
        assertEquals(secondMaxElement,newMaxElement);
    }

    @Test
    void insertElement() throws Exception {
        Integer[] arr = new Integer[10];
        MaxPriorityQueue mpq = new MaxPriorityQueue(arr, 0);
        mpq.insertElement(15);
        mpq.insertElement(24);
        mpq.insertElement(14);
        mpq.insertElement(28);
        mpq.insertElement(78);
        mpq.insertElement(-100);
    }
}
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
        Double expectedSecondMaxElement = 103.2;
        Double expectedThirdMaxElement = 100.4;

        Comparable<Double> actualMaxElement = mpqForGrades.extractMaximum();
        Comparable<Double> secondMaxElement = mpqForGrades.extractMaximum();
        Comparable<Double> thirdMaxElement = mpqForGrades.extractMaximum();

        assertEquals(expectedMaxElement,actualMaxElement);
        assertEquals(expectedSecondMaxElement, secondMaxElement);
        assertEquals(expectedThirdMaxElement, thirdMaxElement);
    }

    @Test
    void insertAndExtractElement() throws Exception {
        Double expectedMaxElement = 2.2;
        Double expectedSecondMaxElement = 1.3;
        Double expectedThirdMaxElement = -1.3;

        Double[] testData = new Double[10];
        testData[0] = 1.3;
        testData[1] = 2.2;

        MaxPriorityQueue mpq = new MaxPriorityQueue(testData, 2);
        mpq.insertElement(-1.3);
        Comparable<Double> actualMaxElement = mpq.extractMaximum();
        Comparable<Double> secondMaxElement = mpq.extractMaximum();
        Comparable<Double> thirdMaxElement = mpq.extractMaximum();
        mpq.insertElement(4.1);
        mpq.insertElement(100.3);

        assertEquals(expectedMaxElement,actualMaxElement);
        assertEquals(expectedSecondMaxElement, secondMaxElement);
        assertEquals(expectedThirdMaxElement, thirdMaxElement);
    }

    @Test
    void insertElement() throws Exception {
        Integer[] expectedMaxHeap = {190, 78, 28, 15, 24, -100, 1, 11, 14, -105};
        Integer[] arr = new Integer[10];
        MaxPriorityQueue mpq = new MaxPriorityQueue(arr, 0);

        mpq.insertElement(15);
        mpq.insertElement(24);
        mpq.insertElement(14);
        mpq.insertElement(28);
        mpq.insertElement(78);
        mpq.insertElement(-100);
        mpq.insertElement(1);
        mpq.insertElement(11);
        mpq.insertElement(190);
        mpq.insertElement(-105);


        Comparable[] actualMaxHeap = mpq.getMaxHeap();
        assertArrayEquals(expectedMaxHeap, actualMaxHeap);
    }
}
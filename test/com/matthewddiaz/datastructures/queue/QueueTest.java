package com.matthewddiaz.datastructures.queue;

import data.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by matthewdiaz on 3/9/17.
 */
class QueueTest {
    private Queue<String> queueOfStudents;
    private Queue<Double> queueOfGrades;

    private String[] students;
    private Double[] grades;

    @BeforeEach
    void setUp() {
        queueOfStudents = new Queue<>();
        queueOfGrades = new Queue<>();
        students = TestData.getStringArray();
        grades = TestData.getDoubleArray();
    }

    @Test
    void testingAnEmptyQueue() {
        boolean expectedResult = true;
        boolean actualResult = queueOfGrades.isEmpty();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testingANonEmptyQueue() {

    }

    @Test
    void testingEnqueueForString() {

    }

    @Test
    void testingDequeueForString() {

    }

    @Test
    void testingEnqueueForDouble() {

    }

    @Test
    void testingDequeueForDouble() {

    }

}
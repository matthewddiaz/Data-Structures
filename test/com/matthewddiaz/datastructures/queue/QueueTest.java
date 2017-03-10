package com.matthewddiaz.datastructures.queue;

import data.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
        boolean expectedResult = false;
        queueOfGrades.enqueue(grades[0]);

        boolean actualResult = queueOfGrades.isEmpty();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testingEnqueueForString() {
        String[] expectedResult = {students[0], students[1], students[2], students[3]};
        queueOfStudents.enqueue(students[0]);
        queueOfStudents.enqueue(students[1]);
        queueOfStudents.enqueue(students[2]);
        queueOfStudents.enqueue(students[3]);

        Object[] actualResult = queueOfStudents.toArray();
        Arrays.equals(expectedResult, actualResult);
    }

    @Test
    void testingDequeueForString() {
        String[] expectedResult = {students[2], students[3]};
        queueOfStudents.enqueue(students[0]);
        queueOfStudents.enqueue(students[1]);
        queueOfStudents.enqueue(students[2]);
        queueOfStudents.enqueue(students[3]);
        queueOfStudents.dequeue();
        queueOfStudents.dequeue();

        Object[] actualResult = queueOfStudents.toArray();
        Arrays.equals(expectedResult, actualResult);
    }

    @Test
    void testingEnqueueForDouble() {
        Double[] expectedResult = {grades[4], grades[1], grades[2], grades[5]};
        queueOfGrades.enqueue(grades[4]);
        queueOfGrades.enqueue(grades[1]);
        queueOfGrades.enqueue(grades[2]);
        queueOfGrades.enqueue(grades[5]);

        Object[] actualResult = queueOfStudents.toArray();
        Arrays.equals(expectedResult, actualResult);
    }

    @Test
    void testingDequeueForDouble() {
        Double[] expectedResult = { grades[2], grades[5]};
        queueOfGrades.enqueue(grades[3]);
        queueOfGrades.enqueue(grades[0]);
        queueOfGrades.enqueue(grades[2]);
        queueOfGrades.enqueue(grades[5]);

        queueOfGrades.dequeue();
        queueOfGrades.dequeue();
        Object[] actualResult = queueOfStudents.toArray();
        Arrays.equals(expectedResult, actualResult);
    }
}
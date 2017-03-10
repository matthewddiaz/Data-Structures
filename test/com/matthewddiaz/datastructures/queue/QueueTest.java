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
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void testingDequeueForString() {
        String expectedFirstRemovedElement = students[0];
        String expectedSecondRemovedElement = students[1];
        String[] expectedResult = {students[2], students[3]};

        queueOfStudents.enqueue(students[0]);
        queueOfStudents.enqueue(students[1]);
        queueOfStudents.enqueue(students[2]);
        queueOfStudents.enqueue(students[3]);
        String firstElementRemoved = queueOfStudents.dequeue();
        String secondElementRemoved = queueOfStudents.dequeue();
        Object[] actualResult = queueOfStudents.toArray();

        assertEquals(expectedFirstRemovedElement, firstElementRemoved);
        assertEquals(expectedSecondRemovedElement, secondElementRemoved);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void testingEnqueueForDouble() {
        Double[] expectedResult = {grades[4], grades[1], grades[2], grades[5]};
        queueOfGrades.enqueue(grades[4]);
        queueOfGrades.enqueue(grades[1]);
        queueOfGrades.enqueue(grades[2]);
        queueOfGrades.enqueue(grades[5]);

        Object[] actualResult = queueOfGrades.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void testingDequeueForDouble() {
        Double expectedFirstRemovedElement = grades[3];
        Double expectedSecondRemovedElement = grades[0];
        Double[] expectedResult = { grades[2], grades[5]};
        queueOfGrades.enqueue(grades[3]);
        queueOfGrades.enqueue(grades[0]);
        queueOfGrades.enqueue(grades[2]);
        queueOfGrades.enqueue(grades[5]);

        Double firstElementRemoved = queueOfGrades.dequeue();
        Double secondElementRemoved = queueOfGrades.dequeue();
        Object[] actualResult = queueOfGrades.toArray();

        assertEquals(expectedFirstRemovedElement, firstElementRemoved);
        assertEquals(expectedSecondRemovedElement, secondElementRemoved);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void testingEnqueueAndDeque() {
        Double expectedFirstRemovedElement = grades[4];
        Double expectedSecondRemovedElement = grades[1];
        Double expectedThirdRemovedElement = grades[2];
        Double[] expectedResult = {grades[3], grades[5], grades[1]};

        queueOfGrades.enqueue(grades[4]);
        queueOfGrades.enqueue(grades[1]);
        Double firstElementRemoved = queueOfGrades.dequeue();
        Double secondElementRemoved = queueOfGrades.dequeue();
        queueOfGrades.enqueue(grades[2]);
        queueOfGrades.enqueue(grades[3]);
        queueOfGrades.enqueue(grades[5]);
        Double thirdElementRemoved = queueOfGrades.dequeue();
        queueOfGrades.enqueue(grades[1]);

        Object[] actualResult = queueOfGrades.toArray();
        assertEquals(expectedFirstRemovedElement, firstElementRemoved);
        assertEquals(expectedSecondRemovedElement, secondElementRemoved);
        assertEquals(expectedThirdRemovedElement, thirdElementRemoved);
        assertArrayEquals(expectedResult, actualResult);
    }
}
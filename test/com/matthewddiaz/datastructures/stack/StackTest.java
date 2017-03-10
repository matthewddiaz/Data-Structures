package com.matthewddiaz.datastructures.stack;

import data.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by matthewdiaz on 3/9/17.
 */
class StackTest {
    private Stack<String> stackOfStudents;
    private Stack<Double> stackOfGrades;
    private String[] students;
    private Double[] grades;

    @BeforeEach
    void setUp() {
        stackOfStudents = new Stack<>();
        stackOfGrades = new Stack<>();
        students = TestData.getStringArray();
        grades = TestData.getDoubleArray();
    }

    @Test
    void testingIsEmpty() {
        boolean expectedResult = true;
        boolean actualResult = stackOfGrades.isEmpty();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testingNotEmpty() {
        boolean expectedResult = false;
        stackOfGrades.push(grades[0]);
        boolean actualResult = stackOfGrades.isEmpty();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testingPushToStringStack() {
        String[] expectedResult = {students[5], students[4], students[3], students[2], students[1]};
        stackOfStudents.push(students[1]);
        stackOfStudents.push(students[2]);
        stackOfStudents.push(students[3]);
        stackOfStudents.push(students[4]);
        stackOfStudents.push(students[5]);

        Object[] actualResult = stackOfStudents.toArray();
        assertArrayEquals(expectedResult,  actualResult);
    }

    @Test
    void testingPushToDoubleStack() {
        Double[] expectedResult = {grades[5], grades[4], grades[3], grades[2], grades[1]};
        stackOfGrades.push(grades[1]);
        stackOfGrades.push(grades[2]);
        stackOfGrades.push(grades[3]);
        stackOfGrades.push(grades[4]);
        stackOfGrades.push(grades[5]);

        Object[] actualResult = stackOfGrades.toArray();
        assertArrayEquals(expectedResult,  actualResult);
    }

    @Test
    void testingPopToStringStack() {
        String expectedFirstElementRemoved = students[3];
        String expectedSecondElementRemoved = students[5];
        String expectedThirdElementRemoved = students[4];
        String[] expectedResult = {students[2], students[1]};

        stackOfStudents.push(students[1]);
        stackOfStudents.push(students[2]);
        stackOfStudents.push(students[3]);
        String firstElementRemoved = stackOfStudents.pop();
        stackOfStudents.push(students[4]);
        stackOfStudents.push(students[5]);
        String secondElementRemoved = stackOfStudents.pop();
        String thirdElementRemoved =  stackOfStudents.pop();

        Object[] actualResult = stackOfStudents.toArray();
        assertEquals(expectedFirstElementRemoved, firstElementRemoved);
        assertEquals(expectedSecondElementRemoved, secondElementRemoved);
        assertEquals(expectedThirdElementRemoved, thirdElementRemoved);
        assertArrayEquals(expectedResult,  actualResult);
    }

    @Test
    void testingPopToDoubleStack() {
        Double expectedFirstElementRemoved = grades[2];
        Double expectedSecondElementRemoved = grades[1];
        Double expectedThirdElementRemoved = grades[4];
        Double[] expectedResult = {grades[5], grades[3]};

        stackOfGrades.push(grades[1]);
        stackOfGrades.push(grades[2]);
        Double firstElementRemoved = stackOfGrades.pop();
        Double secondElementRemoved = stackOfGrades.pop();
        stackOfGrades.push(grades[3]);
        stackOfGrades.push(grades[4]);
        Double thirdElementRemoved = stackOfGrades.pop();
        stackOfGrades.push(grades[5]);

        Object[] actualResult = stackOfGrades.toArray();
        assertEquals(expectedFirstElementRemoved, firstElementRemoved);
        assertEquals(expectedSecondElementRemoved, secondElementRemoved);
        assertEquals(expectedThirdElementRemoved, thirdElementRemoved);
        assertArrayEquals(expectedResult,  actualResult);
    }

    @Test
    void peak() {
        Double expectedPeakElement = grades[2];
        Double[] expectedResult = {grades[2], grades[1], grades[0]};
        stackOfGrades.push(grades[0]);
        stackOfGrades.push(grades[1]);
        stackOfGrades.push(grades[2]);
        Double peakElement = stackOfGrades.peak();

        Object[] actualResult = stackOfGrades.toArray();
        assertEquals(expectedPeakElement, peakElement);
        assertArrayEquals(expectedResult, actualResult);
    }
}
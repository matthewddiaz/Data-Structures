package com.matthewddiaz.datastructures.lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created by matthewdiaz on 6/7/17.
 */
class DynamicArrayTest {

    private List<Integer> dynamicArray;

    @BeforeEach
    void setUp() {
        dynamicArray = new DynamicArray<>(5);
    }

    @Test
    void appendElement() {
        ListTest.testAppendElement(dynamicArray);
    }

    @Test
    void containsElement() {
        ListTest.containsElement(dynamicArray);
    }

    @Test
    void createIterator() {

    }

    @Test
    void deleteElement() {
        ListTest.deleteElement(dynamicArray);
    }

    @Test
    void deleteElement1() {
        ListTest.deleteElement1(dynamicArray);
    }

    @Test
    void getElement() {

    }

    @Test
    void insertElement() {

    }

    @Test
    void isEmpty() {
        ListTest.isEmpty(dynamicArray);
    }

    @Test
    void prependElement() {
        ListTest.testPrependElement(dynamicArray);
    }

    @Test
    void size() {
        ListTest.size(dynamicArray);
    }

}
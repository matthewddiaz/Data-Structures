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
        TestForLists test = new TestForLists();



        TestForLists.testAppendElement(dynamicArray);
    }

    @Test
    void containsElement() {
        TestForLists.containsElement(dynamicArray);
    }

    @Test
    void createIterator() {

    }

    @Test
    void deleteElement() {
        TestForLists.deleteElement(dynamicArray);
    }

    @Test
    void deleteElement1() {
        TestForLists.deleteElement1(dynamicArray);
    }

    @Test
    void getElement() {

    }

    @Test
    void insertElement() {

    }

    @Test
    void isEmpty() {
        TestForLists.isEmpty(dynamicArray);
    }

    @Test
    void prependElement() {
        TestForLists.testPrependElement(dynamicArray);
    }

    @Test
    void size() {
        TestForLists.size(dynamicArray);
    }

}
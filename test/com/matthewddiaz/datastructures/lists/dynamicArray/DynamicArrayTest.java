package com.matthewddiaz.datastructures.lists.dynamicArray;

import com.matthewddiaz.datastructures.lists.DynamicArray;
import com.matthewddiaz.datastructures.lists.List;
import com.matthewddiaz.datastructures.lists.TestForLists;
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
        TestForLists.testAppendElement(dynamicArray);
    }

    @Test
    void containsElement() {
        TestForLists.containsElement(dynamicArray);
    }

    @Test
    void createIterator() {
        TestForLists.testCreateIterator(dynamicArray);
    }

    @Test
    void removeElement() {
        TestForLists.testRemoveElement(dynamicArray);
    }

    @Test
    void removeElementWithIndexing() {
        TestForLists.testRemoveElementWithIndexing(dynamicArray);
    }

    @Test
    void removeAllElements(){
        TestForLists.testRemoveAllElements(dynamicArray);
    }

    @Test
    void removeAndInsertElements(){
        TestForLists.testRemoveAndInsert(dynamicArray);
    }

    @Test
    void getElement() {
        TestForLists.testGetElement(dynamicArray);
    }

    @Test
    void insertUsingMultipleMethods(){
        TestForLists.testMultipleInsertionMethods(dynamicArray);
    }

    @Test
    void insertElement() {
        TestForLists.testInsertElement(dynamicArray);
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
        TestForLists.testSize(dynamicArray);
    }
}
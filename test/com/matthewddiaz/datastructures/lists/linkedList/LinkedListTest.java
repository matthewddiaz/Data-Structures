package com.matthewddiaz.datastructures.lists.linkedList;

import com.matthewddiaz.datastructures.lists.LinkedList;
import com.matthewddiaz.datastructures.lists.List;
import com.matthewddiaz.datastructures.lists.TestForLists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by matthewdiaz on 3/6/17.
 */
class LinkedListTest {
    private List<Integer> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new LinkedList<>();
    }

    @Test
    void prependElement() {
        TestForLists.testPrependElement(linkedList);
    }

    @Test
    void appendElement() {
        TestForLists.testAppendElement(linkedList);
    }

    @Test
    void isEmpty() {
        TestForLists.isEmpty(linkedList);
    }

    @Test
    void insertionUsingMultipleMethods() {
        TestForLists.testMultipleInsertionMethods(linkedList);
    }

    @Test
    void insertElement() {
        TestForLists.testInsertElement(linkedList);
    }

    @Test
    void containsElement() {
       TestForLists.containsElement(linkedList);
    }

    @Test
    void removeElement() {
       TestForLists.testRemoveElement(linkedList);
    }

    @Test
    void removeElementWithIndex() {
        TestForLists.testRemoveElementWithIndexing(linkedList);
    }

    @Test
    void removeAllElements(){
        TestForLists.testRemoveAllElements(linkedList);
    }

    @Test
    void removeAndInsertElements(){
        TestForLists.testRemoveAndInsert(linkedList);
    }

    @Test
    void createIterator(){
        TestForLists.testCreateIterator(linkedList);
    }

    @Test
    void getElement(){
        TestForLists.testCreateIterator(linkedList);
    }

    @Test
    void size(){
        TestForLists.testSize(linkedList);
    }

    @Test
    void testCreatingReversedLinkedList() {
        String expectedResult = "[ Bulma, Vegeta, Gohan, Goku ]";

        LinkedList list = LinkedListFactory.createSimpleLinkedList();

        LinkedList<String> reversedLinkedList = list.createReversedLinkedList();
        assertEquals(expectedResult, reversedLinkedList.toString());
    }
}
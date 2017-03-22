package com.matthewddiaz.datastructures.linkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by matthewdiaz on 3/6/17.
 */
class LinkedListTest {
    private LinkedList<String> linkedList;
    private String character1 = "Goku";
    private String character2 = "Gohan";
    private String character3 = "Vegeta";
    private String character4 = "Bulma";
    private String character5 = "Piccolo";
    private String character6 = "Boo";

    @BeforeEach
    void setUp() {
        linkedList = new LinkedList<>();
    }

    @Test
    void prependElement() {
        String[] expectedResult = {character4, character3, character2, character1};
        linkedList.prependElement(character1);
        linkedList.prependElement(character2);
        linkedList.prependElement(character3);
        linkedList.prependElement(character4);

        Object[] arr = linkedList.toArray();
        Arrays.equals(expectedResult, arr);
    }

    @Test
    void appendElement() {
        String[] expectedResult = {character1, character2, character3, character5};
        linkedList.appendElement(character1);
        linkedList.appendElement(character2);
        linkedList.appendElement(character3);
        linkedList.appendElement(character5);
        Object[] arr = linkedList.toArray();
        Arrays.equals(expectedResult, arr);
    }

    @Test
    void testingAppendAndPrependAndRemove() {
        String[] expectedResult = {character4, character5};

        //appending four elements
        linkedList.appendElement(character1);
        linkedList.appendElement(character2);
        linkedList.appendElement(character3);
        linkedList.appendElement(character5);

        //removing those four elements
        linkedList.removeElement(character3);
        linkedList.removeElement(character1);
        linkedList.removeElement(character2);
        linkedList.removeElement(character5);

        //prepending four elements
        linkedList.prependElement(character1);
        linkedList.prependElement(character2);
        linkedList.prependElement(character3);
        linkedList.prependElement(character5);

        //removing those four elements
        linkedList.removeElement(character3);
        linkedList.removeElement(character1);
        linkedList.removeElement(character2);
        linkedList.removeElement(character5);

        //append 2 elements
        linkedList.appendElement(character4);
        linkedList.appendElement(character5);

        Object[] arr = linkedList.toArray();
        Arrays.equals(expectedResult, arr);
    }

    @Test
    void testingElementNotInList() {
        boolean expectedResult = false;
        linkedList.appendElement(character1);
        linkedList.appendElement(character2);
        boolean actualResult = linkedList.containsElement(character6);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testingElementInList() {
        boolean expectedResult = true;
        linkedList.appendElement(character1);
        linkedList.appendElement(character2);
        linkedList.appendElement(character3);
        linkedList.appendElement(character5);
        boolean actualResult = linkedList.containsElement(character3);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void removeLastElement() {
        boolean expectedResult = true;
        String[] expectedArray = {character6};

        linkedList.prependElement(character1);
        linkedList.prependElement(character6);
        boolean elementFound = linkedList.removeElement(character1);
        Object[] actualArray = linkedList.toArray();

        assertEquals(expectedResult, elementFound);
        Arrays.equals(expectedArray, actualArray);
    }

    @Test
    void removeElementInList() {
        boolean expectedResult = true;
        String[] expectedArray = {character4, character2, character1};

        linkedList.prependElement(character1);
        linkedList.prependElement(character2);
        linkedList.prependElement(character3);
        linkedList.prependElement(character4);
        boolean elementFound = linkedList.removeElement(character3);
        int listSize = linkedList.size();
        String[] actualArray = new String[listSize];
        linkedList.toArray(actualArray);
        assertEquals(expectedResult, elementFound);
        Arrays.equals(expectedArray, actualArray);
    }

    @Test
    void attemptToRemoveElementNotInList() {
        boolean expectedResult = false;
        String[] expectedArray = {character4, character3, character2, character1};

        linkedList.prependElement(character1);
        linkedList.prependElement(character2);
        linkedList.prependElement(character3);
        linkedList.prependElement(character4);
        boolean elementFound = linkedList.removeElement(character6);
        Object[] actualArray = linkedList.toArray();
        assertEquals(expectedResult, elementFound);
        Arrays.equals(expectedArray, actualArray);
    }

    @Test
    void testCreatingReversedLinkedList() {
        String[] expectedResult = {character4, character3, character2, character6, character1};
        linkedList.prependElement(character1);
        linkedList.prependElement(character6);
        linkedList.prependElement(character2);
        linkedList.prependElement(character3);
        linkedList.prependElement(character4);

        LinkedList<String> reversedLinkedList = linkedList.createReversedLinkedList();
        Arrays.equals(expectedResult, reversedLinkedList.toArray());
    }
}
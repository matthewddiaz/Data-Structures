package com.matthewddiaz.datastructures.lists;

import com.matthewddiaz.designpatterns.behavioralPatterns.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by matthewdiaz on 6/8/17.
 */
public class TestForLists {

    private static void populateList(List<Integer> list){
        list.appendElement(1);
        list.appendElement(2);
        list.appendElement(3);
        list.appendElement(4);
        list.appendElement(5);
    }

    public static void testInsertElement(List<Integer> list){
        String expectedResult = "[ 6, 1, 3, 4, 5, 2, 10 ]";

        list.insertElement(1, 0);
        list.insertElement(2, 1);
        list.insertElement(3, 1);
        list.insertElement(4, 2);
        list.insertElement(5, 3);
        list.insertElement(6,0);
        list.insertElement(10,6);

        assertEquals(expectedResult, list.toString());
    }

    public static void testAppendElement(List<Integer> list){
        String expectedResult = "[ 3, 2, 1, 5, 8, 12, 8, 4 ]";
        list.appendElement(3);
        list.appendElement(2);
        list.appendElement(1);
        list.appendElement(5);
        list.appendElement(8);
        list.appendElement(12);
        list.appendElement(8);
        list.appendElement(4);

        assertEquals(expectedResult, list.toString());
    }

    public static void containsElement(List<Integer> list){
        populateList(list);

        Integer searchElement1 = 15;
        boolean expectedResult1 = false;

        Integer searchElement2 = 3;
        boolean expectedResult2 = true;

        boolean actualResult1 = list.containsElement(searchElement1);
        boolean actualResult2 = list.containsElement(searchElement2);

        assertEquals(expectedResult1, actualResult1);
        assertEquals(expectedResult2, actualResult2);
    }

    public static void testMultipleInsertionMethods(List<Integer> list){
        String expectedResult = "[ 2, 11, 100, 7, 1, 5, 8, 2, 4, 15, 3, 6, 10, 8, 14 ]";

        list.insertElement(1, 0);
        list.insertElement(5, 1);
        list.insertElement(2, 2);

        list.appendElement(4);
        list.appendElement(6);
        list.appendElement(10);

        list.insertElement(8, 2);
        list.insertElement(3, 5);

        list.prependElement(7);
        list.prependElement(100);
        list.prependElement(2);

        list.insertElement(11, 1);
        list.insertElement(15, 9);

        list.appendElement(8);
        list.appendElement(14);
        assertEquals(expectedResult, list.toString());
    }

    public static void testGetElement(List<Integer> list){
        populateList(list);

        int actualResult1 = list.getElement(2);
        assertEquals(3, actualResult1);

        int actualResult2 = list.getElement(0);
        assertEquals(1, actualResult2);
    }

    public static void testRemoveElement(List<Integer> list){
        populateList(list);

        Integer deleteElement1 = 15;
        boolean result1 = list.removeElement(deleteElement1);

        Integer deleteElement2 = 2;
        boolean result2 = list.removeElement(deleteElement2);

        assertEquals(false, result1);
        assertEquals(true, result2);

        String expectedResult = "[ 1, 3, 4, 5 ]";
        assertEquals(expectedResult, list.toString());

        int expectedLength = 4;
        assertEquals(expectedLength, list.size());
    }

    public static void testRemoveElementWithIndexing(List<Integer> list){
        populateList(list);
        int index = 15;

        //testing index out of bound
        try{
            list.removeElement(index);
        }catch (IndexOutOfBoundsException e){
            assertEquals("java.lang.IndexOutOfBoundsException", e.toString());
        }

        //removing an element in a valid index
        int index1 = 2;
        Integer element = list.removeElement(index1);
        assertEquals(new Integer(3), element);
        String expectedResult = "[ 1, 2, 4, 5 ]";
        assertEquals(expectedResult, list.toString());
    }

    public static void testRemoveAllElements(List<Integer> list){
        populateList(list);
        int numOfElements = list.size() - 1;
        while(numOfElements >= 0){
            list.removeElement(numOfElements);
            numOfElements--;
        }

        assertEquals(0, list.size());
    }

    public static void testRemoveAndInsert(List<Integer> list){
        String expectedResult = "[ 2, 3, 10, 8, 15, 4 ]";
        list.insertElement(1,0);
        list.appendElement(3);
        list.prependElement(5);

        list.removeElement(1);
        list.removeElement(0);
        list.removeElement(0);

        assertEquals(0, list.size());

        list.prependElement(6);
        list.insertElement(1,1);
        list.insertElement(4,1);
        list.insertElement(8,1);

        list.removeElement(0);
        list.removeElement(2);


        list.insertElement(2,0);
        list.insertElement(3,1);
        list.insertElement(10,2);
        list.insertElement(15,4);

        assertEquals(expectedResult, list.toString());
        assertEquals(6, list.size());
    }

    public static boolean isEmpty(List<Integer> list){
        return list.isEmpty();
    }

    public static void testPrependElement(List<Integer> list){
        String expectedResult = "[ 4, 15, 17, 2, 1, 16, 100 ]";
        list.prependElement(100);
        list.prependElement(16);
        list.prependElement(1);
        list.prependElement(2);
        list.prependElement(17);
        list.prependElement(15);
        list.prependElement(4);

        String actualResult = list.toString();
        assertEquals(expectedResult, actualResult);
    }

    public static void testSize(List<Integer> list){
        populateList(list);

        int actualListSize  = list.size();
        assertEquals(5, actualListSize);
    }

    public static void testCreateIterator(List<Integer> list){
        String expectedResult = "[ 1, 2, 3, 4, 5 ]";
        populateList(list);

        Iterator<Integer> iterator = list.createIterator();

        assertEquals(expectedResult, printElementsInIterator(iterator));
    }

    private static String printElementsInIterator(Iterator<Integer> iterator){
        StringBuffer strBuffer = new StringBuffer("[ ");

        iterator.first();
        for(; !iterator.isDone(); iterator.next()){
            strBuffer.append(iterator.currentElement() + ", ");
        }
        strBuffer.deleteCharAt(strBuffer.length() - 2);
        strBuffer.append("]");
        return strBuffer.toString();
    }
}

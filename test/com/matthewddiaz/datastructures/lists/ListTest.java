package com.matthewddiaz.datastructures.lists;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by matthewdiaz on 6/8/17.
 */
public class ListTest {

    public static void populateList(List<Integer> list){
        list.appendElement(1);
        list.appendElement(2);
        list.appendElement(3);
        list.appendElement(4);
        list.appendElement(5);
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
        String actualResult = list.toString();
        assertEquals(expectedResult, actualResult);
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

    public static void deleteElement(List<Integer> list){
        populateList(list);

        Integer deleteElement1 = 15;
        boolean result1 = list.deleteElement(deleteElement1);

        Integer deleteElement2 = 2;
        boolean result2 = list.deleteElement(deleteElement2);

        assertEquals(false, result1);
        assertEquals(true, result2);

        String expectedResult = "[ 1, 3, 4, 5 ]";
        assertEquals(expectedResult, list.toString());
    }

    public static void deleteElement1(List<Integer> list){
        populateList(list);
        int index = 15;

        //testing index out of bound
        try{
            list.deleteElement(index);
        }catch (IndexOutOfBoundsException e){
            assertEquals("java.lang.IndexOutOfBoundsException", e.toString());
        };

        //removing an element in a valid index
        int index1 = 2;
        Integer element = list.deleteElement(index1);
        assertEquals(new Integer(3), element);
        String expectedResult = "[ 1, 2, 4, 5 ]";
        assertEquals(expectedResult, list.toString());
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

    public static void size(List<Integer> list){
        populateList(list);

        int actualListSize  = list.size();
        assertEquals(5, actualListSize);
    }

}

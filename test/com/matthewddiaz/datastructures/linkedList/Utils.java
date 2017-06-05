package com.matthewddiaz.datastructures.linkedList;

/**
 * Created by matthewdiaz on 6/4/17.
 */
public class Utils {

    static String character1 = "Goku";
    static String character2 = "Gohan";
    static String character3 = "Vegeta";
    static String character4 = "Bulma";
    static String character5 = "Piccolo";
    static String character6 = "Boo";
    static String character7 = "Trunks";
    static String character8 = "Frieza";
    static String character9 = "Master Roshi";
    static String character10 = "Krillin";

    /**
     * Creates and returns a new Linked List object with 4 elements
     * @return
     */
    public static LinkedList<String> createSimpleLinkedList(){
        LinkedList<String> simpleLinkedList = new LinkedList<>();
        simpleLinkedList.appendElement(character1);
        simpleLinkedList.appendElement(character2);
        simpleLinkedList.appendElement(character3);
        simpleLinkedList.appendElement(character4);
        return simpleLinkedList;
    }

    /**
     * Creates and returns the head node of the newly created Linked List object with 4 elements
     * @return
     */
    public static LinkedList.Node getHeadOfSimpleLinkedList(){
        LinkedList<String> simpleLinkedList = createSimpleLinkedList();
        return simpleLinkedList.getHead();
    }

    /**
     * Creates and returns a new Linked List object with 10 elements
     * @return
     */
    public static LinkedList createComplexLinkedList(){
        LinkedList<String> simpleLinkedList = new LinkedList<>();
        simpleLinkedList.appendElement(character1);
        simpleLinkedList.appendElement(character2);
        simpleLinkedList.appendElement(character3);
        simpleLinkedList.appendElement(character4);
        simpleLinkedList.appendElement(character5);
        simpleLinkedList.appendElement(character6);
        simpleLinkedList.appendElement(character7);
        simpleLinkedList.appendElement(character8);
        simpleLinkedList.appendElement(character9);
        simpleLinkedList.appendElement(character10);

        return simpleLinkedList;
    }


    /**
     * Creates and returns the head node of the newly created Linked List object with 10 elements
     * @return
     */
    public static LinkedList.Node getHeadOfComplexLinkedList(){
        LinkedList<String> complexLinkedList = createComplexLinkedList();
        return complexLinkedList.getHead();
    }
}

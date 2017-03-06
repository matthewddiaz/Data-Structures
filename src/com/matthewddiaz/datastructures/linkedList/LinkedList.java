package com.matthewddiaz.datastructures.linkedList;

import com.matthewddiaz.designpatterns.behavioralPatterns.Iterator;

/**
 * Created by matthewdiaz on 8/28/16.
 */
public class LinkedList<T> {
    private Node head;

    private class Node{
        T element;
        Node next;
    }

    /**
     * Prepends an element to the List
     * @param element
     */
    public void prependElement(T element){
        if(isEmpty()){
            head = createNewNode(element);
        }else{
            Node node = createNewNode(element);
            node.next = head;
            head = node;
        }
    }

    /**
     * Appends an element to the List
     * @param element
     */
    public void appendElement(T element){
        if(isEmpty()){
            head = createNewNode(element);
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = createNewNode(element);
        }
    }

    /**
     * Returns true if the element passed in
     * the parameter is in the list
     * @param element
     * @return
     */
    public boolean containsElement(T element){
        boolean elementIsInList = false;
        if(isEmpty()){
            return elementIsInList;
        }

        Node temp = head;
        while(temp != null){
            if(temp.element == element){
                return !elementIsInList;
            }
            temp = temp.next;
        }

        return elementIsInList;
    }

    /**
     * Removes the element from the list.
     * Returns true if the element was in the list
     * @param element
     * @return
     */
    public boolean removeElement(T element){
        boolean isRemoved = false;
        if(isEmpty()){
            return isRemoved;
        }

        Node temp = head;
        if(temp.element == element){
            temp = temp.next;
            head = temp;
            return !isRemoved;
        }

        while(temp.next != null) {
            Node next = temp.next;
            if (next.element == element) {
                temp.next = next.next;
                return !isRemoved;
            }
            temp = temp.next;
        }

        return isRemoved;
    }

    /**
     * Returns true if list is empty
     * @return
     */
    public boolean isEmpty(){
        return head == null;
    }

    /**
     * Returns a Iterator of the List
     * @return
     */
    public Iterator<T> createIterator(){
        return new Iterator<T>() {
            private Node currentPosition;

            @Override
            public void first() {
                currentPosition = head;
            }

            @Override
            public T currentElement() {
                return currentPosition.element;
            }

            @Override
            public void next() {
                currentPosition = currentPosition.next;
            }

            @Override
            public boolean isDone() {
                return currentPosition == null;
            }
        };
    }

    /**
     * helper method that creates a new Node
     * @param element
     * @return
     */
    private Node createNewNode(T element) {
        Node node = new Node();
        node.element = element;
        node.next = null;
        return node;
    }

    /**
     * Reverse the input of this list
     * 1) Create a head Node = null;
     * 2) iterate input list until you reach null
     *     a) for the node if head is equal to null head is equal to node
     *     b) create a temp node. set temp equal to node. make temp point to head. set head to temp
     * 3) Set our original head equal to the newHead
     *
     */
    public void reverseList(){
        this.head = reverseList(this.head);
    }

    private Node reverseList(Node node){
        Node list = null;
        while(node != null){
            if(list == null){
                list = node;
            }else{
                Node temp = node;
                temp.next = list;
                list = temp;
            }
            node = node.next;
        }
        return list;
    }
}

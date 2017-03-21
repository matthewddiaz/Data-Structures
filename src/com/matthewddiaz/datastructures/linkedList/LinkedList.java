package com.matthewddiaz.datastructures.linkedList;

import com.matthewddiaz.designpatterns.behavioralPatterns.Iterator;

/**
 * Created by matthewdiaz on 8/28/16.
 */
public class LinkedList<T> {
    private Node head;
    private Node tail;
    private int numOfElements;

    private class Node{
        T element;
        Node next;

        Node(T element){
            this.element = element;
            this.next = null;
        }
    }

    public LinkedList(){
        this.head = null;
        this.tail = this.head;
    }

    /**
     * Prepends an element to the List
     * Sets head pointer to the newly created Node
     * @param element
     */
    public void prependElement(T element){
        Node newNode = new Node(element);

        if(isEmpty()){
            addFirstNode(newNode);
        }else{
            newNode.next = this.head;
            this.head = newNode;
        }
        this.numOfElements++;
    }

    /**
     * Appends an element to the List
     * Sets tail pointer to the newly created Node
     * @param element
     */
    public void appendElement(T element){
        Node newNode = new Node(element);

        if(isEmpty()){
            addFirstNode(newNode);
        }else{
            this.tail.next = newNode;
            this.tail = this.tail.next;
        }
        this.numOfElements++;
    }

    /**
     * Anytime the first node is added to an empty list
     * head and tail both point to it. This is to avoid
     * the problem of prepending or appending to null pointers.
     * @param node
     */
    private void addFirstNode(Node node){
        this.head = node;
        this.tail = this.head;
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

        Node temp = this.head;
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

        if(this.head.element == element){
            this.head = this.head.next;
            this.numOfElements--;
            return !isRemoved;
        }

        Node temp = head;
        while(temp != null){
            Node next = temp.next;
            if((next != null) && (next.element == element)){
                temp.next = next.next;
                this.numOfElements--;
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
     * Returns an array containing all of the elements in this list
     * in order from head till end.
     * @return
     */
    public Object[] toArray(){
        Object[] arr = new Object[this.numOfElements];
        Iterator<T> iterator = createIterator();
        int currentIndex = 0;
        for(iterator.first(); !iterator.isDone(); iterator.next()){
            arr[currentIndex++] = iterator.currentElement();
        }
        return arr;
    }

    /**
     * Creating a new LinkedList that contains the data of the original Linked List in
     * reverse order.
     */
    public LinkedList<T> createReversedLinkedList(){
        //creating new LinkedList
        LinkedList<T> reversedLinkedList = new LinkedList();
        Iterator<T> iterator = this.createIterator();
        //iterating through the current LinkedList and prepending the
        //current element of the iterator to the new reversed LinkedList
        for(iterator.first(); !iterator.isDone(); iterator.next()){
            reversedLinkedList.prependElement(iterator.currentElement());
        }
        return reversedLinkedList;
    }
}

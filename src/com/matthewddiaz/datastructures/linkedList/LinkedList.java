package com.matthewddiaz.datastructures.linkedList;

import com.matthewddiaz.designpatterns.behavioralPatterns.Iterator;

/**
 * Created by matthewdiaz on 8/28/16.
 */
public class LinkedList<T> {
    private Node head;
    private Node tail;
    private int numOfElements;

    public static class Node<T>{
        T element;
        Node next;

        Node(T element){
            this.element = element;
            this.next = null;
        }

        public Node getNext(){
            return this.next;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public T getElement(){
            return this.element;
        }
    }

    public LinkedList(){
        this.head = null;
        this.tail = this.head;
        this.numOfElements = 0;
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
                return (T)currentPosition.element;
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
     * Returns the input array with elements from the list; in the
     * same order as the linked list.
     * @param array
     * @return
     */
    public T[] toArray(T[] array){
        Iterator<T> iterator = createIterator();
        int currentIndex = 0;

        iterator.first();
        //break loop if iterator is done traversing the linked list
        //or currentIndex is greater than or equal to array.length
        while(!iterator.isDone() && currentIndex < array.length){
            array[currentIndex++] = iterator.currentElement();
            iterator.next();
        }
        return array;
    }

    /**
     * Returns the number of elements in the list
     * @return
     */
    public int size(){
        return this.numOfElements;
    }

    /**
     * Creating a new DisjointLinkedList that contains the data of the original Linked List in
     * reverse order.
     */
    public LinkedList<T> createReversedLinkedList(){
        //creating new DisjointLinkedList
        LinkedList<T> reversedLinkedList = new LinkedList();
        Iterator<T> iterator = this.createIterator();
        //iterating through the current DisjointLinkedList and prepending the
        //current element of the iterator to the new reversed DisjointLinkedList
        for(iterator.first(); !iterator.isDone(); iterator.next()){
            reversedLinkedList.prependElement(iterator.currentElement());
        }
        return reversedLinkedList;
    }

    /**
     * Returns a String of all of the elements in the linked list. In order from head to tail.
     * Format: [ obj1, obj2, obj3 ]
     * @return
     */
    @Override
    public String toString(){
        return toString(this.head);
    }

    /**
     * Returns a String of all of the elements in the linked list pointed to by the head input node
     * In order from head to tail.
     * Format: [ obj1, obj2, obj3 ]
     * @param headPtr
     * @return
     */
    public static String toString(Node headPtr){
        if(headPtr == null){
            return "Empty Linked List";
        }

        StringBuffer linkedListStr = new StringBuffer("[ " + headPtr.element);
        Node currentPtr = headPtr.next;

        while(currentPtr != null){
            linkedListStr.append(", " + currentPtr.element);
            currentPtr = currentPtr.next;
        }

        linkedListStr.append(" ]");
        return linkedListStr.toString();
    }

    /**
     * Returns pointer of first element in DisjointLinkedList (head)
     * @return
     */
    public Node getHead(){
        return this.head;
    }
}

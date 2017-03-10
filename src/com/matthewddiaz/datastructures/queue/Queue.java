package com.matthewddiaz.datastructures.queue;

import com.matthewddiaz.designpatterns.behavioralPatterns.Iterator;

/**
 * Created by matthewdiaz on 8/29/16.
 */
public class Queue<T> {
    private Node<T> head;
    private Node<T> tail;
    //necessary for toArray() method; need to know the length of the array.
    private int numOfElements;

    public Queue(){
        head = null;
        tail = head;
        numOfElements = 0;
    }

    private class Node<T>{
        T element;
        Node next;
    }

    /**
     * Returns true if the Queue is empty
     * @return
     */
    public boolean isEmpty(){
        return head == null;
    }

    /**
     * Inserts an element at the end (tail) of the com.matthewddiaz.queue
     * @param element
     */
    public void enqueue(T element){
        if(isEmpty()){
            head = createNewNode(element);
            tail = head;
        }else{
            tail.next = createNewNode(element);
            tail = tail.next;
        }
        numOfElements++;
    }

    /**
     * Removes an element from the front (head) of the com.matthewddiaz.queue
     * @return
     */
    public T dequeue(){
        if(isEmpty()){
            return null;
        }

        T value = head.element;
        head = head.next;
        numOfElements--;
        return value;
    }

    /**
     * Helper method that creates a new Node
     * @param element
     * @return
     */
    private Node createNewNode(T element){
        Node node = new Node();
        node.element = element;
        node.next = null;
        return node;
    }

    /**
     * Creates a new Iterator. The iterator traverses the list from the
     * head to the last element the tail in the queue.
     * @return
     */
    public Iterator<T> createIterator(){
        return new Iterator<T>() {
            private Node<T> currentPosition = null;

            @Override
            public void first() {
                this.currentPosition = head;
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
     * Returns a new Object array of of the elements in the Queue
     * the array contains the elements ordered from head to tail
     * of the Queue.
     * @return
     */
    public Object[] toArray(){
        Object[] array = new Object[numOfElements];
        Iterator<T> iterator = createIterator();

        int currentPosition = 0;
        for(iterator.first(); !iterator.isDone(); iterator.next()){
            array[currentPosition++] = iterator.currentElement();
        }
        return array;
    }
}

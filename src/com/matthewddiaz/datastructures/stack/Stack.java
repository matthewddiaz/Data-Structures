package com.matthewddiaz.datastructures.stack;

import com.matthewddiaz.designpatterns.behavioralPatterns.Iterator;

/**
 * Created by matthewdiaz on 8/28/16.
 */
public class Stack<T> {
    private Node<T> head;
    //necessary for toArray() method; need to know the length of the array.
    private int numOfElements;

    private class Node<T>{
        T element;
        Node next;
    }

    public Stack(){
        head = null;
        numOfElements = 0;
    }

    /**
     * Inserts an element to the top of the com.matthewddiaz.stack
     * @param element
     */
    public void push(T element){
        if(isEmpty()){
            head = createNewNode(element);
        }else{
            Node node = createNewNode(element);
            node.next = head;
            head = node;
        }
        numOfElements++;
    }

    /**
     * Removes the element at the top of the com.matthewddiaz.stack
     * @return
     */
    public T pop(){
        if(isEmpty()){
            return null;
        }

        T val = head.element;
        head = head.next;
        numOfElements--;
        return val;
    }

    /**
     * Returns the element at the top of the com.matthewddiaz.stack
     * @return
     */
    public T peak(){
        if(isEmpty()){
            return null;
        }

        T val = head.element;
        return val;
    }

    /**
     * Returns true if the com.matthewddiaz.stack is empty
     * @return
     */
    public boolean isEmpty(){
        return head == null;
    }

    /**
     * Returns a new Iterator of the Stack
     * @return
     */
    public Iterator<T> createIterator(){
        return new Iterator<T>() {
            private Node<T> currentPosition;

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
     * Returns a new array of the elements in the stack ordered from the element at the
     * top of the stack to the bottom.
     * @return
     */
    public Object[] toArray(){
        Object[] array = new Object[this.numOfElements];
        Iterator<T> iterator = createIterator();
        int currentPosition = 0;

        for(iterator.first(); !iterator.isDone(); iterator.next()){
            array[currentPosition++] = iterator.currentElement();
        }
        return array;
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
}

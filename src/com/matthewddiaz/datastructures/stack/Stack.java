package com.matthewddiaz.datastructures.stack;

/**
 * Created by matthewdiaz on 8/28/16.
 */
public class Stack<T> {
    private Node<T> head;

    private class Node<T>{
        T element;
        Node next;
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

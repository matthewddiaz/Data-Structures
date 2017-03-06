package com.matthewddiaz.datastructures.queue;

/**
 * Created by matthewdiaz on 8/29/16.
 */
public class Queue<T> {
    private Node<T> head;
    private Node<T> tail;

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
}

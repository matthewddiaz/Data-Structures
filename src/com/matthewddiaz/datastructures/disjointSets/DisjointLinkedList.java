package com.matthewddiaz.datastructures.disjointSets;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by matthewdiaz on 5/30/17.
 */
public class DisjointLinkedList<T> {
    private Node<T> head;//points to first Node in Set
    private Node<T> tail;//points to last node in Set
    private int size;//keeps track of the number of Nodes in Set

    static class Node<T>{
        DisjointLinkedList setPtr;//points to set object
        Node nextPtr;//points to next object in set
        T member;//member that Node contains

        public Node(T member){
            this.member = member;
            setPtr = null;
            nextPtr = null;
        }

        public T getMember() {
            return member;
        }
    }

    //default constructor creates a new empty DisjointLinkedList
    public DisjointLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //Constructs a new DisjointLinkedList with node as its only node
    public DisjointLinkedList(Node<T> node){
        this.size = 0;
        appendNode(node);
    }

    //returns true if the DisjointLinkedList is empty
    public boolean isEmpty(){
        return this.head == null;
    }

    //appends the input node to the end of the Set
    public void appendNode(Node<T> node){
        if(isEmpty()){
            //set head equal to node
            this.head = node;
            this.tail = this.head;
        }else{
            //append node to tail
            tail.nextPtr = node;
            tail = tail.nextPtr;
        }
        //set node representative pointer to point to set object
        node.setPtr = this;

        //increment the number of elements in the set
        this.size++;
    }

    //appends the input list to this set
    public void appendSet(DisjointLinkedList set){
        Node setNodePtr = set.head;
        while(setNodePtr != null){
            this.appendNode(setNodePtr);
            setNodePtr = setNodePtr.nextPtr;
        }
    }

    //getter method for head class attribute
    public Node getHead(){
        return this.head;
    }

    //getter method for tail class attribute
    public Node getTail(){
        return  this.tail;
    }

    //getter method for size class attribute
    public int getSize(){
        return this.size;
    }

    //returns a Set of all of the elements
    public Set<T> getSet(){
        Set<T> disjointSet = new HashSet<T>();
        //Current Pointer points to head
        Node<T> currentPtr = this.head;

        while(currentPtr != null){
            disjointSet.add(currentPtr.member);
            currentPtr = currentPtr.nextPtr;
        }

        return disjointSet;
    }

    /**
     * Returns a String representation of the disjoint set
     * Format: "[ e1, e2, e3, e4 ]"
     * @return
     */
    @Override
    public String toString(){
        if(size == 0){
            return "Empty Set";
        }
        StringBuffer buffer = new StringBuffer("[ " + this.getHead().member);

        //current Pointer will point to second node in list
        Node currentPtr = this.head.nextPtr;

        while(currentPtr != null){
            buffer.append(", " + currentPtr.member);
            currentPtr = currentPtr.nextPtr;
        }

        buffer.append(" ]");
        return buffer.toString();
    }
}

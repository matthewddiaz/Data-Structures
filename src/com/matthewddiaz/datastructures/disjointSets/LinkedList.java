package com.matthewddiaz.datastructures.disjointSets;

/**
 * Created by matthewdiaz on 5/30/17.
 */
public class LinkedList<T> {
    private Node head;//points to first Node in Set
    private Node tail;//points to last node in Set
    private int size;//keeps track of the number of Nodes in Set

    static class Node<T>{
        LinkedList representativePtr;//points to set object
        Node nextPtr;//points to next object in set
        T member;//member that Node contains

        public Node(T member){
            this.member = member;
            representativePtr = null;
            nextPtr = null;
        }

        public T getMember() {
            return member;
        }
    }

    //default constructor creates a new empty LinkedList
    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //Constructs a new LinkedList with node as its only node
    public LinkedList(Node node){
        this.size = 0;
        appendNode(node);
    }

    //returns true if the LinkedList is empty
    public boolean isEmpty(){
        return this.head == null;
    }

    //appends the input node to the end of the Set
    public void appendNode(Node node){
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
        node.representativePtr = this;

        //increment the number of elements in the set
        this.size++;
    }

    //appends the input list to this set
    public void appendSet(LinkedList set){
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
}

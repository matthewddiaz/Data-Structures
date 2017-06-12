package com.matthewddiaz.datastructures.disjointSets;

import java.util.*;

/**
 * Created by matthewdiaz on 5/30/17.
 */
public class DisjointSetsBackByLinkedLists<T> implements DisjointSets<T> {
    //map with a key being input element and value being wrapper Node object
    Map<T, DisjointLinkedList.Node<T>> elementMap;

    //maintains the list disjoint sets
    List<DisjointLinkedList<T>> disjointSets;

    //default constructor
    public DisjointSetsBackByLinkedLists(){
        disjointSets = new ArrayList<>();
        elementMap = new HashMap<>();
    }

    //Constructor when wanting to create the Disjoint Set with dataSet
    public DisjointSetsBackByLinkedLists(Collection<T> dataSet){
        disjointSets = new ArrayList<>();
        elementMap = new HashMap<>();

        for(T element: dataSet){
            makeSet(element);
        }
    }

    //deletes and removes the input disjointSet from the class attribute disjointSets
    private void deleteSet(DisjointLinkedList<T> disjointSet){
        this.disjointSets.remove(disjointSet);
    }

    @Override
    public void makeSet(T element) {
        //creating a new Node (wrapper for element) to insert into linked list
        DisjointLinkedList.Node elementNode = new DisjointLinkedList.Node(element);

        //adding element to elementMap to form relation between it an its node
        elementMap.put(element, elementNode);

        //creating a new disjoint set with elementNode as the only element
        DisjointLinkedList disjointLinkedList = new DisjointLinkedList(elementNode);

        //adding the new disjoint set to the list
        disjointSets.add(disjointLinkedList);
    }

    @Override
    public T findSet(T element) {
        DisjointLinkedList.Node<T> representativeNode = findSet(getElementNode(element));
        return representativeNode.member;
    }

    //returns the representative node of the set that the input node is in.
    //that is the node at head points to in that set
    private DisjointLinkedList.Node findSet(DisjointLinkedList.Node node){
        DisjointLinkedList.Node firstNode = node.representativePtr.getHead();
        return firstNode;
    }

    @Override
    public void union(T elementX, T elementY) {
        DisjointLinkedList.Node xNode = getElementNode(elementX);
        DisjointLinkedList.Node yNode = getElementNode(elementY);

        union(xNode, yNode);
    }

    @Override
    public int numOfDisjointSets() {
        return disjointSets.size();
    }

    //appends all nodes of y into disjoint set x
    private void union(DisjointLinkedList.Node x, DisjointLinkedList.Node y){
        //making sure that x and y are not in the same set
        if(findSet(x) != findSet(y)){

            DisjointLinkedList disjointSetOfX = x.representativePtr;
            DisjointLinkedList disjointSetOfY = y.representativePtr;

            //using weight heuristic to save a bit of time
            //Append the shorter disjoint set to the larger disjoint set
            if(disjointSetOfX.getSize() > disjointSetOfY.getSize()){
                union(disjointSetOfX, disjointSetOfY);
            }else{
                union(disjointSetOfY, disjointSetOfX);
            }
        }
    }

    //appends all nodes in set2 into set1 and then deletes sets2
    private void union(DisjointLinkedList<T> disjointSet1, DisjointLinkedList<T> disjointSet2){
        disjointSet1.appendSet(disjointSet2);
        deleteSet(disjointSet2);
    }

    private DisjointLinkedList.Node<T> getElementNode(T element){
        return elementMap.get(element);
    }

    //returns the list of disjoint sets
    public List<Set<T>> getDisjointSets(){
        List<Set<T>> listOfDisjointSets = new ArrayList<>();

        //for each DisjointLinkedList create a new Set (s) and insert all of its elements into the s
        for(DisjointLinkedList disjointLinkedList : disjointSets){
               listOfDisjointSets.add(disjointLinkedList.getSet());
        }
        return listOfDisjointSets;
    }

    @Override
    public String toString(){
        //case when there are no disjoint sets
        if(disjointSets.size() == 0){
            return "No Sets";
        }

        StringBuffer buffer = new StringBuffer();

        for(DisjointLinkedList disjointLinkedList : disjointSets){
            buffer.append(disjointLinkedList.toString() + "\n");
        }
        return buffer.toString();
    }
}

package com.matthewddiaz.datastructures.disjointSets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by matthewdiaz on 5/30/17.
 */
public class DisjointSet<T> {
    //maintains the list disjoint sets
    List<LinkedList<T>> disjointSets;

    //default constructor
    public DisjointSet(){
        disjointSets = new ArrayList<>();
    }

    //Constructor when wanting to create the Disjoint Set with dataSet
    public DisjointSet(Collection<LinkedList.Node<T>> dataSet){
        disjointSets = new ArrayList<>();

        for(LinkedList.Node node : dataSet){
            makeSet(node);
        }
    }

    //creates a new disjoint set with the input node as its only node.
    public void makeSet(LinkedList.Node node){
        LinkedList disjointSet = new LinkedList(node);
        disjointSets.add(disjointSet);
    }

    //returns the representative node of the set that the input node is in.
    //that is the node at head points to in that set
    public LinkedList.Node findSet(LinkedList.Node node){
        LinkedList.Node firstNode = node.representativePtr.getHead();
        return firstNode;
    }

    //appends all nodes of y into disjoint set x
    public void union(LinkedList.Node x, LinkedList.Node y){
        //making sure that x and y are not in the same set
        if(findSet(x) != findSet(y)){

            LinkedList disjointSetOfX = x.representativePtr;
            LinkedList disjointSetOfY = y.representativePtr;

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
    private void union(LinkedList<T> disjointSet1, LinkedList<T> disjointSet2){
        disjointSet1.appendSet(disjointSet2);
        deleteSet(disjointSet2);
    }

    //deletes and removes the input disjointSet from the class attribute disjointSets
    private void deleteSet(LinkedList<T> disjointSet){
        this.disjointSets.remove(disjointSet);
    }

    //returns the list of disjoint sets
    public List<LinkedList<T>> getDisjointSets(){
        return this.disjointSets;
    }

}

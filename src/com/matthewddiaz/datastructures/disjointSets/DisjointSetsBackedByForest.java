package com.matthewddiaz.datastructures.disjointSets;

import java.util.*;

/**
 * Created by matthewdiaz on 6/2/17.
 */
public class DisjointSetsBackedByForest<T> implements DisjointSets<T>{
    //contains a list of disjoint sets
    private Map<DisjointRootedTree.Node, DisjointRootedTree> disjointSets;

    //Mapping between input element and their wrapper element Node
    private Map<T, DisjointRootedTree.Node<T>> elementMap;

    //default constructor initializes disjointSets
    public DisjointSetsBackedByForest(){
        disjointSets = new HashMap<>();
    }

    //initializes disjointSets and then creates a new disjoint set for every
    //element in the input collection
    public DisjointSetsBackedByForest(Collection<T> dataSet){
        disjointSets = new HashMap<>();

        for(T element : dataSet){
            makeSet(element);
        }
    }

    @Override
    public void makeSet(T element) {
        //create a new wrapper node for input element
        DisjointRootedTree.Node elementNode = new DisjointRootedTree.Node(element);
        makeSet(elementNode);

        //insert key: element; value: elementNode into elementMap
        elementMap.put(element, elementNode);
    }

    //Creates a new disjoint set with the input node as its only member
    private void makeSet(DisjointRootedTree.Node node){
        DisjointRootedTree disjointSet = new DisjointRootedTree(node);
        disjointSets.put(node, disjointSet);
    }

    @Override
    public T findSet(T element) {
        //retrieve node for input element
        DisjointRootedTree.Node<T> elementNode = elementMap.get(element);
        //acquire representative node of the set that element node is in
        DisjointRootedTree.Node<T> representativeNode = findSet(elementNode);

        return representativeNode.member;
    }

    //returns the root node of the tree that the input node is found in
    //NOTE: this algorithm uses path compression, which points all nodes
    //in the path from node to the root point directly to root.
    private DisjointRootedTree.Node findSet(DisjointRootedTree.Node node){
        if(node != node.parentPtr){
            node.parentPtr =  findSet(node.parentPtr);
        }

        return node.parentPtr;
    }

    @Override
    public void union(T elementX, T elementY) {
        DisjointRootedTree.Node nodeX = elementMap.get(elementX);
        DisjointRootedTree.Node nodeY = elementMap.get(elementY);
        union(nodeX, nodeY);
    }

    /**
     * union of disjoint set x and y.
     * NOTE: This algorithm uses union by rank, which makes the tree whose root
     * has lesser rank point to the other tree's root. If the both roots
     * have equal height than the first one is picked and its root rank is incremented by 1.
     * @param x
     * @param y
     */
    public void union(DisjointRootedTree.Node x, DisjointRootedTree.Node y){
        DisjointRootedTree.Node rootOfX = findSet(x);
        DisjointRootedTree.Node rootOfY = findSet(y);

        if(rootOfX != rootOfY){
            if(rootOfX.rank > rootOfY.rank){
                mergeTrees(rootOfX, rootOfY);
                removeDisjointSet(y);
            }else{
                mergeTrees(rootOfY, rootOfX);
                if(rootOfX.rank == rootOfY.rank){
                    rootOfY.rank++;
                }
                removeDisjointSet(x);
            }
        }
    }

    //merges Y tree into X tree. That means that the root of Y now points to the root of X.
    private void mergeTrees(DisjointRootedTree.Node rootX, DisjointRootedTree.Node rootY){
        rootY.parentPtr = rootX;
    }

    //removes the disjoint that contains the given node from disjoint sets
    //NOTE: only works if given representative node
    private void removeDisjointSet(DisjointRootedTree.Node representativeNode){
        disjointSets.remove(representativeNode);
    }

    @Override
    public int numOfDisjointSets() {
        return 0;
    }

    @Override
    public List<Set<T>> getDisjointSets() {
        return null;
    }

}


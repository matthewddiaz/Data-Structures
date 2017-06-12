package com.matthewddiaz.datastructures.disjointSets;

import java.util.*;

/**
 * Created by matthewdiaz on 6/2/17.
 */
public class DisjointSetsBackedByForest<T> implements DisjointSets<T>{
    //contains a list of the root node of all the disjoint sets
    private List<DisjointRootedTree.Node> disjointSetRoots;

    //Mapping between input element and their wrapper element Node
    private Map<T, DisjointRootedTree.Node<T>> elementMap;

    //default constructor initializes disjointSets
    public DisjointSetsBackedByForest(){
        disjointSetRoots = new ArrayList<>();
        elementMap = new HashMap<>();
    }

    //initializes disjointSets and then creates a new disjoint set for every
    //element in the input collection
    public DisjointSetsBackedByForest(Collection<T> dataSet){
        disjointSetRoots = new ArrayList<>();
        elementMap = new HashMap<>();

        for(T element : dataSet){
            makeSet(element);
        }
    }

    @Override
    public void makeSet(T element) {
        //create a new wrapper node for input element
        DisjointRootedTree.Node elementNode = createRootNode(element);
        makeSet(elementNode);

        //insert key: element; value: elementNode into elementMap
        elementMap.put(element, elementNode);
    }

    /**
     * Creating a new Wrapper node of input element
     * NOTE: This wrapper node is all the root node of the tree
     * and therefore its parent is itself.
     * @param element
     * @return
     */
    private DisjointRootedTree.Node createRootNode(T element){
        DisjointRootedTree.Node elementNode = new DisjointRootedTree.Node(element);
        elementNode.parentPtr = elementNode;
        return elementNode;
    }

    //Creates a new disjoint set with the input node as its only member
    private void makeSet(DisjointRootedTree.Node node){
        node.parentPtr = node;
        disjointSetRoots.add(node);
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
                removeDisjointSet(rootOfY);
            }else{
                mergeTrees(rootOfY, rootOfX);
                if(rootOfX.rank == rootOfY.rank){
                    rootOfY.rank++;
                }
                removeDisjointSet(rootOfX);
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
        disjointSetRoots.remove(representativeNode);
    }

    @Override
    public int numOfDisjointSets() {
        return disjointSetRoots.size();
    }

    @Override
    public List<Set<T>> getDisjointSets() {
        HashMap<DisjointRootedTree.Node<T>, Set<T>> mapOfDisjointSets = new HashMap<>();

        //for each wrapper node determine the mapOfDisjointSets it is part of
        for(DisjointRootedTree.Node<T> node : elementMap.values()){
            DisjointRootedTree.Node<T> representativeNode = findSet(node);
            if(!mapOfDisjointSets.containsKey(representativeNode)){
                Set<T> disjointSet = new HashSet();
                disjointSet.add(node.member);
                mapOfDisjointSets.put(representativeNode, disjointSet);
            }else{
                Set<T> disjointSet = mapOfDisjointSets.get(representativeNode);
                disjointSet.add(node.member);
                mapOfDisjointSets.replace(representativeNode, disjointSet);
            }
        }

        List<Set<T>> list = new ArrayList<>();
        for(Set set : mapOfDisjointSets.values()){
            list.add(set);
        }
        return list;
    }

    @Override
    public String toString(){
        if(disjointSetRoots.size() == 0){
            return "No Sets";
        }

        StringBuffer buffer = new StringBuffer();
        List<Set<T>> listOfDisjointSets = getDisjointSets();

        for(Set<T> disjointSet : listOfDisjointSets){
            buffer.append("[ ");
            for(T element : disjointSet){
                buffer.append(element + ", ");
            }
            buffer.deleteCharAt(buffer.length() - 2);
            buffer.append("]\n");
        }

        return buffer.toString();
    }

}


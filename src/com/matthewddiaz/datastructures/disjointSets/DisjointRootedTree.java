package com.matthewddiaz.datastructures.disjointSets;

/**
 * Created by matthewdiaz on 6/2/17.
 */
public class DisjointRootedTree<T> {
    //class attribute pointer to root node of this rooted tree
    private Node root;

    //inner class Node
    static class Node<T>{
        Node parentPtr; // points to parent node
        T member; // member attribute
        int rank; //keeps track of height of node

        public Node(T member){
            this.member = member;
            parentPtr = null;
            this.rank = 0;
        }
    }

    //default constructor. Creates a new empty Disjoint Rooted Tree
    public DisjointRootedTree(){
        this.root = null;
    }


    public DisjointRootedTree(Node node){
        addNode(node);
    }

    //returns true if this tree is empty
    public boolean isEmpty(){
        return this.root == null;
    }

    //adds Node into the disjoint tree
    public void addNode(Node node){
        if(isEmpty()){
            this.root = node;
        }
        node.parentPtr = this.root;
    }
}

package com.matthewddiaz.datastructures.trees;

import com.matthewddiaz.datastructures.queue.Queue;

/**
 * Created by matthewdiaz on 4/21/17.
 */
public class BinaryTree<T> {
    private Node<T> root;

    private class Node<T>{
        Node leftChild;
        Node rightChild;
        T element;

        Node(T element) {
            this.element = element;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    /**
     * Default constructor.
     * Should be used when creating a new Tree.
     */
    public BinaryTree(){
        this.root = null;
    }

    /**
     * Constructor for importing a preexisting Tree.
     * @param root
     */
    public BinaryTree(Node<T> root){
        this.root = root;
    }

    /**
     * Inserts the element using In-Order traversal insertion to the binary tree
     * @param element
     */
    public void insertElement(T element){
        Node<T> node = new Node(element);

        if(isEmpty()){
            this.root = node;
            return;
        }

        Queue<Node<T>> queue = new Queue();
        queue.enqueue(this.root);

        while(!queue.isEmpty()){
            Node<T> topNode = queue.peak();
            Node<T> leftChild = topNode.leftChild;
            Node<T> rightChild = topNode.rightChild;

            if(leftChild == null){
                topNode.leftChild = node;
                return;
            }else{
                queue.enqueue(leftChild);
            }

            if(rightChild == null){
                topNode.rightChild = node;
                return;
            }else{
                queue.enqueue(rightChild);
            }

            if(leftChild != null && rightChild != null){
                queue.dequeue();
            }
        }
    }

    /**
     * If the element is in the tree; removes and returns the element.
     * If the element is not in the tree then null is returned.
     * @param element
     * @return
     */
    public T deleteElement(T element){
        return element;
    }

    /**
     * Returns true if the element passed in the parameter is in the tree.
     * @param element
     * @return
     */
    public boolean containsElement(T element){
        return true;
    }

    /**
     * Returns true if binary tree is empty.
     * @return
     */
    public boolean isEmpty(){
        return root == null;
    }


    public void printInOrderTraversal(){
        printInOrder(this.root);
    }

    private void printInOrder(Node root){
        if(root == null){
            return;
        }

        printInOrder(root.leftChild);
        System.out.println(root.element);
        printInOrder(root.rightChild);
    }
}

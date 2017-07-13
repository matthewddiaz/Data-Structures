package com.matthewddiaz.datastructures.trees;

import java.util.Deque;

/**
 * Created by matthewdiaz on 8/30/16.
 */

/**
 * A Binary Search Tree is a Tree where each node can have a most 2 children. Furthermore
 * the leftChild subtree contains elements that are less than the root key. The rightChild subtree contains
 * elements that are greater than or equal to the root key.
 */
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree{
    /**
     * Default constructor
     * Note: This constructor should be used when creating a new empty BST
     */
    public BinarySearchTree(){
        super();
    }

    /**
     * Constructor that takes in a pre-existing tree
     * sets its root equal to the Node passed in the parameter.
     * @param root
     */
    public BinarySearchTree(Node root){
        super(root);
    }

    /**
     * Returns true if the root is equal to null
     * @return
     */
    public boolean isEmpty(){
        return this.root == null;
    }

    /**
     * Inserts the key into the BST
     * @param element
     */
    public void insertElement(Comparable element){
        Node node = new Node(element);
        if(isEmpty()){
            root = node;
        }else{
            //obtain parent node of node of the newly created node to be inserted to BST.
            Node parentPtr = getParentNode(node);
            int compareValue = parentPtr.key.compareTo(element);
            //if parent key is less than the inserting element value; then element becomes parent's right child
            if(compareValue < 0){
                parentPtr.rightChild = node;
            }else{
                parentPtr.leftChild = node;
            }
        }
    }

    /**
     * Returns the parent of a given node.
     * NOTE: Returns null if the node passed in the parameter is the root.
     * @param childNode
     * @return
     */
    private Node getParentNode(Node childNode){
        //the root node does not contain a parent
        if(childNode == this.root){
            return null;
        }

        //Creating two pointers. One points to the current node and another to its parent.
        //Note: searching for parent of child node. CurrentPtr starts at the root node
        Node currentPtr = this.root;
        Node parentPtr = null;
        while((currentPtr != null) && (currentPtr != childNode)) {
            parentPtr = currentPtr;
            int compareValue = currentPtr.key.compareTo(childNode.key);
            //if current pointer key value is less childNode key value; set current pointer equal to it's right child
            if (compareValue < 0) {
                currentPtr = currentPtr.rightChild;
            } else {
                currentPtr = currentPtr.leftChild;
            }
        }
        return parentPtr;
    }

    public void deleteNode(T key){
        //find node in tree;
        Node node = treeSearch(key);
        //if node does not exist exit
        if(node != null){
            deleteNode(node);
        }
    }

    public void deleteNode(Node node){
        int numOfChildren = node.numOfChildren();
        if(numOfChildren == 2){
            deleteNodeWithTwoChildren(node);
        }else{
            Node parent = getParentNode(node);
            if(numOfChildren == 0){
                deleteNodeWithNoChild(parent, node);
            }else if(numOfChildren == 1){
                deleteNodeWith1Child(parent, node);
            }
        }
    }

    private void deleteNodeWithTwoChildren(Node deleteNode){
        //successor is min node in the input node's rightChild subtree
        Node successor = minimum(deleteNode.rightChild);
        //find parent of successor
        Node parentOfSuccessor = getParentNode(successor);
        //set the input node's key to successor's key
        deleteNode.key = successor.key;
        //set successor's rightChild child as successor's parent leftChild child
        parentOfSuccessor.leftChild = successor.rightChild;
    }

    private void deleteNodeWithNoChild(Node parentNode, Node deleteNode){
        if(parentNode == null){
            this.root = null;
        }else{
            int compareValue = parentNode.key.compareTo(deleteNode.key);
            //if parentNode key value is less than deleteNode key value; delete the parentNode's right child
            if(compareValue < 0){
                parentNode.rightChild = null;
            }else{
                parentNode.leftChild = null;
            }
        }
    }

    private void deleteNodeWith1Child(Node parentNode, Node deleteNode){
        //saving the child single child of deleteNode
        Node childOfDeleteNode = (deleteNode.rightChild == null) ? deleteNode.leftChild : deleteNode.rightChild;

        if(parentNode == null){
            this.root = childOfDeleteNode;
        }else{
            int compareValue = parentNode.key.compareTo(deleteNode.key);
            //if parentNode key value is less than deleteNode key value; childOfDeleteNode is set to parentNode's right child
            if(compareValue < 0){
                parentNode.rightChild = childOfDeleteNode;
            }else{
                parentNode.leftChild = childOfDeleteNode;
            }
        }
    }

    /**
     * Inserts an element into the BST.
     * NOTE: this operation is the same as insertElement
     * which is written in a iterative fashion.
     * @param element
     */
    public void insertElementRecursiveApproach(T element){
        this.root = insertElement(this.root, element);
    }

    /**
     * Helper method to insertElementRecursiveApproach
     * @param currentNode
     * @param element
     * @return
     */
    private Node insertElement(Node currentNode, T element){
        if(currentNode == null){
            return new Node(element);
        }
        //if currentNode's key value is less than element's key value; then element must in currentNode's right subtree
        int compareValue = currentNode.key.compareTo(element);
        if(compareValue < 0){
            currentNode.rightChild = insertElement(currentNode.rightChild, element);
        }else{
            currentNode.leftChild = insertElement(currentNode.leftChild, element);
        }
        return currentNode;
    }

    /**
     * @param element
     * @return true if the key is in the BST
     */
    public boolean containsElement(T element){
        return containsElement(this.root, element);
    }

    /**
     * Helper function to determine if the the key is in the BST
     * @param currentNode
     * @param element
     * @return Returns true if element is in the Binary Search Tree
     */
    private boolean containsElement(Node currentNode, T element){
        if(currentNode == null){
            return false;
        }

        int compareValue = currentNode.key.compareTo(element);
        //if currentNode's key value is equal to element return true
        if(compareValue == 0){
            return true;
        }//if currentNode's key value is less than element check currentNode's right subtree
        else if(compareValue < 0){
            return containsElement(currentNode.rightChild, element);
        }else{
            return containsElement(currentNode.leftChild, element);
        }
    }

    /**
     * Returns the node in the BST that contains the given key. If no
     * node exists in the BST with the key then null is returned.
     * @param element
     * @return
     */
    public Node treeSearch(T element){
        return treeSearch(this.root, element);
    }

    /**
     * Helper function for treeSearch(int key)
     * Given a node and a key checks if the current node
     * has the key.
     *
     * If the current node is equal to null or the node
     * contains the key then the current node is returned
     *
     * If the key is greater than the key of the current node; then treeSearch is
     * called again but with the current nodes rightChild child.
     *
     * @param node
     * @param element
     * @return
     */
    private Node treeSearch(Node node, T element){
        if(node == null){
            return null;
        }

        int compareValue = node.key.compareTo(element);
        if(compareValue == 0){
            return node;
        }else if(compareValue < 0){
            return treeSearch(node.rightChild, element);
        }else{
            return treeSearch(node.leftChild, element);
        }
    }

    /**
     * Returns a pointer to the node with the minimum key in the BST
     * NOTE: this node will always be the leftChild most node in the BST
     * @return
     */
    public Node minimum(){
        return minimum(this.root);
    }

    /**
     * @param node
     * @return
     */
    private Node minimum(Node node){
        while(node.leftChild != null){
            node = node.leftChild;
        }
        return node;
    }

    /**
     * Returns a pointer to the node with the maximum key in the BST
     * NOTE: this node will always be the rightChild most node in the BST
     * @return
     */
    public Node maximum(){
       return maximum(this.root);

    }

    /**
     * @param node
     * @return
     */
    private Node maximum(Node node){
        while(node.rightChild != null){
            node = node.rightChild;
        }
        return node;
    }


    //if current pointer key value is less childNode key value; set current pointer equal to it's right child
//    int compareValue = currentPtr.key.compareTo(node.key);
//            if (compareValue < 0) {


    /**
     * Returns a Deque of all the nodes in the simple path from an ancestor to a
     * descendant. NOTE: if the node passed in the first parameter is not a descendant
     * of the node passed in the second parameter then an empty Deque is returned.
     * @param ancestor
     * @param descendant
     * @return
     */
    public Deque<Node> generateSimpleAncestryPath(Node ancestor, Node descendant){
        Deque<Node> linkedList = new java.util.LinkedList<>();
        //if ancestor is equal to null that means that there is no path
        //from ancestor node to descendant node
        while((ancestor != null) && (ancestor != descendant)){
            linkedList.addFirst(ancestor);
            int compareValue = ancestor.key.compareTo(descendant.key);
            //if ancestor's key value is less than descendant key value; the descendant is in ancestor's right subtree
            if(compareValue < 0){
                ancestor = ancestor.rightChild;
            }else{
                ancestor = ancestor.leftChild;
            }
        }

        //returns an empty list
        if(ancestor == null){
            linkedList.clear();
            return linkedList;
        }

        //the descendant node is an ancestor of itself
        linkedList.addFirst(descendant);
        return linkedList;
    }

    /**
     * The successor in of a node with no rightChild subtree is
     * the lowest ancestor whose leftChild child is also an ancestor
     * of the desired node. NOTE if none of the nodes in the ancestors
     * list match this scenario then the node does not have a successor and
     * null is returned.
     * @param ancestors
     * @return
     */
    private Node successorOfNodeWithNoRightSubTree(Deque<Node> ancestors){
        if(ancestors.size() < 2){
            return null;
        }

        java.util.Iterator<Node> iterator =  ancestors.iterator();
        Node current = iterator.next();
        Node parent = iterator.next();

        while(parent.rightChild == current){
            current = parent;
            if(iterator.hasNext()){
                parent = iterator.next();
            }else{
                return null;
            }
        }
        return parent;
    }

    private Node predecessorOfNodeWithNoLeftSubTree(Deque<Node> ancestors){
        if(ancestors.size() < 2){
            return null;
        }

        java.util.Iterator<Node> iterator =  ancestors.iterator();
        Node current = iterator.next();
        Node parent = iterator.next();

        while(parent.leftChild == current){
            current = parent;
            if(iterator.hasNext()){
                parent = iterator.next();
            }else{
                return null;
            }
        }
        return parent;
    }

    /**
     * Returns the successor of a the input node.
     * There are 2 possible cases
     * 1) When the input element has a rightChild subtree
     *      a) The successor performing min on the rightChild subtree of the input node
     * 2) When the input element does not have a rightChild subtree
     *      a) Since this BST does not have a parent node, first find the simple
     *         ancestry path from the root to the node in reverse order. Then
     *         the successor is the lowest ancestor whose leftChild child is also
     *         an ancestor of the input node.
     * @param node
     * @return
     */
    public Node successor(Node node){
        if(node.rightChild != null){
            return minimum(node.rightChild);
        }

        Deque<Node> ancestorList = generateSimpleAncestryPath(this.root, node);
        return successorOfNodeWithNoRightSubTree(ancestorList);
    }

    public Node predecessor(Node node){
        if(node.leftChild != null){
            return maximum(node.leftChild);
        }
        Deque<Node> ancestorList = generateSimpleAncestryPath(this.root, node);
        return predecessorOfNodeWithNoLeftSubTree(ancestorList);
    }

}
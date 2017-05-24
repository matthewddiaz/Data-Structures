package com.matthewddiaz.datastructures.trees;

import com.matthewddiaz.datastructures.queue.Queue;
import com.matthewddiaz.designpatterns.behavioralPatterns.Iterator;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by matthewdiaz on 8/30/16.
 */

/**
 * A Binary Search Tree is a Tree where each node can have a most 2 children. Furthermore
 * the left subtree contains elements that are less than the root key. The right subtree contains
 * elements that are greater than or equal to the root key.
 */
public class BinarySearchTree {
    private Node root;

    class Node{
        int key;
        Node left;
        Node right;

        public Node(int key){
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Default constructor
     * Note: This constructor should be used when creating a new empty BST
     */
    public BinarySearchTree(){
        this.root = null;
    }

    /**
     * Constructor that takes in a pre-existing tree
     * sets its root equal to the Node passed in the parameter.
     * @param root
     */
    public BinarySearchTree(Node root){
        this.root = root;
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
    public void insertElement(int element){
        Node node = new Node(element);
        if(isEmpty()){
            root = node;
        }else{
            Node temp = root;
            Node parent = null;
            while(temp != null) {
                parent = temp;
                if (element > temp.key) {
                    temp = temp.right;
                } else {
                    temp = temp.left;
                }
            }

            if(element > parent.key){
                parent.right = node;
            }else{
                parent.left = node;
            }
        }
    }

    /**
     * If the key is in the BST it is removed.
     * NOTE: not working correctly!!!
     * Duplicate leaf node in BST after removal of desired node
     * @param element
     */
    public void removeElement(int element){
        this.root = removeElement(this.root, element);
    }

    /**
     * Helper function to remove the key from the BST
     * @param node
     * @param element
     * @return
     */
    private Node removeElement(Node node, int element){
        if(node == null){
            return null;
        }

        if(node.key == element){
            node = swap(node);
        }else if(element > node.key){
            node.right = removeElement(node.right, element);
        }else{
            node.left = removeElement(node.left, element);
        }
        return node;
    }

    /**
     * Helper method that swaps nodes in the BST.
     * @param node
     * @return
     */
    private Node swap(Node node){
        Node temp = node;
        if(temp.left != null){
            temp = temp.left;
            Node parent = temp;
            while(temp.right != null){
                parent = temp;
                temp = temp.right;
            }
            node.key = temp.key;
            parent.right = null;
            return node;
        }else if(temp.right != null){
            temp = temp.right;
            Node parent = temp;
            while(temp.left != null){
                parent = temp;
                temp = temp.left;
            }
            node.key = temp.key;
            parent.left = null;
            return node;
        }else{
            return null;
        }
    }

    /**
     * Returns true if the key is in the BST
     * @param element
     * @return
     */
    public boolean containsElement(int element){
        return containsElement(this.root, element);
    }

    /**
     * Helper function to determine if the the key is in the BST
     * @param node
     * @param element
     * @return
     */
    private boolean containsElement(Node node, int element){
        if(node == null){
            return false;
        }

        if(node.key == element){
            return true;
        }else if(element > node.key){
            return containsElement(node.right, element);
        }else{
            return containsElement(node.left, element);
        }
    }

    /**
     * Returns the node in the BST that contains the given key. If no
     * node exists in the BST with the key then null is returned.
     * @param element
     * @return
     */
    public Node treeSearch(int element){
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
     * called again but with the current nodes right child.
     *
     * @param node
     * @param element
     * @return
     */
    private Node treeSearch(Node node, int element){
        if(node == null || node.key == element){
            return node;
        }else if(element > node.key){
            return treeSearch(node.right, element);
        }else{
            return treeSearch(node.left, element);
        }
    }

    /**
     * Returns a pointer to the node with the minimum key in the BST
     * NOTE: this node will always be the left most node in the BST
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
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    /**
     * Returns a pointer to the node with the maximum key in the BST
     * NOTE: this node will always be the right most node in the BST
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
        while(node.right != null){
            node = node.right;
        }
        return node;
    }

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

            if(ancestor.key < descendant.key){
                ancestor = ancestor.right;
            }else{
                ancestor = ancestor.left;
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
     * The successor in of a node with no right subtree is
     * the lowest ancestor whose left child is also an ancestor
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

        while(parent.right == current){
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
     * 1) When the input element has a right subtree
     *      a) The successor performing min on the right subtree of the input node
     * 2) When the input element does not have a right subtree
     *      a) Since this BST does not have a parent node, first find the simple
     *         ancestry path from the root to the node in reverse order. Then
     *         the successor is the lowest ancestor whose left child is also
     *         an ancestor of the input node.
     * @param node
     * @return
     */
    public Node successor(Node node){
        if(node.right != null){
            return minimum(node.right);
        }

        Deque<Node> ancestorList = generateSimpleAncestryPath(this.root, node);
        return successorOfNodeWithNoRightSubTree(ancestorList);
    }

    public int heightOfTree(){
        return heightOfTree(this.root);
    }

    private int heightOfTree(Node node){
        if(node == null){
            return -1;
        }
        int left = heightOfTree(node.left);
        int right = heightOfTree(node.right);
        if(left > right){
            return left + 1;
        }else{
            return right + 1;
        }
    }

    /**
     * Iterative approach of Pre-Order Traversal.
     * A Depth First Search, that traverses the BST
     * starting from the root node and always prints
     * the current (self) node, then the left child, then the
     * right child.
     * @return String representation of the BST Pre-Order traversal
     * the format will be: [ e1, e2, e3 ]
     */
    public String preOrderTraversal(){
        if(isEmpty()){
            return "[]";
        }

        StringBuffer traversalBuffer = new StringBuffer("[ " + this.root.key);
        Deque<Node> stack = new ArrayDeque<>();
        visitChildrenPreOrder(stack, this.root);

        while(!stack.isEmpty()){
            Node currentNode = stack.pop();
            traversalBuffer.append(", " + currentNode.key);
            visitChildrenPreOrder(stack, currentNode);
        }

        traversalBuffer.append(" ]");
        return traversalBuffer.toString();
    }

    /**
     * Iterative approach of Pre-Order Traversal.
     * A Depth First Search that traverse the BST
     * starting from the root node this traversal
     * always prints left child, then right child,
     * then current (self) node.
     * @return
     */
    public String postOrderTraversal(){
        if(isEmpty()){
            return "[]";
        }

        Node pointer = this.root;
        Deque<Node> stack = new ArrayDeque<>();
        StringBuffer traversalBuffer = new StringBuffer("[ ");

        while(!stack.isEmpty() || pointer != null){
            while(pointer != null){
                if(pointer.right != null){
                    stack.push(pointer.right);
                }
                stack.push(pointer);
                pointer = pointer.left;
            }

            pointer = stack.pop();
            if(pointer.right != null && pointer.right == stack.peek()){
                Node rightChild = stack.pop();
                stack.push(pointer);
                pointer = rightChild;
            }else{
                traversalBuffer.append(pointer.key + " ,");
                pointer = null;
            }
        }
        traversalBuffer.deleteCharAt(traversalBuffer.length() - 1);
        traversalBuffer.append("]");
        return traversalBuffer.toString();
    }

    /**
     * Iterative approach of In-Order Traversal.
     * A Depth First Search, where left child are always
     * printed first, then self node, then right child.
     * For a BST this traversal will print the nodes
     * with keys in ascending order.
     * @return String representation of the BST In-Order traversal
     * the format will be: [ e1, e2, e3 ]
     */
    public String inOrderTraversal(){
        if(isEmpty()){
            return "[]";
        }

        Node pointer = this.root;
        Deque<Node> stack = new ArrayDeque<>();
        StringBuffer buffer = new StringBuffer("[");
        while(!stack.isEmpty() || (pointer != null)){
            while(pointer != null){
                stack.push(pointer);
                pointer = pointer.left;
            }

            pointer = stack.pop();
            buffer.append(" " + pointer.key + ",");
            pointer = pointer.right;
        }
        //last key does not need the "," thus deleting last char in buffer
        buffer.deleteCharAt(buffer.length() - 1);
        buffer.append(" ]");
        return buffer.toString();
    }

    /**
     * Iterative approach of Level Order Traversal
     * A Breadth First Search: For each level nodes are printed
     * from left to right; the first with 0 being the
     * first level.
     * @return String representation of the BST Level-Order traversal
     * the format will be: [ e1, e2, e3 ]
     */
    public String levelOrderTraversal(){
        if(isEmpty()){
            return "[]";
        }

        Queue<Node> queue = new Queue<>();
        StringBuffer buffer = new StringBuffer("[ "  + this.root.key);
        visitChildrenLevelOrder(queue, this.root);

        while(!queue.isEmpty()){
            Node node = queue.dequeue();
            buffer.append(", " + node.key);
            visitChildrenLevelOrder(queue, node);
        }

        buffer.append(" ]");
        return buffer.toString();
    }

    /**
     * Creates and returns a new Iterator object that traverses
     * the tree in In-Order.
     * @return
     */
    public Iterator createInOrderIterator(){
        return new Iterator() {
            private Deque<Node> stack = new ArrayDeque<>();
            private Node pointer;

            private void insertSelfAndLeftDescendants(){
                while(pointer != null){
                    this.stack.push(pointer);
                    pointer = pointer.left;
                }
            }

            @Override
            public void first() {
                pointer = root;
                insertSelfAndLeftDescendants();
            }

            @Override
            public Object currentElement() {
                Node currentNode = stack.peek();
                return currentNode.key;
            }

            @Override
            public void next() {
                pointer = stack.pop();

                if(pointer.right != null){
                    pointer = pointer.right;
                    insertSelfAndLeftDescendants();
                }
            }

            @Override
            public boolean isDone() {
                return stack.isEmpty();
            }
        };
    }

    /**
     * Creates and returns a new Iterator object that traverses
     * the tree in Level Order.
     * @return
     */
    public Iterator createLevelOrderIterator(){
        return new Iterator() {
            private Queue<Node> queue = new Queue<>();

            @Override
            public void first() {
                queue.enqueue(root);
            }

            @Override
            public Object currentElement() {
                Node currentNode = queue.peak();
                return currentNode.key;
            }

            @Override
            public void next() {
                Node currentNode = queue.dequeue();
                visitChildrenLevelOrder(queue, currentNode);
            }

            @Override
            public boolean isDone() {
                return  queue.isEmpty();
            }
        };
    }

    /**
     * Helper method for PreOrder Traversal. Inserts a nodes
     * children if present.
     * Note: right child is inserted first since its visited last.
     * @param stack
     * @param node
     */
    private void visitChildrenPreOrder(Deque<Node> stack, Node node){
        //insert right child if present
        if(node.right != null){
            stack.push(node.right);
        }

        //insert left child if present
        if(node.left != null){
            stack.push(node.left);
        }
    }

    /**
     * Helper method that inserts a node's child nodes to the Queue.
     * Note: If both children are present then the left child is
     * enqueued first.
     * @param queue
     * @param node
     */
    private void visitChildrenLevelOrder(Queue<Node> queue, Node node){
        if(node.left != null){
            queue.enqueue(node.left);
        }

        if(node.right != null){
            queue.enqueue(node.right);
        }
    }
}

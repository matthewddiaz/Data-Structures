package com.matthewddiaz.datastructures.trees;

import com.matthewddiaz.datastructures.queue.Queue;
import com.matthewddiaz.designpatterns.behavioralPatterns.Iterator;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by matthewdiaz on 8/30/16.
 */
public class BinarySearchTree {
    private Node root;

    private class Node{
        int element;
        Node left;
        Node right;

        public Node(int element){
            this.element = element;
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
     * Inserts the element into the BST
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
                if (element > temp.element) {
                    temp = temp.right;
                } else {
                    temp = temp.left;
                }
            }

            if(element > parent.element){
                parent.right = node;
            }else{
                parent.left = node;
            }
        }
    }

    /**
     * If the element is in the BST it is removed.
     * @param element
     */
    public void removeElement(int element){
        this.root = removeElement(this.root, element);
    }

    /**
     * Helper function to remove the element from the BST
     * @param node
     * @param element
     * @return
     */
    private Node removeElement(Node node, int element){
        if(node == null){
            return null;
        }

        if(node.element == element){
            node = swap(node);
        }else if(element > node.element){
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
            node.element = temp.element;
            parent.right = null;
            return node;
        }else if(temp.right != null){
            temp = temp.right;
            Node parent = temp;
            while(temp.left != null){
                parent = temp;
                temp = temp.left;
            }
            node.element = temp.element;
            parent.left = null;
            return node;
        }else{
            return null;
        }
    }

    /**
     * Returns true if the element is in the BST
     * @param element
     * @return
     */
    public boolean containsElement(int element){
        return containsElement(this.root, element);
    }

    /**
     * Helper function to determine if the the element is in the BST
     * @param node
     * @param element
     * @return
     */
    private boolean containsElement(Node node, int element){
        if(node == null){
            return false;
        }

        if(node.element == element){
            return true;
        }else if(element > node.element){
            return containsElement(node.right, element);
        }else{
            return containsElement(node.left, element);
        }
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

        StringBuffer traversalBuffer = new StringBuffer("[ " + this.root.element);
        Deque<Node> stack = new ArrayDeque<>();
        visitChildrenPreOrder(stack, this.root);

        while(!stack.isEmpty()){
            Node currentNode = stack.pop();
            traversalBuffer.append(", " + currentNode.element);
            visitChildrenPreOrder(stack, currentNode);
        }

        traversalBuffer.append(" ]");
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
            buffer.append(" " + pointer.element + ",");
            pointer = pointer.right;
        }
        //last element does not need the "," thus deleting last char in buffer
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
        StringBuffer buffer = new StringBuffer("[ "  + this.root.element);
        visitChildrenLevelOrder(queue, this.root);

        while(!queue.isEmpty()){
            Node node = queue.dequeue();
            buffer.append(", " + node.element);
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
                return currentNode.element;
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
                return currentNode.element;
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

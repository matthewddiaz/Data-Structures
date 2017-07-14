package com.matthewddiaz.datastructures.trees;

import com.matthewddiaz.datastructures.queue.Queue;
import com.matthewddiaz.designpatterns.behavioralPatterns.Iterator;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by matthewdiaz on 4/21/17.
 */
public class BinaryTree<T extends Comparable<T>> {
    protected Node root;

    public static class Node<T extends Comparable<T>>{
        protected T key;
        protected Node leftChild;
        protected Node rightChild;

        public Node(T key){
            this.key = key;
            this.leftChild = null;
            this.rightChild = null;
        }

        public int numOfChildren(){
            int children = 0;
            if(this.leftChild != null){
                children++;
            }

            if(this.rightChild != null){
                children++;
            }
            return children;
        }

        public T getKey(){
            return this.key;
        }

        public Node getLeftChild(){
            return  this.leftChild;
        }

        public Node getRightChild(){
            return  this.rightChild;
        }

        public void setLeftChild(Node leftChild){
            this.leftChild = leftChild;
        }

        public void setRightChild(Node rightChild){
            this.rightChild = rightChild;
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
    public BinaryTree(Node root){
        this.root = root;
    }

    /**
     * Inserts the key using In-Order traversal insertion to the binary tree
     * @param element
     */
    public void insertElement(T element){
        Node node = new Node(element);

        if(isEmpty()){
            this.root = node;
            return;
        }

        Queue<Node> queue = new Queue();
        queue.enqueue(this.root);

        while(!queue.isEmpty()){
            Node topNode = queue.peak();
            Node leftChild = topNode.leftChild;
            Node rightChild = topNode.rightChild;

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
     * Returns true if binary tree is empty.
     * @return
     */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * Returns the height of the Binary Tree.
     * NOTE: Height starts at 0. At is an binary tree that only contains one node the root will have level 0.
     * NOTE: If the binary tree is empty -1 is returned.
     * @return
     */
    public int heightOfTree(){
        return heightOfTree(this.root);
    }

    private int heightOfTree(Node node){
        if(node == null){
            return -1;
        }
        int left = heightOfTree(node.leftChild);
        int right = heightOfTree(node.rightChild);
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
     * the current (self) node, then the leftChild child, then the
     * rightChild child.
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
     * Helper method for PreOrder Traversal. Inserts a nodes
     * children if present.
     * Note: rightChild child is inserted first since its visited last.
     * @param stack
     * @param node
     */
    private void visitChildrenPreOrder(Deque<Node> stack, Node node){
        //insert rightChild child if present
        if(node.rightChild != null){
            stack.push(node.rightChild);
        }

        //insert leftChild child if present
        if(node.leftChild != null){
            stack.push(node.leftChild);
        }
    }

    /**
     * Iterative approach of Pre-Order Traversal.
     * A Depth First Search that traverse the BST
     * starting from the root node this traversal
     * always prints leftChild child, then rightChild child,
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
                if(pointer.rightChild != null){
                    stack.push(pointer.rightChild);
                }
                stack.push(pointer);
                pointer = pointer.leftChild;
            }

            pointer = stack.pop();
            if(pointer.rightChild != null && pointer.rightChild == stack.peek()){
                Node rightChild = stack.pop();
                stack.push(pointer);
                pointer = rightChild;
            }else{
                traversalBuffer.append(pointer.key + ", ");
                pointer = null;
            }
        }
        traversalBuffer.deleteCharAt(traversalBuffer.length() - 2);
        traversalBuffer.append("]");
        return traversalBuffer.toString();
    }

    /**
     * Iterative approach of In-Order Traversal.
     * A Depth First Search, where leftChild child are always
     * printed first, then self node, then rightChild child.
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
                pointer = pointer.leftChild;
            }

            pointer = stack.pop();
            buffer.append(" " + pointer.key + ",");
            pointer = pointer.rightChild;
        }
        //last key does not need the "," thus deleting last char in buffer
        buffer.deleteCharAt(buffer.length() - 1);
        buffer.append(" ]");
        return buffer.toString();
    }

    /**
     * Iterative approach of Level Order Traversal
     * A Breadth First Search: For each level nodes are printed
     * from leftChild to rightChild; the first with 0 being the
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
     * Helper method that inserts a node's child nodes to the Queue.
     * Note: If both children are present then the leftChild child is
     * enqueued first.
     * @param queue
     * @param node
     */
    private void visitChildrenLevelOrder(Queue<Node> queue, Node node){
        if(node.leftChild != null){
            queue.enqueue(node.leftChild);
        }

        if(node.rightChild != null){
            queue.enqueue(node.rightChild);
        }
    }

    /**
     * Creates and returns a new Iterator object that traverses
     * the tree in In-Order.
     * NOTE: In a Binary Search Tree returns the values in sorted non-descending order
     * @return
     */
    public Iterator createInOrderIterator(){
        return new Iterator() {
            private Deque<Node> stack = new ArrayDeque<>();
            private Node pointer;

            private void insertSelfAndLeftDescendants(){
                while(pointer != null){
                    this.stack.push(pointer);
                    pointer = pointer.leftChild;
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

                if(pointer.rightChild != null){
                    pointer = pointer.rightChild;
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
     * Returns root of binary tree
     * @return
     */
    public Node getRoot(){
        return this.root;
    }
}

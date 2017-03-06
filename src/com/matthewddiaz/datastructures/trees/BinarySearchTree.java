package com.matthewddiaz.datastructures.trees;

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

    public boolean isEmpty(){
        return this.root == null;
    }

    public void insertElement(int element){
        if(isEmpty()){
            root = new Node(element);
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
                parent.right = new Node(element);
            }else{
                parent.left = new Node(element);
            }
        }
    }

    public void removeElement(int element){
        this.root = removeElement(this.root, element);
    }

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

    public boolean containsElement(int element){
        return containsElement(this.root, element);
    }

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

    public int sumOfLeftLeaves(){
        return sumOfLeftLeaves(this.root);
    }

    private int sumOfLeftLeaves(Node node){
        if(node == null){
            return 0;
        }

        int sum = 0;
        if(isLeaf(node.left)){
            sum = node.left.element;
        }

        sum += sumOfLeftLeaves(node.left);
        sum += sumOfLeftLeaves(node.right);
        return sum;
    }

    private boolean isLeaf(Node node){
        if(node == null){
            return false;
        }
        if(node.left == null && node.right == null){
            return true;
        }
        return false;
    }


//    public void insertElement(int element){
//        this.root = insertElement(this.root, element);
//    }
//
//    private Node insertElement(Node x, int element) {
//        if(x == null){
//            return new Node(element);
//        }
//
//        if (element > x.element) {
//            x.right = insertElement(x.right, element);
//        } else {
//            x.left = insertElement(x.left, element);
//        }
//        return x;
//    }

    //left self right
    public void printInOrderTraversal(){
        printInOrder(this.root);
    }

    private void printInOrder(Node root){
        if(root == null){
            return;
        }

        printInOrder(root.left);
        System.out.println(root.element);
        printInOrder(root.right);
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




//    private Iterator createInOrderIterator(){
//        return new Iterator() {
//            @Override
//            public void first() {
//
//            }
//
//            @Override
//            public Object currentElement() {
//                return null;
//            }
//
//            @Override
//            public void next() {
//
//            }
//
//            @Override
//            public boolean isDone() {
//                return false;
//            }
//        };
//    }
}

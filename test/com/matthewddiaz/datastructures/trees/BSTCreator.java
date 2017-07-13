package com.matthewddiaz.datastructures.trees;

/**
 * Created by matthewdiaz on 5/24/17.
 */
public class BSTCreator {

    /**
     * Returns a new Binary Search Tree which only contains few elements.
     * This BST should be used for simple test cases.
     * @return
     */
    public static BinarySearchTree<Integer> createSimpleBinarySearchTree(){
        BinarySearchTree<Integer> simpleBST = new BinarySearchTree();
        simpleBST.insertElement(10);
        simpleBST.insertElement(5);
        simpleBST.insertElement(12);
        simpleBST.insertElement(15);
        simpleBST.insertElement(1);
        simpleBST.insertElement(11);
        return simpleBST;
    }

    /**
     * Returns a new Binary Search Tree which contains several elements.
     * This BST should be used for complex test cases.
     * @return
     */
    public static BinarySearchTree<Integer> createComplexBinarySearchTree(){
        BinarySearchTree<Integer> complexBST = new BinarySearchTree();
        complexBST.insertElement(9);
        complexBST.insertElement(5);
        complexBST.insertElement(15);
        complexBST.insertElement(20);
        complexBST.insertElement(1);
        complexBST.insertElement(11);
        complexBST.insertElement(10);
        complexBST.insertElement(16);
        complexBST.insertElement(8);
        complexBST.insertElement(50);
        complexBST.insertElement(60);
        complexBST.insertElement(100);
        complexBST.insertElement(90);
        complexBST.insertElement(80);
        complexBST.insertElement(18);
        complexBST.insertElement(55);
        return complexBST;
    }
}

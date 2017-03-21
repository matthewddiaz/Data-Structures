package com.matthewddiaz.datastructures.trees;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by matthewdiaz on 3/21/17.
 */
class BinarySearchTreeTest {
    private BinarySearchTree binarySearchTree;

    @BeforeEach
    public void setUp() throws Exception {
        this.binarySearchTree = new BinarySearchTree();
    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testInsertElement() throws Exception {
        this.binarySearchTree.insertElement(10);
        this.binarySearchTree.insertElement(5);
        this.binarySearchTree.insertElement(12);
        this.binarySearchTree.printInOrderTraversal();
    }

    @Test
    public void testContainsElement() throws Exception {
        this.binarySearchTree.insertElement(10);
        this.binarySearchTree.insertElement(5);
        this.binarySearchTree.insertElement(12);
        this.binarySearchTree.insertElement(15);
        this.binarySearchTree.insertElement(1);
        this.binarySearchTree.containsElement(5);
        assertTrue(this.binarySearchTree.containsElement(5));
        assertTrue(this.binarySearchTree.containsElement(1));
        assertFalse(this.binarySearchTree.containsElement(2));
        assertTrue(this.binarySearchTree.containsElement(15));
    }

    @Test
    public void testRemoveElement() throws Exception {
        this.binarySearchTree.insertElement(10);
        this.binarySearchTree.insertElement(5);
        this.binarySearchTree.insertElement(12);
        this.binarySearchTree.insertElement(15);
        this.binarySearchTree.insertElement(1);
        this.binarySearchTree.insertElement(11);

        this.binarySearchTree.removeElement(10);
        assertFalse(this.binarySearchTree.containsElement(10));
    }

    @Test
    public void testHeightOfTree() throws Exception {
        this.binarySearchTree.insertElement(9);
        this.binarySearchTree.insertElement(5);
        this.binarySearchTree.insertElement(12);
        this.binarySearchTree.insertElement(15);
        this.binarySearchTree.insertElement(1);
        this.binarySearchTree.insertElement(11);
        this.binarySearchTree.insertElement(10);

        System.out.println(binarySearchTree.heightOfTree());
    }

    @Test
    public void testSumOfLeftLeaves() throws Exception {
        this.binarySearchTree.insertElement(9);
        this.binarySearchTree.insertElement(5);
        this.binarySearchTree.insertElement(12);
        this.binarySearchTree.insertElement(15);
        this.binarySearchTree.insertElement(1);
        this.binarySearchTree.insertElement(11);
        this.binarySearchTree.insertElement(10);
        this.binarySearchTree.insertElement(14);
        System.out.println("Sum of left leaves is: " + this.binarySearchTree.sumOfLeftLeaves());
    }

}
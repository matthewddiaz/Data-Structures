package com.matthewddiaz.datastructures.trees;


import com.matthewddiaz.designpatterns.behavioralPatterns.Iterator;
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

    private void generateSimpleBinarySearchTree(){
        this.binarySearchTree.insertElement(10);
        this.binarySearchTree.insertElement(5);
        this.binarySearchTree.insertElement(12);
        this.binarySearchTree.insertElement(15);
        this.binarySearchTree.insertElement(1);
        this.binarySearchTree.insertElement(11);
    }

    private void generateComplexBinarySearchTree(){
        this.binarySearchTree.insertElement(9);
        this.binarySearchTree.insertElement(5);
        this.binarySearchTree.insertElement(15);
        this.binarySearchTree.insertElement(20);
        this.binarySearchTree.insertElement(1);
        this.binarySearchTree.insertElement(11);
        this.binarySearchTree.insertElement(10);
        this.binarySearchTree.insertElement(16);
        this.binarySearchTree.insertElement(8);
        this.binarySearchTree.insertElement(50);
        this.binarySearchTree.insertElement(60);
        this.binarySearchTree.insertElement(100);
        this.binarySearchTree.insertElement(90);
        this.binarySearchTree.insertElement(80);
        this.binarySearchTree.insertElement(18);
        this.binarySearchTree.insertElement(55);
    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testInsertElement() throws Exception {
        generateSimpleBinarySearchTree();

        this.binarySearchTree.inOrderTraversal();
    }

    @Test
    public void testContainsElement() throws Exception {
        generateComplexBinarySearchTree();

        assertTrue(this.binarySearchTree.containsElement(5));
        assertTrue(this.binarySearchTree.containsElement(1));
        assertFalse(this.binarySearchTree.containsElement(2));
        assertTrue(this.binarySearchTree.containsElement(15));
    }

    @Test
    public void testRemoveElement() throws Exception {
        generateSimpleBinarySearchTree();

        //this.binarySearchTree.removeElement(10);
        //assertFalse(this.binarySearchTree.containsElement(10));
        System.out.println(this.binarySearchTree.postOrderTraversal());
    }

    @Test
    public void testHeightOfTree() throws Exception {
        int expectedHeight = 7;
        generateComplexBinarySearchTree();
        int actualHeight = binarySearchTree.heightOfTree();
        assertEquals(expectedHeight, actualHeight);
    }

    @Test
    void preOrderTraversal() {
        generateSimpleBinarySearchTree();

        System.out.println(this.binarySearchTree.preOrderTraversal());
    }

    @Test
    void preOrderTraversalOfComplexBST() {
        generateComplexBinarySearchTree();

        System.out.println(this.binarySearchTree.preOrderTraversal());
    }

    @Test
    void inOrderTraversal() {

    }

    @Test
    void levelOrderTraversal() {

    }


    @Test
    public void binarySearchLevelOrderIteratorTest() throws Exception {
        generateComplexBinarySearchTree();
        Iterator iterator = this.binarySearchTree.createLevelOrderIterator();

        iterator.first();
        for(; !iterator.isDone(); iterator.next()){
            System.out.println(iterator.currentElement());
        }
    }

    @Test
    public void binarySearchInOrderIteratorTest() throws Exception {
        generateComplexBinarySearchTree();
        Iterator iterator = this.binarySearchTree.createInOrderIterator();

        iterator.first();
        for(; !iterator.isDone(); iterator.next()){
            System.out.println(iterator.currentElement());
        }
    }
}
package com.matthewddiaz.datastructures.trees;


import com.matthewddiaz.designpatterns.behavioralPatterns.Iterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Deque;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by matthewdiaz on 3/21/17.
 */
class BinarySearchTreeTest {
    private BinarySearchTree simpleBST;
    private BinarySearchTree complexBST;

    @BeforeEach
    public void setUp() throws Exception {
        this.simpleBST = BSTCreator.createSimpleBinarySearchTree();
        this.complexBST = BSTCreator.createComplexBinarySearchTree();
    }

    /**
     * Checks if the method containsElement correct determines if the input
     * key is in the BST or not.
     * @throws Exception
     */
    @Test
    public void testContainsElement() throws Exception {
        assertTrue(this.complexBST.containsElement(5));
        assertTrue(this.complexBST.containsElement(1));
        assertFalse(this.complexBST.containsElement(2));
        assertTrue(this.complexBST.containsElement(15));
    }


    @Test
    void treeSearch() {
        int expectedKey = 5;
        BinarySearchTree.Node expectedNullResult = null;

        BinarySearchTree.Node presentNode = this.complexBST.treeSearch(5);
        BinarySearchTree.Node notPresetNode = this.complexBST.treeSearch(101);
        assertEquals(expectedKey, presentNode.key);
        assertEquals(expectedNullResult, notPresetNode);
    }

    /**
     * Finds min element in BST
     */
    @Test
    void minimum() {
        int expectedMin = 1;
        int actualMin = this.complexBST.minimum().key;
        assertEquals(expectedMin, actualMin);
    }

    /**
     * Finds max element in BST
     */
    @Test
    void maximum() {
        int expectedMax = 100;
        int actualMax = this.complexBST.maximum().key;
        assertEquals(expectedMax, actualMax);
    }

    @Test
    void generateAncestrySimplePath(){
        BinarySearchTree.Node sourceNode = this.complexBST.treeSearch(15);
        BinarySearchTree.Node destinationNode = this.complexBST.treeSearch(90);

        Deque<BinarySearchTree.Node> simplePath = this.complexBST.generateSimpleAncestryPath(sourceNode, destinationNode);
        for(BinarySearchTree.Node node : simplePath){
            System.out.print(node.key + " ");
        }
    }

    @Test
    void generateSimpleAncestryPathNoPathTestCase(){
        String expectedResult = "No Path";

        BinarySearchTree.Node sourceNode = this.complexBST.treeSearch(5);
        BinarySearchTree.Node destinationNode = this.complexBST.treeSearch(60);

        Deque<BinarySearchTree.Node> simplePath = this.complexBST.generateSimpleAncestryPath(sourceNode, destinationNode);
        String actualResult = "Path exists";

        if(simplePath.size() == 0){
            actualResult = "No Path";
        }
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void successor(){
        BinarySearchTree.Node node = this.complexBST.treeSearch(100);

        BinarySearchTree.Node successorNode = this.complexBST.successor(node);
        if(successorNode == null){
            System.out.println("Current Node is the largest element in the BST");
        }
        System.out.println(successorNode.key);
    }

//    @Test
//    public void testIsEmpty() throws Exception {
//
//    }

//    @Test
//    public void testInsertElement() throws Exception {
//
//        this.binarySearchTree.inOrderTraversal();
//    }

//    @Test
//    public void testRemoveElement() throws Exception {
//        generateSimpleBinarySearchTree();
//
//        //this.binarySearchTree.removeElement(10);
//        //assertFalse(this.binarySearchTree.containsElement(10));
//        System.out.println(this.binarySearchTree.postOrderTraversal());
//    }

    @Test
    public void testHeightOfTree() throws Exception {
        int expectedHeight = 7;

        int actualHeight = complexBST.heightOfTree();
        assertEquals(expectedHeight, actualHeight);
    }

    @Test
    void createInOrderIterator() {

    }

    @Test
    void createLevelOrderIterator() {

    }

    @Test
    void preOrderTraversal() {
        System.out.println(this.simpleBST.preOrderTraversal());
    }

    @Test
    void preOrderTraversalOfComplexBST() {
        System.out.println(this.complexBST.preOrderTraversal());
    }

    @Test
    void inOrderTraversal() {

    }

    @Test
    void levelOrderTraversal() {

    }


    @Test
    public void binarySearchLevelOrderIteratorTest() throws Exception {
        Iterator iterator = this.complexBST.createLevelOrderIterator();

        iterator.first();
        for(; !iterator.isDone(); iterator.next()){
            System.out.println(iterator.currentElement());
        }
    }

    @Test
    public void binarySearchInOrderIteratorTest() throws Exception {
        Iterator iterator = this.complexBST.createInOrderIterator();

        iterator.first();
        for(; !iterator.isDone(); iterator.next()){
            System.out.println(iterator.currentElement());
        }
    }
}
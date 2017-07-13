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
    private BinarySearchTree<Integer> complexBST;

    @BeforeEach
    public void setUp() throws Exception {
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
        int actualMin = (int) this.complexBST.minimum().key;
        assertEquals(expectedMin, actualMin);
    }

    /**
     * Finds max element in BST
     */
    @Test
    void maximum() {
        int expectedMax = 100;
        int actualMax = (int) this.complexBST.maximum().key;
        assertEquals(expectedMax, actualMax);
    }

    /**
     * Testing correctness of ancestry simple path list
     */
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

    /**
     * Testing Successor functionality and its two main cases.
     * 1) When the input node has a rightChild subtree
     * 2) When the input node does not have a rightChild subtree
     */

    @Test
    void successorForNodeWithRightSubtree(){
        int expectedSuccessorKey = 8;
        BinarySearchTree.Node node = this.complexBST.treeSearch(5);

        BinarySearchTree.Node successorNode = this.complexBST.successor(node);
        assertEquals(expectedSuccessorKey, successorNode.key);
    }

    @Test
    void successorForNodeWithNoRightSubtree(){
        int expectedSuccessorKey = 20;
        BinarySearchTree.Node node = this.complexBST.treeSearch(18);

        BinarySearchTree.Node successorNode = this.complexBST.successor(node);
        assertEquals(expectedSuccessorKey, successorNode.key);
    }

    @Test
    void successorForNodeWithLargestKeyValue(){
        BinarySearchTree.Node expectedSuccessor = null;
        BinarySearchTree.Node node = this.complexBST.maximum();

        BinarySearchTree.Node successorNode = this.complexBST.successor(node);
        assertEquals(expectedSuccessor, successorNode);
    }

    /**
     * Testing Predecessor functionality and its two main cases.
     * 1) When the input node has a leftChild subtree
     * 2) When the input node does not have a leftChild subtree
     */

    @Test
    void predecessorForNodeWithLeftSubtree(){
        int expectedPredecessorKey = 8;
        BinarySearchTree.Node node = this.complexBST.treeSearch(9);

        BinarySearchTree.Node predecessorNode = this.complexBST.predecessor(node);
        assertEquals(expectedPredecessorKey, predecessorNode.key);
    }

    @Test
    void predecessorForNodeWithNoLeftSubtree(){
        int expectedPredecessorKey = 9;
        BinarySearchTree.Node node = this.complexBST.treeSearch(10);

        BinarySearchTree.Node predecessorNode = this.complexBST.predecessor(node);
        assertEquals(expectedPredecessorKey, predecessorNode.key);
    }

    @Test
    void predecessorForNodeWithSmallestKeyValue(){
        BinarySearchTree.Node expectedPredecessor = null;
        BinarySearchTree.Node node = this.complexBST.treeSearch(1);

        BinarySearchTree.Node predecessorNode = this.complexBST.predecessor(node);
        assertEquals(expectedPredecessor, predecessorNode);
    }

    @Test
    void deleteNodeWithNoChildren(){
        int removalKey = 8;
        //before removal of leaf node
        boolean isKeyPresentBefore = this.complexBST.containsElement(removalKey);
        assertTrue(isKeyPresentBefore);

        //after removal of leaf node
        this.complexBST.deleteNode(removalKey);
        boolean isKeyPresentAfter = this.complexBST.containsElement(removalKey);
        assertFalse(isKeyPresentAfter);
    }

    @Test
    void deleteNodeWithOneChild(){
        int removalKey = 100;
        //before removal of node
        boolean isKeyPresentBefore = this.complexBST.containsElement(removalKey);
        assertTrue(isKeyPresentBefore);

        //after removal of node
        this.complexBST.deleteNode(removalKey);
        boolean isKeyPresentAfter = this.complexBST.containsElement(removalKey);
        assertFalse(isKeyPresentAfter);
        System.out.println(this.complexBST.inOrderTraversal());
    }

    @Test
    void deleteNodeWithTwoChildren(){
        int removalKey = (int) this.complexBST.getRoot().getKey();

        //before removal of node
        boolean isKeyPresentBefore = this.complexBST.containsElement(removalKey);
        assertTrue(isKeyPresentBefore);

        //after removal of node
        this.complexBST.deleteNode(removalKey);
        boolean isKeyPresentAfter = this.complexBST.containsElement(removalKey);
        assertFalse(isKeyPresentAfter);
        System.out.println(this.complexBST.inOrderTraversal());
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

}
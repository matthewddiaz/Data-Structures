package com.matthewddiaz.datastructures.trees;

import com.matthewddiaz.designpatterns.behavioralPatterns.Iterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by matthewdiaz on 4/21/17.
 */
class BinaryTreeTest {
    private BinaryTree<Integer> binaryTree;

    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree<>();
    }

//    @Test
//    public void testHeightOfTree() throws Exception {
//        int expectedHeight = 7;
//
//        int actualHeight = complexBST.heightOfTree();
//        assertEquals(expectedHeight, actualHeight);
//    }
//
//    @Test
//    void createInOrderIterator() {}
//
//    @Test
//    void createLevelOrderIterator() {}
//
//    @Test
//    void preOrderTraversal() {
//        System.out.println(this.simpleBST.preOrderTraversal());
//    }
//
//    @Test
//    void preOrderTraversalOfComplexBST() {
//        System.out.println(this.complexBST.preOrderTraversal());
//    }
//
//    @Test
//    void inOrderTraversal() {}
//
//    @Test
//    void levelOrderTraversal() {}
//
//    @Test
//    public void binarySearchLevelOrderIteratorTest() throws Exception {
//        Iterator iterator = this.complexBST.createLevelOrderIterator();
//
//        iterator.first();
//        for(; !iterator.isDone(); iterator.next()){
//            System.out.println(iterator.currentElement());
//        }
//    }
//
//    @Test
//    public void binarySearchInOrderIteratorTest() throws Exception {
//        Iterator iterator = this.complexBST.createInOrderIterator();
//
//        iterator.first();
//        for(; !iterator.isDone(); iterator.next()){
//            System.out.println(iterator.currentElement());
//        }
//    }
}
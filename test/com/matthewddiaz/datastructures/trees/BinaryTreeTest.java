package com.matthewddiaz.datastructures.trees;

import com.matthewddiaz.designpatterns.behavioralPatterns.Iterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by matthewdiaz on 4/21/17.
 */
class BinaryTreeTest {
    private BinaryTree<Integer> complexBT;

    @BeforeEach
    void setUp() {
        complexBT = BSTCreator.createComplexBinarySearchTree();
    }

    @Test
    public void testHeightOfTree() throws Exception {
        int expectedHeight = 7;

        int actualHeight = complexBT.heightOfTree();
        assertEquals(expectedHeight, actualHeight);
    }

    @Test
    void preOrderTraversal() {
        String expectedPreOrderResult = "[ 9, 5, 1, 8, 15, 11, 10, 20, 16, 18, 50, 60, 55, 100, 90, 80 ]";
        String preOrderTraversalStr = complexBT.preOrderTraversal();
        assertEquals(expectedPreOrderResult, preOrderTraversalStr);
    }

    /**
     * Not complete
     */
    @Test
    void createPreOrderIterator() {
        String expectedInOrderResult = "[ 1, 5, 8, 9, 10, 11, 15, 16, 18, 20, 50, 55, 60, 80, 90, 100 ]";
        Iterator iterator = this.complexBT.createInOrderIterator();

        iterator.first();
        for(; !iterator.isDone(); iterator.next()){
            System.out.println(iterator.currentElement());
        }
    }

    @Test
    void postOrderTraversal(){
        String expectedPostOrderResult = "[ 1, 8, 5, 10, 11, 18, 16, 55, 80, 90, 100, 60, 50, 20, 15, 9 ]";
        String postOrderTraversalStr = complexBT.postOrderTraversal();
        assertEquals(expectedPostOrderResult, postOrderTraversalStr);
    }

    /**
     * Not complete
     */
    @Test
    void createPostOrderIterator(){
    }

    @Test
    void inOrderTraversal() {
        String expectedInOrderResult = "[ 1, 5, 8, 9, 10, 11, 15, 16, 18, 20, 50, 55, 60, 80, 90, 100 ]";
        String inOrderTraversalStr = complexBT.inOrderTraversal();
        assertEquals(expectedInOrderResult, inOrderTraversalStr);
    }

    /**
     * Not complete
     */
    @Test
    void createInOrderIterator() {
        String expectedInOrderResult = "[ 1, 5, 8, 9, 10, 11, 15, 16, 18, 20, 50, 55, 60, 80, 90, 100 ]";
        Iterator iterator = this.complexBT.createInOrderIterator();

        iterator.first();
        for(; !iterator.isDone(); iterator.next()){
            System.out.println(iterator.currentElement());
        }
    }

    @Test
    void levelOrderTraversal() {
        String expectedLevelOrderResult = "[ 9, 5, 15, 1, 8, 11, 20, 10, 16, 50, 18, 60, 55, 100, 90, 80 ]";
        String levelOrderTraversalStr = complexBT.levelOrderTraversal();
        assertEquals(expectedLevelOrderResult, levelOrderTraversalStr);
    }

    /**
     * Not complete
     */
    @Test
    void createLevelOrderIterator() {
        Iterator iterator = this.complexBT.createLevelOrderIterator();

        iterator.first();
        for(; !iterator.isDone(); iterator.next()){
            System.out.println(iterator.currentElement());
        }
    }

}
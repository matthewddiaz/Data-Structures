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
    private String expectedPreOrderResult = "[ 9, 5, 1, 8, 15, 11, 10, 20, 16, 18, 50, 60, 55, 100, 90, 80 ]";
    private String expectedPostOrderResult = "[ 1, 8, 5, 10, 11, 18, 16, 55, 80, 90, 100, 60, 50, 20, 15, 9 ]";
    private String expectedInOrderResult = "[ 1, 5, 8, 9, 10, 11, 15, 16, 18, 20, 50, 55, 60, 80, 90, 100 ]";
    private String expectedLevelOrderResult = "[ 9, 5, 15, 1, 8, 11, 20, 10, 16, 50, 18, 60, 55, 100, 90, 80 ]";

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
        String preOrderTraversalStr = complexBT.preOrderTraversal();
        assertEquals(expectedPreOrderResult, preOrderTraversalStr);
    }

    @Test
    void postOrderTraversal(){
        String postOrderTraversalStr = complexBT.postOrderTraversal();
        assertEquals(expectedPostOrderResult, postOrderTraversalStr);
    }

    @Test
    void inOrderTraversal() {
        String inOrderTraversalStr = complexBT.inOrderTraversal();
        assertEquals(expectedInOrderResult, inOrderTraversalStr);
    }

    @Test
    void createInOrderIterator() {
        Iterator iterator = this.complexBT.createInOrderIterator();
        String actualIteratorInOrderResult = generateFormattedStrOfIteratorData(iterator);
        assertEquals(expectedInOrderResult, actualIteratorInOrderResult);
    }

    @Test
    void levelOrderTraversal() {
        String levelOrderTraversalStr = complexBT.levelOrderTraversal();
        assertEquals(expectedLevelOrderResult, levelOrderTraversalStr);
    }

    @Test
    void createLevelOrderIterator() {
        Iterator iterator = this.complexBT.createLevelOrderIterator();
        String actualIteratorLevelOrderResult = generateFormattedStrOfIteratorData(iterator);
        assertEquals(expectedLevelOrderResult, actualIteratorLevelOrderResult);
    }

    private String generateFormattedStrOfIteratorData(Iterator iterator){
        if(iterator == null || !iterator.isDone()){
            return "[]";
        }

        StringBuffer buffer = new StringBuffer("[ ");

        //point iterator to first element
        iterator.first();
        //insert first element of iterator to buffer
        buffer.append(iterator.currentElement());
        //advance pointer of iterator to its next element
        iterator.next();

        for(; !iterator.isDone(); iterator.next()){
            buffer.append(", " + iterator.currentElement());
        }
        buffer.append(" ]");
        return buffer.toString();
    }

}
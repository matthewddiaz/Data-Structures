package com.matthewddiaz.datastructures.trees;

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

    @Test
    void insertElement() {
        binaryTree.insertElement(5);
        binaryTree.insertElement(10);
        binaryTree.insertElement(11);
        binaryTree.insertElement(20);
        binaryTree.printInOrderTraversal();
    }

    @Test
    void deleteElement() {

    }

    @Test
    void containsElement() {

    }

    @Test
    void isEmpty() {

    }

    @Test
    void printInOrderTraversal() {

    }

}
# Fundamental Data Structures

## Binary Trees
Is a structured finite set of nodes that either
1) contains no nodes or 
2) Composed of 3 disjoint set of nodes:
    1) a root node
    2) a binary tree called the left subtree
    3) a binary tree called the right subtree

NOTE: Each node in a Binary Tree may have a most 2 children
 
### [Binary Tree](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/trees/BinaryTree.java) 

**Test class:** [BinarySearchTreeTest](https://github.com/matthewddiaz/Data-Structures/blob/master/test/com/matthewddiaz/datastructures/trees/BinaryTreeTest.java)


## Binary Search Trees
A Binary Search Tree is a Binary Tree that has the following property:

For every node in the BST all nodes in its left subtree have smaller key values
and its key and all nodes in its right subtree have key values greater than or equal to its key.

### [Binary Search Tree](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/trees/BinarySearchTree.java)
BinarySearchTree.java is implemented by using chained Nodes.

Each Node contains:
1) A key 
2) Pointer to its left child
3) Pointer to its right child

#### Queries of a BST

1) **Node maximum()** - returns the node with max key value in the BST. 

    **Time Complexity:** Θ(lg(h))

2) **Node minimum()** - returns the node with min key value in the BST.

   **Time Complexity:** Θ(lg(h))
   
3) **Node treeSearch(T key)** - returns the node in the BST that contains 
the input key value. NOTE: If no node in the BST contains the input key value 
then null is returned.  
    **Time Complexity:** Θ(lg(h))

4)  **Node successor(Node node)** - returns the successor node of the input Node.

    The successor node is the node with the next smallest larger key value than the
    current node's key. That is in an inorder traversal the successor node would be the
    node right after the current node.
    
    There are two cases for finding the successor:
    
    1) When the input node (n) has a right subtree:
        1) The successor node (s) is the minimum node in n's right subtree 
    
    2) When the input node (n) does not have a right subtree:
        1) The successor node (s) is the lowest ancestor of n whose left child
         is also an ancestor of n.
    
5)  **Node predecessor(Node node)** - returns the predecessor node of the input Node.

    The predecessor node is the node with the largest smaller key value than the
    current node's key. That is in an inorder traversal the predecessor node would be the
    node right before the current node.
    
    There are two cases for finding the predecessor:
    
    1) When the input node (n) has a left subtree:
        1) The predecessor node (s) is the maximum node in n's left subtree 
    
    2) When the input node (n) does not have a left subtree:
        1) The predecessor node (s) is the lowest ancestor of n whose right child
         is also an ancestor of n.
 
#### Operations of a BST

1) **void insert(T key)** - inserts a new node (n) with the value of the input key into the BST. 
Note: All new nodes are added as leaf nodes. Determining the parent node of the new node always
starts from the root and then finds its way to the lowest root by using the following procedure
    1) If the key of n is greater than comparison node's (c) key then move on to c's right child
    2) Else move on to c's left child 


2) **void delete(T key)** - deletes the node that contains the input key value. There are 3 possible 
scenarios when deleting a node:
    1)  The node (n) to be deleted has 0 children
        1) Find parent node (p) of n.
        2) Set p's child that currently points to n to null.
    2)  The node (n) to be deleted has 1 child
        1) Find parent node (p) of n.
        2) Set p's child that currently points to n point to n's only child.
    3)  The node (n) to be deleted has 2 children
        1) Find n's successor node (s), this will be n's right subtree minimum node. 
        2) Find parent node (p) of successor node (s).
        3) Set n's key value equal to s's key value.
        4) Set p's left child equal to s's right child. NOTE: This step removes 
        the currently duplicate value of s's key caused in step 3. Since the successor
        node is the minimum node in the right subtree; this guarantees that p's left child
        is equal to s. Furthermore since s is a minimum node it may potentially only have a right child.

**Test class:** [BinarySearchTreeTest](https://github.com/matthewddiaz/Data-Structures/blob/master/test/com/matthewddiaz/datastructures/trees/BinarySearchTreeTest.java)
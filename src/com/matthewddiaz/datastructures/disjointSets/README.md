# Fundamental Data Structures

## Disjoint Set Data structure

### [DisjointSets](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/disjointSets/DisjointSets.java)

A **Disjoint-set data structure** - maintains a collection of disjoint dynamic sets. 

Each set is identified via a **representative** - which is some member of the set. Usually the first
member of the set.

Disjoint-sets have the following operations:

1) **void makeSet(T element)** - creates a new Set with the input element being its only member. 
    Note: At this point input element is the only member in the set and therefore must also be the 
    representative element.

2) **void union(T elementX, T elementY)** - unites the dynamic sets that contain elementX and elementY. 
    Note: union does not occur if element X and element Y are in the same dynamic set.
     
3) **T findSet(T element)** - returns the representative element of the set that contains the input element.  

## Implementing Disjoint Set using Linked Lists 
### [DisjointSetsBackedByLinkedLists](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/disjointSets/DisjointSetsBackedByLinkedLists.java)

Each set is represented by its own linked list.

Each **Disjoint Linked List** set contains the following attributes:
1) **Node head** - which points to the first Node in the list
2) **Node tail** - which points to the last Node in the list
3) **int size** - the number of elements in the set 

Each input element is wrapped in a **Node**; each Node contains:
1) **T member** - set member
2) **Node nextPtr** - pointer to the next Node in the Linked List
3) **LinkedList setPtr** - pointer back to the set object (Linked List)

#### Heuristics used.

1) **Weight Heuristic** used to reduce time of union(T elementX, T elementY)
    1) Append the set with the smaller size to that of the larger size
    2) update the size of the larger set
    3) delete the smaller set
    
    NOTE: If both sets have the same size then merge the second set into the first set.

**Test class:** [DisjointSetsBackedByLinkedLists](https://github.com/matthewddiaz/Data-Structures/blob/master/test/com/matthewddiaz/datastructures/disjointSets/DisjointSetsBackedByLinkedListsTest.java)

## Implementing Disjoint Set using Rooted Trees (Forest)
### [DisjointSetsBackedByForests](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/disjointSets/DisjointSetsBackedByForest.java)

**Note:** This implementation is faster than Disjoint Set using Linked Lists

Each set is represented by its own rooted tree.

Each **Disjoint Rooted Tree** set has 1 attribute:
1) **Node root** - points to the root node of the rooted tree. The root Node contains the representative element and
its parent pointer is itself.
 
Each input element is wrapped in a **Node**; each Node contains:
1) **Node parentPtr** - pointer to parent Node in rooted tree
2) **T member** - set member
3) **int rank** - upper bound on height of current node
  
#### Heuristics used.
1) **Union By Rank**
    
    Two possible cases:
    1) **Roots of tree x and tree y have equal rank** - the tree of the root with the lower rank points to the tree whose 
        root has a a higher rank. Note: the actual ranks are not changed. 
    2) **Roots of trees x and y have equal rank** - choose any of the 2 roots as the parent, and have the other root point
        to it. The tree that has gaines the other tree increments its root's rank by 1.

2) **Path Compression**

    Used during **FindSet(T element)** operation
    1) Make each node on the "find path" point directly to the root. 
    Note: No ranks are changed.
    
    **find path** - is the path from Node "a" to the root Node in the tree. 
    
**Test class:** [DisjointSetsBackedByForestsTest](https://github.com/matthewddiaz/Data-Structures/blob/master/test/com/matthewddiaz/datastructures/disjointSets/DisjointSetsBackedByForestTest.java)


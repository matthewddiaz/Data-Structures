# Fundamental Data Structures

## Linked List
LinkedList is a data structure in which elements are arranged in a linear order, determined by a pointer. 
Singley LinkedLists are usually implemented with only having 1 pointer the head.
However this causes appendElement(T key) to operate in Θ(n)
  
### [Linked List](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/linkedList/LinkedList.java)
LinkedList.java is implemented using two pointers a head and tail to improve the performance of some operations.

Linked List supports the following operations:

1) **void appendElement(T key)** - inserts an key at the end (tail) of the LinkedList.
    
    **Time Complexity:** Θ(1)

2) **void prependElement(T key)** - inserts an key at the front (head) of the LinkedList.
   **Time Complexity:** Θ(1)
   
3) **boolean containsElement(T key)** - returns true if LinkedList contains the key.
   
   **Time Complexity:** Θ(n)

4) **boolean removeElement(T key)** - removes key and returns true if LinkedList contains the key; 
if the key is not in the LinkedList returns false.
   
   **Time Complexity:** Θ(n)

**Test class:** [LinkedListTest](https://github.com/matthewddiaz/Data-Structures/blob/master/test/com/matthewddiaz/datastructures/linkedList/LinkedListTest.java)


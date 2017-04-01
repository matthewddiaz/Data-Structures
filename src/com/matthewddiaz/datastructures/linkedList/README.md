# Fundamental Data Structures

## Linked List
LinkedList is a data structure in which elements are arranged in a linear order, determined by a pointer. 
Singley LinkedLists are usually implemented with only having 1 pointer the head.
However this causes appendElement(T element) to operate in Θ(n)
  
### [Linked List](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/linkedList/LinkedList.java)
LinkedList.java is implemented using two pointers a head and tail to improve the performance of some operations.

Linked List supports the following operations:

1) **void appendElement(T element)** - inserts an element at the end (tail) of the LinkedList.
    
    **Time Complexity:** Θ(1)

2) **void prependElement(T element)** - inserts an element at the front (head) of the LinkedList.
   **Time Complexity:** Θ(1)
   
3) **boolean containsElement(T element)** - returns true if LinkedList contains the element.
   
   **Time Complexity:** Θ(n)

4) **boolean removeElement(T element)** - removes element and returns true if LinkedList contains the element; 
if the element is not in the LinkedList returns false.
   
   **Time Complexity:** Θ(n)

**Test class:** [LinkedListTest](https://github.com/matthewddiaz/Data-Structures/blob/master/test/com/matthewddiaz/datastructures/linkedList/LinkedListTest.java)


# Fundamental Data Structures

## Linked List
Linked List is a data structure in which elements are arranged in a linear order, determined by a pointer. 
Linked Lists are usually implemented with only  1 pointer the **head** which points to the first node in the linked list.
However this causes the operation **void appendElement(T key)** to operate in **Θ(n)**, adding a pointer that points to 
the last node in the linked list, **tail**, reduces the time of this operation to **Θ(1)**. 

### Two Main types of Linked Lists

#### 1. Singly Linked List
The singly linked list contains 1 pointer, **head**, which points to the first Node in linked list. Each Node in the linked list contains 
a T member attribute and 1 pointer that points to the next Node in the linked list.
 
#### 2. Doubly Linked List
The doubly linked list is the same as a singly linked list except that each Node in the linked list contains an additional
pointer, **previous**, which points to the previous Node in the linked list. That is each Node has two pointers a **next** and
a **previous**.

### [Linked List](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/linkedList/LinkedList.java)
LinkedList.java is implemented using two pointers a head and tail to improve the performance of some operations.

Linked List supports the following operations:

1) **void appendElement(T key)** - inserts a key at the end (tail) of the LinkedList.
    
    **Time Complexity:** Θ(1)

2) **void prependElement(T key)** - inserts a key at the front (head) of the LinkedList.
   **Time Complexity:** Θ(1)
   
3) **boolean containsElement(T key)** - returns true if the LinkedList contains the key.
   
   **Time Complexity:** Θ(n)

4) **boolean removeElement(T key)** - removes the node with the input key and returns true if LinkedList contains the key; 
if the key is not in the LinkedList returns false.
   
   **Time Complexity:** Θ(n)

**Test class:** [LinkedListTest](https://github.com/matthewddiaz/Data-Structures/blob/master/test/com/matthewddiaz/datastructures/linkedList/LinkedListTest.java)


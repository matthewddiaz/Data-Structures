# Fundamental Data Structures

## Lists

A **list** is an order collection. The user has the ability to get, insert, and remove an element at any index position 
in the collection. Unlike **Sets** lists usually allow for duplicate input elements. Note: A list is referred to as an
abstract data type (ADT) instead of a data structure since it only specifies the interface but not the implementation.

#### Common Operations of a [List](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/list/List.java)

1) **void appendElement(E element)** - inserts the element at the end of the list

2) **boolean containsElement(E element)** - returns true if the element is in the List

3) **Iterator<E> createIterator()** - returns an Iterator object of the List

4) **boolean removeElement(E element)** - if the element is in the list, it is removed and the method returns true.

5) **E removeElement(int index)** - removes and returns the element at the index 

6) **E getElement(int index)** -  returns the element at the index

7) **void insertElement(E element, int index)** -inserts the element into the list at the given index

8) **prependElement(E element)** - inserts the element at the front of the list

9) **size()** - returns the number of elements in the list

10) **toString()** - returns a String representation of the list

### Linked List
A **Linked List** is a data structure in which elements are arranged in a linear order, determined by a pointer. 
Linked Lists are usually implemented with only  1 pointer the **head** which points to the first node in the linked list.
However this causes the operation **void appendElement(T key)** to operate in **Θ(n)**, adding a pointer that points to 
the last node in the linked list, **tail**, reduces the time of this operation to **Θ(1)**. 

Advantage over Dynamic Array data structure is it has better space conservation; that is the length of the backing array 
of a dynamic array ranges from [n + 1, 1.5 * n] where n is the number of elements in the array.

**Note:** Linked Lists are usually used to implement the List ADT.

#### Two Main types of Linked Lists

##### 1. Singly Linked List
The singly linked list contains 1 pointer, **head**, which points to the first Node in linked list. Each Node in the linked list contains 
a T member attribute and 1 pointer that points to the next Node in the linked list.
 
##### 2. Doubly Linked List
The doubly linked list is the same as a singly linked list except that each Node in the linked list contains an additional
pointer, **previous**, which points to the previous Node in the linked list. That is each Node has two pointers a **next** and
a **previous**.

### [Linked List](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/linkedList/LinkedList.java)
LinkedList.java is implemented using two pointers a head and tail to improve the performance of some operations.
NOTE: LinkedList.java implements List and must therefore implement all of List's methods.

Linked List supports at the minimum following operations:

1) **void appendElement(T key)** - inserts a key at the end (tail) of the LinkedList.
    
    **Time Complexity:** Θ(1)

2) **void prependElement(T key)** - inserts a key at the front (head) of the LinkedList.
   **Time Complexity:** Θ(1)
   
3) **boolean containsElement(T key)** - returns true if the LinkedList contains the key.
   
   **Time Complexity:** Θ(n)

4) **boolean removeElement(T key)** - removes the node with the input key and returns true if LinkedList contains the key; 
if the key is not in the LinkedList returns false.
   
   **Time Complexity:** Θ(n)

**Test class:** [LinkedListTest](https://github.com/matthewddiaz/Data-Structures/blob/master/test/com/matthewddiaz/datastructures/list/linkedList/LinkedListTest.java)

### Dynamic Array
A **Dynamic Array** is a random access resizeable data structure. Dynamic Arrays are also called ArrayLists. They overcome the fixed size limitation
in standard arrays in that they shrink and grow in size depending if more or less space is necessary. Advantage over Linked List is that accessing an 
element from a Dynamic Array takes O(1) time instead of O(n).

**Note:** Linked Lists are usually used to implement the List ADT.

### [Dynamic Array](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/list/DynamicArray.java)
DynamicArray.java implements List and therefore must implement all of List's methods.

Note: Dynamic Array is backed by an Array.
How Dynamic Array differs from a regular Array:

1) When inserting an element (e) in the dynamic array and it is full:
    1) Create a new backing array that is 1.5 times the actual array (a)
    2) Transfer all of the elements from the old array into the larger array
    3) set the actual array equal to the new larger backing array
    4) add the element e

2) When the dynamic array's capacity is less than (1/3) of the backing array's size shrink the array
    1) Create a new backing array that is (2/3) the size of the actually array
    2) Transfer all of the elements from the old array into the smaller array
    3) set the actual array equal to the new smaller backing array
    Note: Usually happends after lots of elements have been removed from the list 

**Test class:** [DynamicArrayTest](https://github.com/matthewddiaz/Data-Structures/blob/master/test/com/matthewddiaz/datastructures/list/dynamicArray/DyamicArrayTest.java)


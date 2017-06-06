# Fundamental Data Structures

## Stack
Is a dynamic set that only allows removal of the most recently inserted key.
That is **LIFO (Last In, First Out)**
  

### [Stack](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/stack/StackList.java)
Stack.java is implemented by using chained Nodes, however it can also be implemented using
and array. If the Stack is implemented using an array then its size is bound by the size 
of the array. When implemented using chained nodes class Stack has a **head** pointer that points
to the top most key in the stack.

Operations of Stack

1) **void push(T key)** - inserts key to the top of the Stack. 

    **Time Complexity:** Θ(1)

2) **T pop()** - removes and returns the top most key of the Stack.
    If the Stack is empty returns null.

   **Time Complexity:** Θ(1)

**Test class:** [StackTest](https://github.com/matthewddiaz/Data-Structures/blob/master/test/com/matthewddiaz/datastructures/stack/StackTest.java)


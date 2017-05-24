# Fundamental Data Structures

## Queue
The Queue is a dynamic set that contains a tail and head. Elements are inserted at the tail and removed from the head.
That is First In, First Out (FIFO).
  

### [Queue](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/queue/Queue.java)
Queue.java is implemented using chained nodes; however it can also be implemented using an array. If a Queue is implemented
using an array its size is bound by the size of the array.

Queue supports the following operations:

1) **void enqueue(T key)** - inserts an key to the tail of the Queue. 

    **Time Complexity:** Θ(1)

2) **T dequeue()** - removes and returns the key at the head of the Queue.

   **Time Complexity:** Θ(1)

**Test class:** [QueueTest](https://github.com/matthewddiaz/Data-Structures/blob/master/test/com/matthewddiaz/datastructures/queue/QueueTest.java)


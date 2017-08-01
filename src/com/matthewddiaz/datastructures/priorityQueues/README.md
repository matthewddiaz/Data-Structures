# Fundamental Data Structures

## Priority Queue
A priority queue is data structure that maintains priority on its data based on a data's attribute key **K**. Priority Queses 
are usually backed by a heap to ensure efficient implementation; however a priority queue may be implemented with a 
linked list or normal array. 

There are two types of priority queues a **Max PQ** and a **Min PQ**. In a Max PQ the the **extractMax()** operation 
removes the element with the largest **K** from the queue. In a Min PQ **extractMin()** operation removes the element with
the smallest **K** from the queue.

### Abstract base class [Priority Queue](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/priorityQueues/PriorityQueue.java)

### [Max Priority Queue](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/priorityQueues/MaxPriorityQueue.java)
Max Priority Queue supports the following operations:

Note: The value is referring to the value of the element's attribute key **k**.

1) **maximum()** - returns the element with the largest **K** value in the priority queue. The key is not removed from the priority queue.

    **Time Complexity:** Θ(1)

2) **extractMaximum()** - returns and removes the element with the largest **K** value in the priority queue.
        
   **Time Complexity:** Θ(lg(n))
      
3) **insertElement(Element key)** - inserts an element into the priority queue.

    **Time Complexity:** Θ(lg(n))


**Test class:** [MaxPriorityQueueTest](https://github.com/matthewddiaz/Data-Structures/blob/master/test/com/matthewddiaz/datastructures/priorityQueues/MaxProrityQueueTest.java)


### [Min Priority Queue](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/priorityQueues/MinPriorityQueue.java)
Max Priority Queue supports the following operations:

1) **minimum()** - returns the element with the smallest **K** value in the priority queue. The key is not removed from the priority queue.

    **Time Complexity:** Θ(1)

2) **extractMinimum()** - returns and removes the element with the largest **K** value in the priority queue.
        
   **Time Complexity:** Θ(lg(n))
      
3) **insertElement(Element key)** - inserts a key into the priority queue.

    **Time Complexity:** Θ(lg(n))
    
**Test class:** [MinPriorityQueueTest](https://github.com/matthewddiaz/Data-Structures/blob/master/test/com/matthewddiaz/datastructures/priorityQueues/MinProrityQueueTest.java)
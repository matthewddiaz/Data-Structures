# Fundamental Data Structures

## Heap
A heap is a data structure that viewed as a binary tree that is backed by an array of size N. 
Elements range from A[1...N]; where A[0] is usually left empty and A[1] is the root. A parent key A[P] has a 
left child key at A[2P] and right child at A[2P + 1]. 

There are two types of heaps a Min Heap and a Max Heap. In a Max Heap the root key is the largest key in the heap;
likewise the root key in a Min Heap is the smallest key in the heap. In a Max Heap neither the right or left
child can be greater than the parent; likewise in a Min Heap neither the right or left child can be less than the the parent.

A heap has an attribute heap size that maintains the number of elements in the heap; heap.size ranges from [0,N]. 
Note: The key A[n/2] is the last node in a heap that can have children. 
All elements after A[(n+1)/2...n] are leaf nodes. 

Operations: 
1) Heapify(int index) - makes sure that key at current position maintains heap property. 
2) buildHeap(Array A) - converts array A into a heap.  

### [Max Heap](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/heap/MaxHeap.java)
Max Heap supports the following operations:

1) **maxHeapify(Array A, int index)** - ensures that both the left and right child are less than the key at the given index.
The method finds the index of the largest key between the node, right, and left child. If the index is of the largest
key does not correspond to the parent's index; the parent key is swapped with the child key. Then maxHeapify 
is recursively called again until heap properties are enforced.

    **Time Complexity:** Θ(lg(n))

2) **buildMaxHeap(Array A)** - converts array A into a Max heap. The Max Heap constructs the max heap from bottom-up approach
by calling maxHeapify() on nodes A[N/2..1]. Recall that nodes after index N/2 are leaf nodes and therefore already conform
to max heap's property.

**NOTE:** This Max Heap is implemented with root at A[0] thus both left and right child
are offset by 1.

   **Time Complexity:** Θ(n)

**Test class:** [MaxHeapTest](https://github.com/matthewddiaz/Data-Structures/blob/master/test/com/matthewddiaz/datastructures/queue/MaxHeapTest.java)

## Priority Queue
A priority queue is data structure that maintains priority on the data  based on a key K. Priority Queses are usually backed by 
a heap to ensure efficient implementation. There are two types of priority queues a Max PQ and a Min PQ. In a Max PQ the 
the extractMax() operation removes the highest priority key from the queue. In a Min PQ extractMin() operation removes the 
lowest priority key from the queue. 


### [Max Priority Queue](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/heap/MaxPriorityQueue.java)
Max Priority Queue supports the following operations:

1) **max()** - returns the highest priority key in the queue A[0]

    **Time Complexity:** Θ(1)
2) extractMax() - returns and removes the highest priority key from the queue.
    After the largest key is removed must call maxHeapify(A, 1)
        
      **Time Complexity:** Θ(lg(n))
3) insertElement(Element key) - inserts an key into the queue.

**Time Complexity:**

**Test class:** [MaxPriorityQueueTest](https://github.com/matthewddiaz/Data-Structures/blob/master/test/com/matthewddiaz/datastructures/queue/MaxProrityQueueTest.java)

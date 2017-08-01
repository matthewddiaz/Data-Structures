# Fundamental Data Structures

## Heap
A heap is a data structure that is viewed as a binary tree backed by an array of size N. 
Elements range from A[1...N]; where A[0] is usually left empty and A[1] is the **root**. A parent key A[P] has a 
left child key at A[2P] and right child at A[2P + 1]. 

**NOTE:** leaving A[0] empty allows for easier arithmetic when calculating the index of the left and right child;
however it is possible to start the root at A[0].

There are two types of heaps a **Min Heap** and a **Max Heap**. In a Max Heap the root key is the largest key in the heap;
likewise the root key in a Min Heap is the smallest key in the heap. In a Max Heap neither the right child nor the left
child can be greater than the parent; likewise in a Min Heap neither the right or left child can be less than the the parent.

A heap has an attribute heap size that maintains the number of elements in the heap; heap.size ranges from [0,N]. 
Note: The key A[n/2] is the last node in a heap that can have children. 
All elements after are leaf nodes, they include A[(n+1)/2...n]. 

NOTE: The heap attributes **size** and **heapSize** mean two different things. 
**size** - is the size of the backing array.
**heapSize** - is the number of the elements in the heap; can ranges from 0 to size.

Operations: 
1) Heapify(int index) - makes sure that the key at the current position maintains its heap property. 
2) buildHeap(Array A) - converts array A into a heap.  

### Abstract base class [Heap](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/heap/Heap.java)

### [Max Heap](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/heap/MaxHeap.java)
Max Heap supports the following operations:

1) **maxHeapify(Array A, int index)** - ensures that both the left and right child are less than the key at the given index.
The method finds the index of the largest key between the node, right, and left child. If the index of the largest
key does not correspond to the parent's index; the parent key is swapped with the child key. Then maxHeapify 
is recursively called again until heap properties are enforced.

    **Time Complexity:** Θ(lg(n))

2) **buildMaxHeap(Array A)** - converts array A into a Max heap. The Max Heap constructs the max heap by using a bottom-up approach
by calling maxHeapify() on nodes A[N/2..1]. Recall that nodes after index N/2 are leaf nodes and therefore already conform
to max heap's property.

**NOTE:** This Max Heap is implemented with root at A[0] thus both left and right child
are offset by 1. That is leftChildIndex is (2i + 1) and rightChildIndex is (2i + 2) where i is the parent index.

   **Time Complexity:** Θ(n)

**Test class:** [MaxHeapTest](https://github.com/matthewddiaz/Data-Structures/blob/master/test/com/matthewddiaz/datastructures/heap/MaxHeapTest.java)

### [Min Heap](https://github.com/matthewddiaz/Data-Structures/blob/master/src/com/matthewddiaz/datastructures/heap/MaxHeap.java)
Min Heap supports the following operations:

1) **minHeapify(Array A, int index)** - ensures that both the left and right child are greater than or equal the key at the
given index. The method finds the index of the smallest key between the node, right, and left child. If the index of the smallest
key does not correspond to the parent's index; the parent key is swapped with the child key. Then minHeapify 
is recursively called again until heap properties are enforced.

    **Time Complexity:** Θ(lg(n))

2) **buildMinHeap(Array A)** - converts array A into a Min heap. The Min Heap constructs the min heap by using a bottom-up approach
by calling minHeapify() on nodes A[N/2..1]. Recall that nodes after index N/2 are leaf nodes and therefore already conform
to min heap's property.

**NOTE:** This Min Heap is implemented with root at A[0] thus both left and right child
are offset by 1. That is leftChildIndex is (2i + 1) and rightChildIndex is (2i + 2) where i is the parent index.

   **Time Complexity:** Θ(n)

**Test class:** [MinHeapTest](https://github.com/matthewddiaz/Data-Structures/blob/master/test/com/matthewddiaz/datastructures/heap/MinHeapTest.java)
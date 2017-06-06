package com.matthewddiaz.datastructures.heap;

/**
 * Created by matthewdiaz on 2/19/17.
 */

/**
 * A max heap is a data structure that maintains elements based on the rule that parent element
 * must be greater than or equal to its left and right child.
 *
 * NOTE: That means that A[0] will always contain the largest element in the max heap
 * NOTE: Max Heap is extremely useful; since it is used to implement HeapSort and a Max Priority Queue.
 */
public class MaxHeap {
    //heapSize is equal equal to # of elements in array. Can range from [0, array.length - 1]
    private int heapSize;
    //heap length is equal to array.length
    private int length;

    /**
     * NOTE: It's important to call any of the two buildMaxHeap to turn the input array into
     * an actual Max Heap. The constructor does not do this step.
     */
    public MaxHeap(){
        this.heapSize = 0;
        this.length = 0;
    }

    /**
     * maxHeapify ensures that Max Heap rule is enforced. If the rule is broken for the
     * current parent then, it is swapped with the larger child. That means that the larger
     * child becomes the parent and the parent gets filled into the larger child position. Then
     * maxHeapify is called again on the larger child position to check the rule again.
     *
     * NOTE1: Max Heap rule is that the value of parentIndex is greater than
     * or equal to the value of its children.
     *
     * Running Time: θ(lg(n))
     * @param array
     * @param parentIndex
     */
    public void maxHeapify(Comparable[] array, int parentIndex){
        //returns immediately if parentIndex is larger than the index of the last nonleaf node in the heap;
        //because the element at parentIndex is actually a leaf element.
        int lastNonLeafElementIndex = (this.heapSize/2) - 1;
        if(parentIndex > lastNonLeafElementIndex){
            return;
        }

        //NOTE: To have A[0] as the starting node instead of A[1]
        //leftChildIndex & rightChildIndex is offset by an addition 1
        int leftChildIndex = 2*parentIndex + 1;
        int rightChildIndex = 2*parentIndex + 2;
        int largestElementIndex = parentIndex;

        //check if leftChildIndex is less than heapSize & leftChild is greater than parent
        if((leftChildIndex < this.heapSize) && (array[leftChildIndex].compareTo(array[parentIndex]) > 0)){
            largestElementIndex = leftChildIndex;
        }

        //check if rightChildIndex is less than heapSize & rightChild is greater than largestElement
        if((rightChildIndex < this.heapSize) && (array[rightChildIndex].compareTo(array[largestElementIndex]) > 0)){
            largestElementIndex = rightChildIndex;
        }

        //if largest element is not the parent element swap the values of the largest with parent
        //and then recursively call maxHeapify to the previously parent value that is now in largestElementIndex
        //after the swap.
        if(largestElementIndex != parentIndex){
            swap(array, largestElementIndex, parentIndex);
            maxHeapify(array, largestElementIndex);
        }
    }

    /**
     * This method calls buildMaxHeap(array, numOfElements) and assumes that
     * the number of elements in the array is equal to array.length; that the array is full.
     *
     * Running Time: θ(n)
     * @param array
     */
    public void buildMaxHeap(Comparable[] array) {
        try {
            buildMaxHeap(array, array.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Builds input array for an array of size n into a max heap with a bottom up approach by calling maxHeapify on
     * every index that may have a child. That is from [((n/2) - 1)... 0]
     * NOTE: n is the number of elements in the heap/array
     *
     * Number of elements is explicitly input by the user.
     * @param array
     * @param numOfElements range [0...array.length]
     *
     * Running Time: θ(n)
     */
    public void buildMaxHeap(Comparable[] array, int numOfElements) throws Exception {
        if(numOfElements < 0 || numOfElements > array.length){
            throw new Exception("Number of elements for this heap is out of bound. " +
                    "Acceptable range for numOfElements is [0...array.length]");
        }

        this.length = array.length;
        this.heapSize = numOfElements;
        //don't need to call maxHeapify if the heap is empty or only has 1 element
        if(this.heapSize < 2){
            return;
        }

        //index of last nonLeaf element in array
        int nonLeafIndex = (this.heapSize/2) - 1;
        for(; nonLeafIndex >= 0; nonLeafIndex--){
            maxHeapify(array, nonLeafIndex);
        }
    }

    private void swap(Comparable[] array, int leftElement, int rightElement){
        Comparable tempElement = array[leftElement];
        array[leftElement] = array[rightElement];
        array[rightElement] = tempElement;
    }

    /**
     * Returns true when heap is empty (contains 0 elements)
     * @return
     */
    public boolean isEmpty(){
        return this.heapSize <= 0;
    }

    /**
     * Returns true when heap is full (heapSize is greater than or equal to the length)
     * @return
     */
    public boolean isFull(){
        return this.heapSize >= this.length;
    }

    public void decrementHeapSize(){
        this.heapSize--;
    }

    public void incrementHeapSize(){ this.heapSize++;}

    /**
     * The number of elements currently in the heap.
     * Ranges from [0... A.length]
     * @return
     */
    public int getHeapSize(){
        return this.heapSize;
    }

    /**
     * The length of the input array.
     * This is equal to A.length
     * @return
     */
    public int getLength() { return this.length; }

    public void setHeapSize(int heapSize){
        this.heapSize = heapSize;
    }
}


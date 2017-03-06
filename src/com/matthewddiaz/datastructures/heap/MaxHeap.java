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
    //heapSize can range from [0, array.length]
    private int heapSize;

    /**
     * maxHeapify ensures that Max Heap rule is enforced. If the rule is broken for the
     * current parent then, it is swapped with the larger child. That means that the larger
     * child becomes the parent and the parent gets filled into the larger child position. Then
     * maxHeapify is called again on the larger child position to check the rule again.
     *
     * NOTE: Max Heap rule is that the value of parentIndex is greater than
     * or equal to the value of its children.
     * @param array
     * @param parentIndex
     */
    public void maxHeapify(int[] array, int parentIndex){
        //NOTE: To have A[0] as the starting node instead of A[1]
        //leftChildIndex & rightChildIndex is offset by an addition 1
        int leftChildIndex = 2*parentIndex + 1;
        int rightChildIndex = 2*parentIndex + 2;
        int largestElementIndex = parentIndex;

        //check if leftChildIndex is less than heapSize & leftChild is greater than parent
        if(leftChildIndex <= this.heapSize && array[leftChildIndex] > array[parentIndex]){
            largestElementIndex = leftChildIndex;
        }

        //check if rightChildIndex is less than heapSize & rightChild is greater than largestElement
        if(rightChildIndex <= this.heapSize && array[rightChildIndex] > array[largestElementIndex]){
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
     * Builds input array for an array of size n into a max heap with a bottom up approach by calling maxHeapify on
     * every index that may have a child. That is from [1.. (n/2)]
     *
     * NOTE: n/2 is the last nonleaf element. Elements from [(n/2) + 1, n] are all leaf elements
     * and can't have children.
     *
     * NOTE: heapSize is set to (array.length - 1)
     * @param array
     */
    public void buildMaxHeap(int[] array){
        this.heapSize = array.length - 1;
        for(int nonLeafIndex = this.heapSize/2; nonLeafIndex >= 0; nonLeafIndex--){
            maxHeapify(array, nonLeafIndex);
        }
     }

    private void swap(int[] array, int leftElement, int rightElement){
        int tempElement = array[leftElement];
        array[leftElement] = array[rightElement];
        array[rightElement] = tempElement;
    }

    public void decrementHeapSize(){
        this.heapSize--;
    }

    public void incrementHeapSize(){ this.heapSize++;}

    public int getHeapSize(){
        return this.heapSize;
    }

    public void setHeapSize(int heapSize){
        this.heapSize = heapSize;
    }
}


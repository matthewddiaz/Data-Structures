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
public class MaxHeap<T extends Comparable> extends Heap<T>{
    /**
     * NOTE: It's important to call any of the two buildMaxHeap to turn the input array into
     * an actual Max Heap. The constructor does not do this step.
     */
    public MaxHeap(){
        super();
    }


    @Override
    protected int indexOfHighestPriorityValue(T[] array, int parentIndex, int leftChildIndex, int rightChildIndex) {
        int largestElementIndex = parentIndex;
        //check if leftChildIndex is less than heapSize & leftChild is greater than parent
        if((leftChildIndex < this.getHeapSize()) && (array[leftChildIndex].compareTo(array[parentIndex]) > 0)){
            largestElementIndex = leftChildIndex;
        }

        //check if rightChildIndex is less than heapSize & rightChild is greater than largestElement
        if((rightChildIndex < this.getHeapSize()) && (array[rightChildIndex].compareTo(array[largestElementIndex]) > 0)){
            largestElementIndex = rightChildIndex;
        }
        return largestElementIndex;
    }

}


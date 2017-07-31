package com.matthewddiaz.datastructures.heap;

/**
 * Created by matthewdiaz on 7/31/17.
 */
public class MinHeap extends Heap{

    public MinHeap(){
        super();
    }

    @Override
    protected int indexOfCorrectValue(Comparable[] array, int parentIndex, int leftChildIndex, int rightChildIndex) {
        int smallestElementIndex = parentIndex;
        //check if leftChildIndex is less than heapSize & leftChild is less than parent
        if((leftChildIndex < this.getHeapSize()) && (array[leftChildIndex].compareTo(array[parentIndex]) < 0)){
            smallestElementIndex = leftChildIndex;
        }

        //check if rightChildIndex is less than heapSize & rightChild is greater than largestElement
        if((rightChildIndex < this.getHeapSize()) && (array[rightChildIndex].compareTo(array[smallestElementIndex]) < 0)){
            smallestElementIndex = rightChildIndex;
        }
        return smallestElementIndex;
    }
}

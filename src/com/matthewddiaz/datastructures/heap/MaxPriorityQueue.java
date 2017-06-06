package com.matthewddiaz.datastructures.heap;

/**
 * Created by matthewdiaz on 2/27/17.
 */

import com.matthewddiaz.designpatterns.behavioralPatterns.Iterator;

/**
 * MaxPriorityQueue data structure maintains a set of elements which are maintained based on an attribute
 * of element called key. MPQ has 3 major operations to perform the data:
 * 1) maximum(),
 * 2) extractMaximum(),
 * 3) insertElement()
 *
 * NOTE: The following MPQ implementation is backed by a Max Heap and thus must comply with Max Heap rules after
 * inserting a key and removing the maximum key. However this MPQ may have been implemented using another data structure.
 */
public class MaxPriorityQueue {
    private MaxHeap maxHeap;
    private Comparable[] heapArray;

    /**
     * Constructor that turns the input Comparable array to a maxHeap.
     * NOTE: Assumes that the array is full that is that
     * heapSize is equal to size that is (array.length - 1)
     * @param array
     */
    public MaxPriorityQueue(Comparable[] array) {
        this.maxHeap = new MaxHeap();
        this.heapArray = array;
        this.maxHeap.buildMaxHeap(this.heapArray);
    }

    /**
     * Constructor that turns the input Comparable array to a maxHeap.
     * NOTE: User inputs the number of elements in the heap via the input variable numOfElementsInHeap
     * @param array
     * @param numOfElementsInHeap
     */
    public MaxPriorityQueue(Comparable[] array, int numOfElementsInHeap) throws Exception{
        this.maxHeap = new MaxHeap();
        this.heapArray = array;
        this.maxHeap.buildMaxHeap(this.heapArray, numOfElementsInHeap);
    }

    /*
     * Returns the element with the max priority from heapArray
     *
     * Running Time: θ(1)
     */
    public Comparable maximum(){
        if(isEmpty()){
            return null;
        }
        return this.heapArray[0];
    }

    /**
     * Returns and removes the element with the max priority from heapArray
     *
     * Running Time: θ(lg(n))
     * @return
     * @throws Exception
     */
    public Comparable extractMaximum() throws Exception {
        if(isEmpty()){
            throw new Exception("Heap is empty. Can't remove from an empty heap.");
        }

        Comparable maxElement = this.heapArray[0];
        //obtaining the index of the last element in the heap.
        int indexOfLastElementInHeap = this.maxHeap.getHeapSize() - 1;
        //setting the first element in heap equal to the last element. The max value has been overwritten
        this.heapArray[0] = this.heapArray[indexOfLastElementInHeap];
        //decrease heap size by 1. This is to remove the duplicate occurrence of the last element
        this.maxHeap.decrementHeapSize();
        //call maxHeapify on heap[0] to ensure max heap property on the first element
        this.maxHeap.maxHeapify(this.heapArray,0);
        return maxElement;
    }

    /**
     * Inserts a new element with priority key into the heapArray
     * NOTE: throws an exception if the MPQ is full
     *
     * Running Time: θ(lg(n))
     * @param key
     * @throws Exception
     */
    public void insertElement(Comparable key) throws Exception {
        if(isFull()){
            throw new Exception("Max Priority Queue is full. Can't insert a new element");
        }

        //inserts the key to the end of the max heap
        this.heapArray[this.maxHeap.getHeapSize()] = key;
        //placing the key in its appropriate position to conform the max heap property
        swim(this.maxHeap.getHeapSize());
        //increase the heap size by one.
        this.maxHeap.incrementHeapSize();
    }

    public boolean isEmpty(){
        return this.maxHeap.isEmpty();
    }

    public boolean isFull(){
        return this.maxHeap.isFull();
    }

    /**
     * Creates a new Iterator of MPQ. The order of the iterator is the order maintained by
     * MPQ which is its underlying heap.
     * @return
     */
    public Iterator<Comparable> createIterator(){
        return new Iterator<Comparable>() {
            private int currentIndex;

            @Override
            public void first() {
                currentIndex = 0;
            }

            @Override
            public Comparable currentElement() {
                return heapArray[currentIndex];
            }

            @Override
            public void next() {
                currentIndex++;
            }

            @Override
            public boolean isDone() {
                return (currentIndex >= maxHeap.getHeapSize());
            }
        };
    }

    /**
     * Returns array containing Max Heap data
     * @return
     */
    public Comparable[] getMaxHeap(){
        return this.heapArray;
    }

    /**
     * Moves an the element in maxHeap[index] to its correct position to ensure that maxHeap property is
     * still conformed.
     * NOTE: throws an exception if index is out of bound or if key is less than original key value
     *
     * NOTE: Since before this operation takes place heapArray conforms to the rule of a maxHeap
     * parent will also be the largest between itself and its left and right child. Therefore the while
     * loop only compares the current index of inserted key with the parent key.
     *
     * Running Time: θ(lg(n))
     * @param index
     * @throws Exception
     */
    private void swim(int index) throws Exception {
        if(index > maxHeap.getHeapSize() || index < 0){
            throw new Exception("Index out of Bound");
        }

        /**
         * While index is not the root element (A[0]) and parent of element at index is less
         * than the element at index swap the two elements and set index equal to parent index.
         */
        while(index > 0 && (this.heapArray[index/2].compareTo(this.heapArray[index]) < 0)){
            swap(index/2, index);
            index = index/2;
        }
    }

    /**
     * Swaps elements in index1 and index2 in heapArray
     * @param index1
     * @param index2
     */
    private void swap(int index1, int index2){
        Comparable tempElement = this.heapArray[index1];
        this.heapArray[index1] = this.heapArray[index2];
        this.heapArray[index2] = tempElement;
    }
}

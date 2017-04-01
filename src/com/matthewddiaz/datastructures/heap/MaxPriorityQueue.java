package com.matthewddiaz.datastructures.heap;

/**
 * Created by matthewdiaz on 2/27/17.
 */

import com.matthewddiaz.designpatterns.behavioralPatterns.Iterator;

/**
 * MaxPriorityQueue data structure maintains a set of elements which are maintained based on an attribute
 * of element called key. MPQ has 3 major operations to perform the data: maximum(), extractMaximum(),
 * insertElement()
 */
public class MaxPriorityQueue {
    private MaxHeap maxHeap;
    private Comparable[] heapArray;

    /**
     * Constructor that turns the input Comparable array to a maxHeap.
     * NOTE: Assumes that heapSize is equal to (array.length - 1)
     * @param array
     */
    public MaxPriorityQueue(Comparable[] array) {
        this.maxHeap = new MaxHeap();
        this.heapArray = array;
        this.maxHeap.buildMaxHeap(this.heapArray);
    }

    /**
     * Constructor that turns the input Comparable array to a maxHeap.
     * NOTE: HeapSize is set to the input variable numOfElementsInHeap
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
        //heap[0] gets set to last element in heap
        int indexOfLastElementInHeap = this.maxHeap.getHeapSize() - 1;
        this.heapArray[0] = this.heapArray[indexOfLastElementInHeap];
        //decrease heap size by 1
        this.maxHeap.decrementHeapSize();
        //call maxHeapify on heap[0] to ensure max heap property
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

        this.heapArray[this.maxHeap.getHeapSize()] = key;
        swim(this.maxHeap.getHeapSize());
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
     * NOTE: Since before this operation takes place heapArray conforms to the rule of a maxHeap
     * therefore the while loop makes sure that the element with the increase key is moved to its correct position
     * to maintain the max heap property.
     *
     * Running Time: θ(lg(n))
     * @param index
     * @throws Exception
     */
    private void swim(int index) throws Exception {
        if(index > maxHeap.getHeapSize() || index < 0){
            throw new Exception("Index out of Bound");
        }

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

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
    private Comparable[] heapContainer;
    private int heapContainerSize;

    /**
     * Constructor that turns the input Comparable array to a maxHeap.
     * NOTE: Assumes that heapSize is equal to (array.length - 1)
     * @param array
     */
    public MaxPriorityQueue(Comparable[] array){
        this.maxHeap = new MaxHeap();
        this.heapContainer = array;
        this.heapContainerSize = array.length - 1;
        this.maxHeap.buildMaxHeap(this.heapContainer);
    }

    /**
     * Constructor that turns the input Comparable array to a maxHeap.
     * NOTE: HeapSize is set to the input variable numOfElementsInHeap
     * @param array
     * @param numOfElementsInHeap
     */
    public MaxPriorityQueue(Comparable[] array, int numOfElementsInHeap){
        this.maxHeap = new MaxHeap();
        this.heapContainer = array;
        this.heapContainerSize = array.length - 1;
        this.maxHeap.buildMaxHeap(array, numOfElementsInHeap);
    }

    /*
     * Returns the element with the max priority from heapContainer
     *
     * Running Time: θ(1)
     */
    public Comparable maximum(){
        return this.heapContainer[0];
    }

    /**
     * Returns and removes the element with the max priority from heapContainer
     *
     * Running Time: θ(lg(n))
     * @return
     * @throws Exception
     */
    public Comparable extractMaximum() throws Exception {
        if(this.maxHeap.getHeapSize() <= 0){
            throw new Exception("Heap is empty. Can't remove from an empty heap.");
        }

        Comparable maxElement = this.heapContainer[0];
        //"removing largest element from the heap." Actually moving the element past the
        //last index of the heap.
        this.heapContainer[0] = this.heapContainer[this.maxHeap.getHeapSize()];
        this.maxHeap.decrementHeapSize();
        this.maxHeap.maxHeapify(this.heapContainer,0);
        return maxElement;
    }

    public boolean isFull(){
        return (this.maxHeap.getHeapSize() > (this.heapContainerSize));
    }

    /**
     * Inserts a new element with priority key into the heapContainer
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

        this.heapContainer[this.maxHeap.getHeapSize()] = key;
        swim(this.maxHeap.getHeapSize());
        this.maxHeap.incrementHeapSize();
    }

    /**
     * Creates a new Iterator of MPQ. The order of the iterator is the order maintained by
     * MPQ which is its underlying heap.
     * @return
     */
    public Iterator<Comparable> createIterator(){
        return new Iterator<Comparable>() {
            private int currentPosition;

            @Override
            public void first() {
                currentPosition = 0;
            }

            @Override
            public Comparable currentElement() {
                return heapContainer[currentPosition];
            }

            @Override
            public void next() {
                currentPosition++;
            }

            @Override
            public boolean isDone() {
                return (currentPosition > heapContainerSize);
            }
        };
    }

    public Comparable[] getMaxHeap(){
        return this.heapContainer;
    }

    /**
     * Moves an the element in maxHeap[index] to its correct position to ensure that maxHeap property is
     * still conformed.
     * NOTE: throws an exception if index is out of bound or if key is less than original key value
     * NOTE: Since before this operation takes place heapContainer conforms to the rule of a maxHeap
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

        while(index > 0 && (this.heapContainer[index/2].compareTo(this.heapContainer[index]) < 0)){
            swap(index/2, index);
            index = index/2;
        }
    }

    private void swap(int index1, int index2){
        Comparable tempElement = this.heapContainer[index1];
        this.heapContainer[index1] = this.heapContainer[index2];
        this.heapContainer[index2] = tempElement;
    }
}

package com.matthewddiaz.datastructures.priorityQueues;

import com.matthewddiaz.datastructures.heap.Heap;
import com.matthewddiaz.designpatterns.behavioralPatterns.Iterator;

import java.util.List;

/**
 * Created by matthewdiaz on 7/31/17.
 */
public abstract class PriorityQueue {
    private Heap heap;
    private Comparable[] heapArray;

    /**
     *
     * @param list
     * @param heap
     */
    public PriorityQueue(List<Comparable> list, Heap heap){
        this.heap = heap;
        this.heapArray = convertListToArray(list);
        this.heap.buildHeap(this.heapArray);
    }

    /**
     * Constructor that turns the input Comparable array to a maxHeap.
     * NOTE: Assumes that the array is full that is that
     * heapSize is equal to size that is (array.length - 1)
     * @param array
     * @param heap
     */
    public PriorityQueue(Comparable[] array, Heap heap) {
        this.heap = heap;
        this.heapArray = array;
        this.heap.buildHeap(this.heapArray);
    }

    /**
     * Constructor that turns the input Comparable array to a maxHeap.
     * NOTE: User inputs the number of elements in the heap via the input variable numOfElementsInHeap
     * @param array
     * @param numOfElementsInHeap
     */
    public PriorityQueue(Comparable[] array, Heap heap, int numOfElementsInHeap) throws Exception{
        this.heap = heap;
        this.heapArray = array;
        this.heap.buildHeap(this.heapArray, numOfElementsInHeap);
    }

    /**
     *
     * @param list input data (List data strucutre)
     * @return the data is inserted into a new array. The array is returned
     */
    private Comparable[] convertListToArray(List<Comparable> list){
        return list.toArray(new Comparable[list.size()]);
    }

    /**
     * Swaps elements in index1 and index2 in heapArray
     * @param index1
     * @param index2
     */
    protected void swap(int index1, int index2){
        Comparable tempElement = this.heapArray[index1];
        this.heapArray[index1] = this.heapArray[index2];
        this.heapArray[index2] = tempElement;
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
                return (currentIndex >= heap.getHeapSize());
            }
        };
    }

    /**
     *
     * @return true if heap is empty
     */
    public boolean isEmpty(){
        return this.heap.isEmpty();
    }

    /**
     *
     * @return true if heap is full
     */
    public boolean isFull(){
        return this.heap.isFull();
    }

    /**
     *
     * @return
     */
    protected Heap getHeap() {
        return heap;
    }

    /**
     *
     * @return
     */
    public Comparable[] getHeapArray() {
        return heapArray;
    }

}


package com.matthewddiaz.datastructures.priorityQueues;

import com.matthewddiaz.datastructures.heap.Heap;
import com.matthewddiaz.designpatterns.behavioralPatterns.Iterator;

import java.util.List;

/**
 * Created by matthewdiaz on 7/31/17.
 */
public abstract class PriorityQueue<T extends Comparable> {
    private Heap heap;
    private T[] heapArray;

    /**
     *
     * @param list
     * @param heap
     */
    public PriorityQueue(List<T> list, Heap heap){
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
    public PriorityQueue(T[] array, Heap heap) {
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
    public PriorityQueue(T[] array, Heap heap, int numOfElementsInHeap) throws Exception{
        this.heap = heap;
        this.heapArray = array;
        this.heap.buildHeap(this.heapArray, numOfElementsInHeap);
    }

    /**
     *
     * @param list input data (List data structure)
     * @return the data is inserted into a new array. The array is returned
     */
    private T[] convertListToArray(List<T> list){
        return list.toArray((T[])new Object[list.size()]);
    }

    /**
     * Swaps elements in index1 and index2 in heapArray
     * @param index1
     * @param index2
     */
    protected void swap(int index1, int index2){
        T tempElement = this.heapArray[index1];
        this.heapArray[index1] = this.heapArray[index2];
        this.heapArray[index2] = tempElement;
    }

    /**
     * Creates a new Iterator of MPQ. The order of the iterator is the order maintained by
     * MPQ which is its underlying heap.
     * @return
     */
    public Iterator<T> createIterator(){
        return new Iterator<T>() {
            private int currentIndex;

            @Override
            public void first() {
                currentIndex = 0;
            }

            @Override
            public T currentElement() {
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
     * Note: Time complexity is O(n) need to improve this to O(1)
     * @param key input key
     * @return true if the key is in the priority queue
     */
    public boolean contains(T key){
        for(T element : heapArray){
            if(element == key){
                return true;
            }
        }
        return false;
    }

    /*
    * Returns the element with the first priority from heapArray
    *
    * Running Time: θ(1)
    */
    protected T firstPriorityElement(){
        if(isEmpty()){
            return null;
        }
        return this.heapArray[0];
    }

    /**
     *
     * @return
     * @throws Exception
     */
    protected T extractFirstPriorityElement() throws Exception {
        if(isEmpty()){
            throw new Exception("Heap is empty. Can't remove from an empty heap.");
        }

        T maxElement = heapArray[0];
        //obtaining the index of the last element in the heap.
        int indexOfLastElementInHeap = heap.getHeapSize() - 1;
        //setting the first element in heap equal to the last element. The max value has been overwritten
        heapArray[0] = heapArray[indexOfLastElementInHeap];
        //decrease heap size by 1. This is to remove the duplicate occurrence of the last element
        heap.decrementHeapSize();
        //call maxHeapify on heap[0] to ensure max heap property on the first element
        heap.heapify(heapArray,0);
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
    public void insertElement(T key) throws Exception {
        if(isFull()){
            throw new Exception("Max Priority Queue is full. Can't insert a new element");
        }

        //inserts the key to the end of the max heap
        heapArray[heap.getHeapSize()] = key;
        //placing the key in its appropriate position to conform the max heap property
        swim(heap.getHeapSize());
        //increase the heap size by one.
        heap.incrementHeapSize();
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
        if(index > heap.getHeapSize() || index < 0){
            throw new Exception("Index out of Bound");
        }

        /**
         * While index is not the root element (A[0]) and parent of element at index is less
         * than the element at index swap the two elements and set index equal to parent index.
         */
        while(index > 0 && (isChildHigherPriority(index/2, index))){
            swap(index/2, index);
            index = index/2;
        }
    }

    /**
     *
     * @param parentIndex
     * @param childIndex
     * @return
     */
    protected abstract boolean isChildHigherPriority(int parentIndex, int childIndex);

    /**
     *
     * @param parentIndex
     * @param childIndex
     * @return
     */
    protected int compareValue(int parentIndex, int childIndex){
        return heapArray[parentIndex].compareTo(heapArray[childIndex]);
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
    public T[] getHeapArray() {
        return heapArray;
    }

}


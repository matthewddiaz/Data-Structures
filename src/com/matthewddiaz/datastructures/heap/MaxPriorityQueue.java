package com.matthewddiaz.datastructures.heap;

/**
 * Created by matthewdiaz on 2/27/17.
 */

/**
 * MaxPriorityQueue data structure maintains a set of elements which are maintained based on an attribute
 * of element called key.
 * NOTE: this
 */
public class MaxPriorityQueue {
    private MaxHeap maxHeap;
    private int[] heapContainer;

    public MaxPriorityQueue(int[] array){
        this.maxHeap = new MaxHeap();
        this.heapContainer = array;
        this.maxHeap.buildMaxHeapify(this.heapContainer);
    }

    /*
     * Returns the element with the max priority from heapContainer
     */
    public int maximum(){
        return this.heapContainer[0];
    }

    /**
     * Returns and removes the element with the max priority from heapContainer
     * @return
     * @throws Exception
     */
    public int extractMaximum() throws Exception {
        if(this.maxHeap.getHeapSize() <= 0){
            throw new Exception("Heap is empty. Can't remove from an empty heap.");
        }

        int maxElement = this.heapContainer[0];
        //"removing largest element from the heap." Actually moving the element past the
        //last index of the heap.
        this.heapContainer[0] = this.heapContainer[this.maxHeap.getHeapSize()];
        this.maxHeap.decrementHeapSize();
        this.maxHeap.maxHeapify(this.heapContainer,0);
        return maxElement;
    }

    /**
     * Inserts a new element with priority key into the heapContainer
     * NOTE: throws an exception if the MPQ is full
     * @param key
     * @throws Exception
     */
    public void insertElement(int key) throws Exception {
        if(this.maxHeap.getHeapSize() >= this.heapContainer.length - 1){
            throw new Exception("Max Priority Queue is full. Can't insert a new element");
        }

        this.maxHeap.incrementHeapSize();
        this.heapContainer[this.maxHeap.getHeapSize()] = Integer.MIN_VALUE;
        increaseKey(this.maxHeap.getHeapSize(), key);
    }

    /**
     * Increases the key value of an element in heapContainer.
     * NOTE: throws an exception if index is out of bound or if key is less than original key value
     * NOTE: Since the before this operation takes place heapContainer conforms to the rule of a maxHeap
     * therefore the while loop makes sure that the element with the increase key is moved to its correct position
     * to maintain the max heap property.
     * @param index
     * @param key
     * @throws Exception
     */
    public void increaseKey(int index, int key) throws Exception {
        if(index > maxHeap.getHeapSize() || index < 0){
            throw new Exception("Index out of Bound");
        }

        if(this.heapContainer[index] > key){
            throw new Exception("Key" + key + " is smaller than current key for index" + index);
        }
        this.heapContainer[index] = key;
        while(index > 0 && (this.heapContainer[index/2] < this.heapContainer[index])){
            swap(index/2, index);
            index = index/2;
        }
    }

    public boolean isFull(){
        return (this.maxHeap.getHeapSize() == this.heapContainer.length - 1);
    }

    private void swap(int index1, int index2){
        int tempElement = this.heapContainer[index1];
        this.heapContainer[index1] = this.heapContainer[index2];
        this.heapContainer[index2] = tempElement;
    }
}

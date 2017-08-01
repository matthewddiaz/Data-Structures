package com.matthewddiaz.datastructures.priorityQueues;

/**
 * Created by matthewdiaz on 2/27/17.
 */

import com.matthewddiaz.datastructures.heap.Heap;
import com.matthewddiaz.datastructures.heap.MaxHeap;

import java.util.List;

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
public class MaxPriorityQueue extends PriorityQueue{

    public MaxPriorityQueue(List<Comparable> list){
        super(list, new MaxHeap());
    }

    /**
     * Constructor that turns the input Comparable array to a maxHeap.
     * NOTE: Assumes that the array is full that is that
     * heapSize is equal to size that is (array.length - 1)
     * @param array
     */
    public MaxPriorityQueue(Comparable[] array) {
        super(array, new MaxHeap());
    }

    /**
     * Constructor that turns the input Comparable array to a maxHeap.
     * NOTE: User inputs the number of elements in the heap via the input variable numOfElementsInHeap
     * @param array
     * @param numOfElementsInHeap
     */
    public MaxPriorityQueue(Comparable[] array, int numOfElementsInHeap) throws Exception{
        super(array, new MaxHeap(), numOfElementsInHeap);
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
        return this.getHeapArray()[0];
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

        Comparable[] heapArray = this.getHeapArray();
        Heap heap = this.getHeap();

        Comparable maxElement = heapArray[0];
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
    public void insertElement(Comparable key) throws Exception {
        if(isFull()){
            throw new Exception("Max Priority Queue is full. Can't insert a new element");
        }

        Comparable[] heapArray = this.getHeapArray();
        Heap heap = this.getHeap();

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
        Comparable[] heapArray = this.getHeapArray();
        Heap heap = this.getHeap();

        if(index > heap.getHeapSize() || index < 0){
            throw new Exception("Index out of Bound");
        }

        /**
         * While index is not the root element (A[0]) and parent of element at index is less
         * than the element at index swap the two elements and set index equal to parent index.
         */
        while(index > 0 && (heapArray[index/2].compareTo(heapArray[index]) < 0)){
            swap(index/2, index);
            index = index/2;
        }
    }
}

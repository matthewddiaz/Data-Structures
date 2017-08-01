package com.matthewddiaz.datastructures.priorityQueues;

import com.matthewddiaz.datastructures.heap.MinHeap;

import java.util.List;

/**
 * Created by matthewdiaz on 7/31/17.
 */
public class MinPriorityQueue<T extends Comparable> extends PriorityQueue<T>{

    public MinPriorityQueue(List<T> list){
        super(list, new MinHeap());
    }

    /**
     * Constructor that turns the input Comparable array to a minHeap.
     * NOTE: Assumes that the array is full that is that
     * heapSize is equal to size that is (array.length - 1)
     * @param array
     */
    public MinPriorityQueue(T[] array) {
        super(array, new MinHeap());
    }

    /**
     * Constructor that turns the input Comparable array to a minHeap.
     * NOTE: User inputs the number of elements in the heap via the input variable numOfElementsInHeap
     * @param array
     * @param numOfElementsInHeap
     */
    public MinPriorityQueue(T[] array, int numOfElementsInHeap) throws Exception{
        super(array, new MinHeap(), numOfElementsInHeap);
    }

    /**
     *
     * @return the minimum element in the min priority queue. Note: Does not remove the element.
     */
    public T minimum(){
        return firstPriorityElement();
    }

    /**
     *
     * @return removes the minimum element 'e' from the min priority queue and returns 'e'
     * @throws Exception throws an exception if the priority queue is empty
     */
    public T extractMinimum() throws Exception {
        return extractFirstPriorityElement();
    }

    /**
     *
     * @param parentIndex
     * @param childIndex
     * @return
     */
    @Override
    protected boolean isChildHigherPriority(int parentIndex, int childIndex) {
        return compareValue(parentIndex, childIndex) > 0;
    }
}

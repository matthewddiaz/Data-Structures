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
 * inserting a key and removing the maximum key. However this MPQ may have been implemented using
 * another data structure.
 */
public class MaxPriorityQueue<T extends Comparable> extends PriorityQueue<T>{

    public MaxPriorityQueue(List<T> list){
        super(list, new MaxHeap());
    }

    /**
     * Constructor that turns the input Comparable array to a maxHeap.
     * NOTE: Assumes that the array is full that is that
     * heapSize is equal to size that is (array.length - 1)
     * @param array
     */
    public MaxPriorityQueue(T[] array) {
        super(array, new MaxHeap());
    }

    /**
     * Constructor that turns the input Comparable array to a maxHeap.
     * NOTE: User inputs the number of elements in the heap via the input variable numOfElementsInHeap
     * @param array
     * @param numOfElementsInHeap
     */
    public MaxPriorityQueue(T[] array, int numOfElementsInHeap) throws Exception{
        super(array, new MaxHeap(), numOfElementsInHeap);
    }

    /*
     * Returns the element with the max priority from heapArray
     *
     * Running Time: θ(1)
     */
    public T maximum(){
        return firstPriorityElement();
    }

    /**
     * Returns and removes the element with the max priority from heapArray
     *
     * Running Time: θ(lg(n))
     * @return
     * @throws Exception
     */
    public T extractMaximum() throws Exception {
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
        return compareValue(parentIndex, childIndex) < 0;
    }
}

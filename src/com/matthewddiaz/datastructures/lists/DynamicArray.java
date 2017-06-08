package com.matthewddiaz.datastructures.lists;

import com.matthewddiaz.designpatterns.behavioralPatterns.Iterator;

/**
 * Created by matthewdiaz on 6/7/17.
 */

/**
 * A Dynamic Array (aka: Array List) is a resize-able list data structure.
 * Any element in the dynamic array can be accessed via an index.
 * @param <E>
 */
public class DynamicArray<E> implements List<E> {
    //backing array used to contain the elements
    E[] backingArray;
    //size is the number of elements in the dynamic array
    int size;

    //default constructor. Creates a new Dynamic Array of size 10
    public DynamicArray(){
        backingArray =  (E[]) new Object[10];
        size = 0;
    }

    //Creates a new Dynamic Array with input array size
    public DynamicArray(int arraySize) throws IndexOutOfBoundsException{
        if(arraySize < 1){
            throw new IndexOutOfBoundsException();
        }

        backingArray =  (E[]) new Object[arraySize];
        size = 0;
    }

    @Override
    public void appendElement(E element) {
        //inserting element to back (index (size - 1)) of dynamic array.
        insertElement(element, this.size - 1);
    }

    @Override
    public boolean containsElement(E element) {
        //iterating over the backing array to find the first occurrence of E
        for(int index = 0; index < this.size; index++){
            if(backingArray[index] == element){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator createIterator() {
        return new Iterator() {
            private int index;

            @Override
            public void first() {
                index = 0;
            }

            @Override
            public Object currentElement() {
                return backingArray[index];
            }

            @Override
            public void next() {
                index++;
            }

            @Override
            public boolean isDone() {
                return index == size;
            }
        };
    }

    @Override
    public boolean deleteElement(E element) throws NullPointerException {
        //iterating the dynamic array to determine the index of the first occurrence of the input element
        for(int index = 0; index < this.size; index++){
            if(this.backingArray[index] == element){
                deleteElement(index);
                return true;
            }
        }

        //the input element is not in the dynamic array
        return false;
    }

    @Override
    public E deleteElement(int index) throws IndexOutOfBoundsException {
        //throw IndexOutOfBound if input index is negative or greater than or equal to size
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }

        E removedElement = this.backingArray[index];

        //shift all elements with the index range [index, size - 1] one to the left
        for(int currentIndex = index; currentIndex < this.size - 1; currentIndex++){
            this.backingArray[currentIndex] = this.backingArray[currentIndex + 1];
        }

        //decrement the size by 1
        this.size--;

        //check if the backing array needs to be shrunk
        if(shrinkThreshold()){
            shrinkBackingArray();
        }

        //return the element contained by the backing array at the input index
        return removedElement;
    }

    @Override
    public E getElement(int index) throws IndexOutOfBoundsException {
        //throw IndexOutOfBound if input index is negative or greater than or equal to size
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        //return element at the input index
        return this.backingArray[index];
    }

    @Override
    public void insertElement(E element, int index) throws IndexOutOfBoundsException {
        //throw IndexOutOfBound if input index is negative or greater than size
        if(index < 0 || index > this.size){
            throw new IndexOutOfBoundsException();
        }

        //if array is full resize before inserting element
        if(isFull()){
            growBackingArray();
        }

        //shift elements all elements with in the index range [(size - 1), index] one to the right
        //Note: the last element in the backing array is located at index (size - 1)
        for(int currentIndex = this.size - 1; currentIndex >= index; currentIndex--){
            backingArray[currentIndex + 1] = backingArray[currentIndex];
        }

        //set the value of the input index to element
        backingArray[index] = element;
        //increment the number of elements in the dynamic set by 1
        this.size++;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void prependElement(E element) {
        //inserting element to front (index 0) of dynamic array.
        insertElement(element, 0);
    }

    @Override
    public int size() {
        return this.size;
    }

    /**
     * Resize the backing array to be 1.5 times its original size
     */
    private void growBackingArray(){
        resizeBackingArray(this.size * (3/2));
    }

    /**
     * Returns true if the backing array is currently full
     * @return
     */
    private boolean isFull(){
        return (this.size == this.backingArray.length);
    }

    /**
     * Shrinks the backing array to be 2/3 the size of its original size
     */
    private void shrinkBackingArray(){
        resizeBackingArray(this.size * (2/3));
    }

    /**
     * Populates elements in backing array into a new resized temp backing array
     * This new resized temp backing array becomes the official backing array.
     * @param newSize
     */
    private void resizeBackingArray(int newSize){
        //allocating a new backing array with input size
        E[] tempBackingArray = (E[]) new Object[newSize];

        //must transfer all elements from backing array into the new array
        for(int index = 0; index < this.size; index++){
            tempBackingArray[index] = this.backingArray[index];
        }

        //set backing array equal to this new resized backing array
        this.backingArray = tempBackingArray;
    }

    /**
     * Returns true if size is less than the min threshold size for current backing array
     * NOTE: Will always return false if backing array is size 10. Dynamic array should not shrink
     * below size 10.
     * @return
     */
    private boolean shrinkThreshold(){
        return ((this.size < (this.backingArray.length * (1/3))) && (this.backingArray.length > 10));
    }
}

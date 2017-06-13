package com.matthewddiaz.datastructures.lists;

import com.matthewddiaz.designpatterns.behavioralPatterns.Iterator;

/**
 * Created by matthewdiaz on 6/7/17.
 */
public interface List<E> {

    /**
     * Inserts an element at the end of the list
     * @param element
     */
    void appendElement(E element);

    /**
     * Returns true if the element is in the list
     * @param element
     * @return
     */
    boolean containsElement(E element);

    /**
     * Creates and returns a new iterator of the list
     * @return
     */
    Iterator<E> createIterator();

    /**
     * Removes the element and returns true if E is in the list
     * @param element
     * @return
     * @throws NullPointerException
     */
    boolean removeElement(E element) throws NullPointerException;

    /**
     * Removes and returns the element from the list at the given index
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    E removeElement(int index) throws IndexOutOfBoundsException;

    /**
     * Returns element at index.
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    E getElement(int index) throws IndexOutOfBoundsException;

    /**
     * Inserts the element into the list at the given index
     * @param element
     * @param index
     * @throws IndexOutOfBoundsException
     */
    void insertElement(E element, int index) throws  IndexOutOfBoundsException;
    /**
     * Returns true if list is empty
     * @return
     */
    boolean isEmpty();

    /**
     * Inserts an element at the front of the list
     * @param element
     */
    void prependElement(E element);

    /**
     * Returns the number of elements in the list
     * @return
     */
    int size();

    /**
     * Returns a string representation of the list
     * @return
     */
    String toString();

    /**
     * Returns the input array with elements from the list; in the
     * same order as the linked list.
     * @param array
     * @return
     */
    public E[] toArray(E[] array);
}

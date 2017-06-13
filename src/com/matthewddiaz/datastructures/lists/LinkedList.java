package com.matthewddiaz.datastructures.lists;

import com.matthewddiaz.designpatterns.behavioralPatterns.Iterator;

/**
 * Created by matthewdiaz on 8/28/16.
 */
public class LinkedList<E> implements  List<E>{
    private Node<E> head;
    private Node<E> tail;
    private int numOfElements;

    public static class Node<E>{
        E element;
        Node<E> next;

        Node(E element){
            this.element = element;
            this.next = null;
        }

        public Node<E> getNext(){
            return this.next;
        }

        public void setNext(Node<E> next){
            this.next = next;
        }

        public E getElement(){
            return this.element;
        }
    }

    public LinkedList(){
        this.head = null;
        this.tail = this.head;
        this.numOfElements = 0;
    }

    /**
     * Removes the element from the list.
     * Returns true if the element was in the list
     * @param element
     * @return
     */
    @Override
    public boolean removeElement(E element) throws NullPointerException {
        //throws null pointer exception if input element is null
        if(element == null){
            throw new NullPointerException();
        }

        //if list is empty return false;
        if(isEmpty()){
            return false;
        }

        //current pointer will start at head
        Node currentPtr = this.head;
        //previous pointer will point to node before current
        Node previousPtr = null;

        while(currentPtr != null){
            if(currentPtr.element == element){
                //case when delete element is the first element in the linked list
                if(previousPtr == null){
                    removeFirst();
                }//case when delete element is the last element in the linked list
                else if(currentPtr.next == null){
                    tail = previousPtr;
                    tail.next = null;
                    this.numOfElements--;
                }else{
                    //removing current Node from the linked list. PreviousPtr next point to current's next Node
                    previousPtr.next = currentPtr.next;
                    this.numOfElements--;
                }
                return true;
            }
            //set previous equal to current
            previousPtr = currentPtr;
            //advance current to the next node
            currentPtr = currentPtr.next;
        }
        return false;
    }

    @Override
    public E removeElement(int index) throws IndexOutOfBoundsException {
        //Invalid input index if it is less than 0 or greater than (size - 1)
        if(index < 0 || index > (this.numOfElements  - 1)){
            throw  new IndexOutOfBoundsException();
        }

        //return null if linked list is empty
        if(isEmpty()){
            return null;
        }

        //if the index is 0; delete the first element in the list
        if(index == 0){
            return removeFirst();
        }//if the index is one less than the number of elements; delete the last element in the list
        else{
            boolean isLastIndex = (index == (this.numOfElements - 1)) ? true : false;

            //previous points to the first node in the list
            Node<E> previousPtr = this.head;
            //current points to second node in list
            Node<E> currentPtr = previousPtr.next;

            //advance current and previous by (index - 1) amount of nodes
            while(index > 1){
                previousPtr = currentPtr;
                currentPtr = currentPtr.next;
                //decrement count of index by 1
                index--;
            }

            if(isLastIndex){
                tail = previousPtr;
                tail.next = null;
            }else{
                //removing current Node from the linked list. PreviousPtr next point to current's next Node
                previousPtr.next = currentPtr.next;
            }

            //decrease the number of elements in the linked list
            this.numOfElements--;

            return currentPtr.element;
        }
    }

    /**
     * Returns and removes the first element in the linked list
     * @return
     */
    public E removeFirst(){
        E firstElement = this.head.element;
        this.head = this.head.next;
        //decrease the number of elements in the list
        this.numOfElements--;

        return firstElement;
    }

    /**
     * Returns and removes the last element in the linked list
     * NOTE: Takes O(n) time this operation would take O(1) in a doubly linked list
     * @return
     */
    public E removeLast(){
        E lastElement = this.tail.element;
        Node previous = null;
        Node currentPtr = this.head;

        //advance both current and previous pointer until current points to tail
        while(currentPtr != tail){
            previous = currentPtr;
            currentPtr = currentPtr.next;
        }

        //set tail equal to previous
        tail = previous;

        //decrease the number of elements in the list
        this.numOfElements--;
        return  lastElement;
    }

    @Override
    public E getElement(int index) throws IndexOutOfBoundsException {
        //Invalid input index if it is less than 0 or greater than (size - 1)
        if(index < 0 || index > (this.numOfElements  - 1)){
            throw  new IndexOutOfBoundsException();
        }

        //return null if linked list is empty
        if(isEmpty()){
            return null;
        }

        Node<E> currentPtr = this.head;
        //advance currentPtr by index amount of nodes
        while(index > 0){
            currentPtr = currentPtr.next;
            //decrement index count by 1
            index--;
        }

        return currentPtr.element;
    }

    @Override
    public void insertElement(E element, int index) throws IndexOutOfBoundsException {
        //Invalid input index if it is less than 0 or greater than size
        if(index < 0 || index > (this.numOfElements)){
            throw  new IndexOutOfBoundsException();
        }

        //if list is empty or index is 0 insert the element at the front of the list
        if(isEmpty() || index == 0){
            prependElement(element);
        }//if index is equal to the number of elements then insert the element at the end of the list
        else if(index == this.numOfElements){
            appendElement(element);
        }else{
            //point previous to head
            Node previousPtr = this.head;
            //point current pointer to second node in the list
            Node currentPtr = previousPtr.next;

            //advance current and previous by (index - 1) times
            //NOTE: currentPtr starts at the second Node in the list
            while(index > 1){
                previousPtr = currentPtr;
                currentPtr = currentPtr.next;
                index--;
            }

            //create a new Node for input element
            Node newNode = new Node(element);
            //set previous next pointer set to the new node
            previousPtr.next = newNode;
            //set new node's next pointer to current node
            newNode.next = currentPtr;
            //increment the number of elements in the linked list
            this.numOfElements++;
        }
    }

    /**
     * Prepends an element to the List
     * Sets head pointer to the newly created Node
     * @param element
     */
    @Override
    public void prependElement(E element){
        Node newNode = new Node(element);

        if(isEmpty()){
            addFirstNode(newNode);
        }else{
            newNode.next = this.head;
            this.head = newNode;
        }
        this.numOfElements++;
    }

    /**
     * Appends an element to the List
     * Sets tail pointer to the newly created Node
     * @param element
     */
    @Override
    public void appendElement(E element){
        Node newNode = new Node(element);

        if(isEmpty()){
            addFirstNode(newNode);
        }else{
            this.tail.next = newNode;
            this.tail = this.tail.next;
        }
        this.numOfElements++;
    }

    /**
     * Anytime the first node is added to an empty list
     * head and tail both point to it. This is to avoid
     * the problem of prepending or appending to null pointers.
     * @param node
     */
    private void addFirstNode(Node node){
        this.head = node;
        this.tail = this.head;
    }

    /**
     * Returns true if the element passed in
     * the parameter is in the list
     * @param element
     * @return
     */
    @Override
    public boolean containsElement(E element){
        boolean elementIsInList = false;
        if(isEmpty()){
            return elementIsInList;
        }

        Node temp = this.head;
        while(temp != null){
            if(temp.element == element){
                return !elementIsInList;
            }
            temp = temp.next;
        }

        return elementIsInList;
    }

    /**
     * Returns true if list is empty
     * @return
     */
    @Override
    public boolean isEmpty(){
        return head == null;
    }

    /**
     * Returns a Iterator of the List
     * @return
     */
    @Override
    public Iterator<E> createIterator(){
        return new Iterator<E>() {
            private Node currentPosition;

            @Override
            public void first() {
                currentPosition = head;
            }

            @Override
            public E currentElement() {
                return (E)currentPosition.element;
            }

            @Override
            public void next() {
                currentPosition = currentPosition.next;
            }

            @Override
            public boolean isDone() {
                return currentPosition == null;
            }
        };
    }

    /**
     * Returns an array containing all of the elements in this list
     * in order from head till end.
     * @return
     */
    public Object[] toArray(){
        Object[] arr = new Object[this.numOfElements];
        Iterator<E> iterator = createIterator();
        int currentIndex = 0;
        for(iterator.first(); !iterator.isDone(); iterator.next()){
            arr[currentIndex++] = iterator.currentElement();
        }
        return arr;
    }

    /**
     * Returns the input array with elements from the list; in the
     * same order as the linked list.
     * @param array
     * @return
     */
    public E[] toArray(E[] array){
        Iterator<E> iterator = createIterator();
        int currentIndex = 0;

        iterator.first();
        //break loop if iterator is done traversing the linked list
        //or currentIndex is greater than or equal to array.length
        while(!iterator.isDone() && currentIndex < array.length){
            array[currentIndex++] = iterator.currentElement();
            iterator.next();
        }
        return array;
    }

    /**
     * Returns the number of elements in the list
     * @return
     */
    public int size(){
        return this.numOfElements;
    }

    /**
     * Creating a new DisjointLinkedList that contains the data of the original Linked List in
     * reverse order.
     */
    public LinkedList<E> createReversedLinkedList(){
        //creating new DisjointLinkedList
        LinkedList<E> reversedLinkedList = new LinkedList();
        Iterator<E> iterator = this.createIterator();
        //iterating through the current DisjointLinkedList and prepending the
        //current element of the iterator to the new reversed DisjointLinkedList
        for(iterator.first(); !iterator.isDone(); iterator.next()){
            reversedLinkedList.prependElement(iterator.currentElement());
        }
        return reversedLinkedList;
    }

    /**
     * Returns a String of all of the elements in the linked list. In order from head to tail.
     * Format: [ obj1, obj2, obj3 ]
     * @return
     */
    @Override
    public String toString(){
        return toString(this.head);
    }

    /**
     * Returns pointer of first element in DisjointLinkedList (head)
     * @return
     */
    public Node getHead(){
        return this.head;
    }

    /**
     * Returns a String of all of the elements in the linked list pointed to by the head input node
     * In order from head to tail.
     * Format: [ obj1, obj2, obj3 ]
     * @param headPtr
     * @return
     */
    public static String toString(Node headPtr){
        if(headPtr == null){
            return "Empty Linked List";
        }

        StringBuffer linkedListStr = new StringBuffer("[ " + headPtr.element);
        Node currentPtr = headPtr.next;

        while(currentPtr != null){
            linkedListStr.append(", " + currentPtr.element);
            currentPtr = currentPtr.next;
        }

        linkedListStr.append(" ]");
        return linkedListStr.toString();
    }
}

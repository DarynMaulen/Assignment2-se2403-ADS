/**
 * Custom implementation of a dynamic array list.
 * Supports typical list operations such as add, remove, get, and sort.
 *
 * @param <T> the type of elements stored in the list
 */

import interfaces.MyList;

import java.util.Comparator;  // Used to compare elements for sorting
import java.util.Iterator;    // Used to provide iteration over list elements

public class MyArrayList<T> implements MyList<T> {
    private int size;              // Current number of elements in the list
    private Object[] elements;     // Array to store elements

    /**
     * Constructs a new MyArrayList with an initial capacity of 10.
     */
    public MyArrayList(){
        elements = new Object[10];
        size = 0;
    }

    /**
     * Ensures that there is enough capacity in the array.
     * Increases the capacity if the array is full.
     */
    private void ensureCapacity() {
        if (elements.length == size) {
            increaseCapacity();
        }
    }

    /**
     * Throws an exception if the list is empty.
     */
    private void checkEmpty() {
        if (size == 0) {
            throw new IllegalStateException("List is empty.");
        }
    }

    /**
     * Sorts the list using the given comparator.
     * Uses bubble sort algorithm.
     *
     * @param cmp the comparator used to compare elements
     */
    public void sort(Comparator<T> cmp) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (cmp.compare((T) elements[j], (T) elements[j+1]) > 0) {
                    T temp = (T) elements[j];
                    elements[j] = elements[j+1];
                    elements[j+1] = temp;
                }
            }
        }
    }

    /**
     * Converts the list to an array.
     *
     * @return a new array containing all elements of the list
     */
    public Object[] toArray(){
        Object[] result = new Object[size];
        for(int i = 0; i < size; i++){
            result[i] = elements[i];
        }
        return result;
    }

    /**
     * Returns the index of the first occurrence of the specified object.
     *
     * @param object the object to search for
     * @return the index of the object, or -1 if not found
     */
    public int indexOf(Object object){
        for(int i = 0; i < size; i++){
            if(elements[i].equals(object)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified object.
     *
     * @param object the object to search for
     * @return the index of the object, or -1 if not found
     */
    public int lastIndexOf(Object object){
        for(int i = size - 1; i >= 0; i--){
            if(elements[i].equals(object)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Checks if the list contains the specified object.
     *
     * @param object the object to check
     * @return true if found, false otherwise
     */
    public boolean exists(Object object){
        for(int i = 0; i < size; i++){
            if(elements[i].equals(object)){
                return true;
            }
        }
        return false;
    }

    /**
     * Replaces the element at the specified index with the given element.
     *
     * @param index   the index of the element to replace
     * @param element the new element
     */
    public void set(int index, T element){
        checkIndex(index);
        elements[index] = element;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to add
     */
    public void add(T element){
        ensureCapacity();
        elements[size++] = element;
    }

    /**
     * Inserts an element at the specified index.
     *
     * @param index   the position to insert at
     * @param element the element to insert
     */
    public void add(int index, T element){
        checkIndex(index);
        ensureCapacity();
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    /**
     * Adds an element to the beginning of the list.
     *
     * @param element the element to add
     */
    public void addFirst(T element){
        ensureCapacity();
        for(int i = size; i > 0; i--){
            elements[i] = elements[i - 1];
        }
        elements[0] = element;
        size++;
    }

    /**
     * Adds an element to the end of the list (same as add()).
     *
     * @param element the element to add
     */
    public void addLast(T element){
        ensureCapacity();
        elements[size++] = element;
    }

    /**
     * Doubles the capacity of the internal array.
     */
    private void increaseCapacity(){
        Object[] temp = new Object[size * 2];
        for(int i = 0; i < size; i++){
            temp[i] = elements[i];
        }
        elements = temp;
    }

    /**
     * Returns the element at the specified index.
     *
     * @param index the index to retrieve
     * @return the element at the specified index
     */
    public T get(int index){
        checkIndex(index);
        return (T) elements[index];
    }

    /**
     * Returns the first element in the list.
     *
     * @return the first element
     */
    public T getFirst(){
        checkEmpty();
        return (T) elements[0];
    }

    /**
     * Returns the last element in the list.
     *
     * @return the last element
     */
    public T getLast(){
        checkEmpty();
        return (T) elements[size - 1];
    }

    /**
     * Removes the last element from the list.
     */
    public void removeLast(){
        checkEmpty();
        size--;
    }

    /**
     * Removes the first element from the list.
     */
    public void removeFirst(){
        checkEmpty();
        for(int i = 0; i < size - 1; i++){
            elements[i] = elements[i + 1];
        }
        size--;
    }

    /**
     * Removes the element at the specified index.
     *
     * @param index the index to remove
     */
    public void remove(int index){
        checkIndex(index);
        for(int i = index; i < size - 1; i++){
            elements[i] = elements[i + 1];
        }
        size--;
    }

    /**
     * Checks if the index is valid.
     *
     * @param index the index to check
     * @throws IndexOutOfBoundsException if index is out of range
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " out of bounds. Size: " + size);
        }
    }

    /**
     * Removes all elements from the list.
     */
    public void clear(){
        for(int i = 0; i < size; i++){
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the size of the list
     */
    public int size(){
        return size;
    }

    /**
     * Returns an iterator over the elements in the list.
     *
     * @return an Iterator object
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    /**
     * Internal class to implement the Iterator interface.
     */
    private class MyIterator implements Iterator<T> {
        int cursor = 0;

        /**
         * Returns true if there are more elements to iterate over.
         *
         * @return true if not at the end of the list
         */
        @Override
        public boolean hasNext(){
            return cursor != size();
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return next element
         */
        @Override
        public T next(){
            T nextItem = get(cursor);
            cursor++;
            return nextItem;
        }
    }
}
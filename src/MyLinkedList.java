import interfaces.MyList;

import java.util.Comparator;
import java.util.Iterator;

/**
 * A custom doubly linked list implementation.
 *
 * @param <T> the type of elements in the list
 */
public class MyLinkedList<T> implements MyList<T> {
    private MyNode<T> head;  // First node of the list
    private MyNode<T> tail;  // Last node of the list
    private int size;        // Number of elements in the list

    /**
     * Sets the element at the specified index.
     *
     * @param index   index to update
     * @param element new value
     */
    @Override
    public void set(int index, T element) {
        checkIndex(index);
        MyNode<T> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        current.data = element;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param element element to add
     */
    @Override
    public void add(T element) {
        addLast(element);
    }

    /**
     * Adds an element at the specified index.
     *
     * @param index   index to insert at
     * @param element element to insert
     */
    @Override
    public void add(int index, T element) {
        checkIndex(index);

        if (index == 0) {
            addFirst(element);
            return;
        }
        if (index == size) {
            addLast(element);
            return;
        }

        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        MyNode<T> newNode = new MyNode<>(element);
        MyNode<T> prevNode = current.prev;

        newNode.next = current;
        newNode.prev = prevNode;

        if (prevNode != null) {
            prevNode.next = newNode;
        }
        current.prev = newNode;

        if (index == 0) {
            head = newNode;
        }
        size++;
    }

    /**
     * Adds an element at the beginning of the list.
     *
     * @param element element to add
     */
    @Override
    public void addFirst(T element) {
        MyNode<T> newNode = new MyNode<>(element);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        if (size == 0) {
            tail = newNode;
        }
        size++;
    }

    /**
     * Adds an element at the end of the list.
     *
     * @param element element to add
     */
    @Override
    public void addLast(T element) {
        MyNode<T> newNode = new MyNode<>(element);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * Returns the element at the given index.
     *
     * @param index index to retrieve
     * @return element at the index
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        MyNode<T> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }

    /**
     * Returns the first element in the list.
     *
     * @return first element or null if list is empty
     */
    @Override
    public T getFirst() {
        return head == null ? null : head.data;
    }

    /**
     * Returns the last element in the list.
     *
     * @return last element or null if list is empty
     */
    @Override
    public T getLast() {
        return tail == null ? null : tail.data;
    }

    /**
     * Removes the element at the given index.
     *
     * @param index index to remove
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        checkEmpty();

        if (index == 0) {
            removeFirst();
            return;
        }

        if (index == size - 1) {
            removeLast();
            return;
        }

        MyNode<T> toRemove = head;
        for (int i = 0; i < index; i++) {
            toRemove = toRemove.next;
        }

        MyNode<T> prevNode = toRemove.prev;
        MyNode<T> nextNode = toRemove.next;

        if (prevNode != null) prevNode.next = nextNode;
        if (nextNode != null) nextNode.prev = prevNode;

        size--;
    }

    /**
     * Removes the first element in the list.
     */
    @Override
    public void removeFirst() {
        checkEmpty();
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        if (--size == 0) {
            tail = null;
        }
    }

    /**
     * Removes the last element in the list.
     */
    @Override
    public void removeLast() {
        checkEmpty();

        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    /**
     * Sorts the list using the given comparator.
     * Uses bubble sort.
     *
     * @param cmp comparator to define order
     */
    @Override
    public void sort(Comparator<T> cmp) {
        boolean swapped;
        do {
            swapped = false;
            MyNode<T> current = head;
            while (current != null && current.next != null) {
                if (cmp.compare(current.data, current.next.data) > 0) {
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    /**
     * Checks if the list contains the given object.
     *
     * @param object object to search
     * @return true if exists, false otherwise
     */
    @Override
    public boolean exists(Object object) {
        MyNode<T> current = head;
        while (current != null) {
            if (current.data.equals(object)) return true;
            current = current.next;
        }
        return false;
    }

    /**
     * Returns the index of the first occurrence of the object.
     *
     * @param object object to find
     * @return index or -1 if not found
     */
    @Override
    public int indexOf(Object object) {
        checkEmpty();
        MyNode<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(object)) return i;
            current = current.next;
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the object.
     *
     * @param object object to find
     * @return index or -1 if not found
     */
    @Override
    public int lastIndexOf(Object object) {
        checkEmpty();
        MyNode<T> current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (current.data.equals(object)) return i;
            current = current.prev;
        }
        return -1;
    }

    /**
     * Returns the list as an array.
     *
     * @return array of elements
     */
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        MyNode<T> current = head;
        for (int i = 0; i < size; i++) {
            result[i] = current.data;
            current = current.next;
        }
        return result;
    }

    /**
     * Clears the list.
     */
    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over the elements in the list.
     *
     * @return iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    // ========== Helper Methods and Inner Classes ==========

    /**
     * Checks if the list is empty.
     */
    private boolean isEmpty() {
        return size == 0;
    }

    /**
     * Throws exception if list is empty.
     */
    private void checkEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("The list is empty.");
        }
    }

    /**
     * Validates the index.
     *
     * @param index index to check
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " out of bounds. Size: " + size);
        }
    }

    /**
     * Iterator implementation for the list.
     */
    private class MyIterator implements Iterator<T> {
        private MyNode<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = current.data;
            current = current.next;
            return data;
        }
    }
}
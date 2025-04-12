import interfaces.IMyQueue;
import interfaces.MyList;

/**
 * MyQueue is a generic queue implementation using a user-defined list.
 * It follows the First-In-First-Out (FIFO) principle.
 *
 * @param <T> the type of elements stored in the queue
 */
public class MyQueue<T> implements IMyQueue<T> {

    // The underlying list used to store queue elements
    private MyList<T> list;

    /**
     * Constructs a new queue using the given list implementation.
     * Can be based on MyArrayList or MyLinkedList.
     *
     * @param list the list implementation to use
     */
    public MyQueue(MyList<T> list){
        this.list = list;
    }

    /**
     * Checks whether the queue is empty.
     *
     * @return true if the queue contains no elements, false otherwise
     */
    @Override
    public boolean empty() {
        return list.size() == 0;
    }

    /**
     * Returns the number of elements currently in the queue.
     *
     * @return the size of the queue
     */
    @Override
    public int size() {
        return list.size(); // Return actual size
    }

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the front element
     */
    @Override
    public T peek() {
        return list.getFirst();
    }

    /**
     * Adds a new element to the end of the queue.
     *
     * @param newItem the element to enqueue
     * @return the enqueued element
     */
    @Override
    public T enqueue(T newItem) {
        list.addLast(newItem);
        return newItem;
    }

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the removed element
     */
    @Override
    public T dequeue() {
        T removingItem = peek();      // Get the front element
        list.removeFirst();           // Remove it from the list
        return removingItem;
    }
}

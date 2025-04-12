import interfaces.IMyStack;
import interfaces.MyList;

/**
 * MyStack is a generic stack implementation based on a user-defined list.
 * It follows the Last-In-First-Out (LIFO) principle.
 *
 * @param <T> the type of elements stored in the stack
 */
public class MyStack<T> implements IMyStack<T> {

    // The underlying list used to store stack elements
    private MyList<T> list;

    /**
     * Constructs a new stack using the given list implementation.
     * Can be based on MyArrayList or MyLinkedList.
     *
     * @param list the list implementation to use
     */
    public MyStack(MyList<T> list){
        this.list = list;
    }

    /**
     * Checks whether the stack is empty.
     *
     * @return true if the stack contains no elements, false otherwise
     */
    @Override
    public boolean empty() {
        return list.size() == 0;
    }

    /**
     * Returns the number of elements currently in the stack.
     *
     * @return the size of the stack
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return the top element
     */
    @Override
    public T peek() {
        return list.getLast();
    }

    /**
     * Pushes a new element onto the top of the stack.
     *
     * @param newItem the element to push
     * @return the pushed element
     */
    @Override
    public T push(T newItem) {
        list.addLast(newItem);
        return newItem;
    }

    /**
     * Removes and returns the top element from the stack.
     *
     * @return the removed element
     */
    @Override
    public T pop() {
        T removingItem = peek();     // Get the top element
        list.removeLast();           // Remove it from the list
        return removingItem;
    }
}

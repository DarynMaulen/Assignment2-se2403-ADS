import interfaces.IMyMinHeap;
import interfaces.MyList;
import java.util.Comparator;

/**
 * Min-Heap implementation using a custom list.
 * Stores elements in a binary heap structure using an array-like list.
 *
 * @param <T> the type of elements stored in the heap, must be Comparable
 */
public class MyMinHeap<T extends Comparable<T>> implements IMyMinHeap<T> {
    private MyList<T> list;

    /**
     * Constructs a MinHeap with the given list implementation.
     *
     * @param list the list to use as internal storage
     */
    public MyMinHeap(MyList<T> list){
        this.list = list;
    }

    /**
     * Checks if the heap is empty.
     *
     * @return true if the heap contains no elements
     */
    @Override
    public boolean empty() {
        return list.size() == 0;
    }

    /**
     * Returns the number of elements in the heap.
     *
     * @return the current size of the heap
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Inserts a new item into the heap and restores heap order.
     *
     * @param newItem the item to insert
     */
    @Override
    public void insert(T newItem) {
        list.addLast(newItem);
        int index = list.size() - 1;
        traverseUp(index);
    }

    /**
     * Returns the minimum element in the heap without removing it.
     *
     * @return the minimum element, or null if the heap is empty
     */
    @Override
    public T getMin() {
        if (checkNull()) return null;
        return list.get(0);
    }

    /**
     * Extracts and removes the minimum element from the heap.
     * After removal, reorders the heap to maintain the heap property.
     *
     * @return the minimum element, or null if the heap is empty
     */
    @Override
    public T extractMin() {
        T min = getMin();
        T last = list.get(list.size() - 1);
        list.set(0, last); // Move last element to root
        list.removeLast(); // Remove the duplicate at the end
        heapify(0); // Restore heap property
        return min;
    }

    /**
     * Restores the heap property going down from the given index.
     *
     * @param index the index to start heapifying from
     */
    private void heapify(int index){
        int size = list.size();
        while (true){
            int right = rightChildOf(index);
            int left = leftChildOf(index);
            int smallest = index;

            if (right < size && list.get(right).compareTo(list.get(smallest)) < 0) {
                smallest = right;
            }

            if (left < size && list.get(left).compareTo(list.get(smallest)) < 0) {
                smallest = left;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    /**
     * Moves the element at the given index up to restore the heap property.
     *
     * @param index the index to start from
     */
    private void traverseUp(int index){
        while(index > 0){
            int parentIndex = parentOf(index);
            T current = list.get(index);
            T parent = list.get(parentIndex);

            if (current.compareTo(parent) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    /**
     * Swaps two elements in the list.
     *
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(int i, int j){
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    /**
     * Returns the index of the parent of the given node.
     *
     * @param index the index of the child node
     * @return the index of the parent node
     */
    private int parentOf(int index){
        return (index - 1) / 2;
    }

    /**
     * Returns the index of the right child of the given node.
     *
     * @param index the index of the parent node
     * @return the index of the right child
     */
    private int rightChildOf(int index){
        return 2 * index + 2;
    }

    /**
     * Returns the index of the left child of the given node.
     *
     * @param index the index of the parent node
     * @return the index of the left child
     */
    private int leftChildOf(int index){
        return 2 * index + 1;
    }

    /**
     * Checks whether the heap is empty.
     *
     * @return true if the heap is empty
     */
    private boolean checkNull(){
        return list.size() == 0;
    }
}

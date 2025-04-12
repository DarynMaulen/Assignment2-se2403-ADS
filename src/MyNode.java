/**
 * A node of a doubly linked list.
 * Stores the data and links to the next and previous nodes.
 *
 * @param <E> the type of element stored in the node
 */
public class MyNode<E> {
    E data;             // The element stored in this node
    MyNode<E> next;     // Reference to the next node
    MyNode<E> prev;     // Reference to the previous node

    /**
     * Constructs a new node with the given data.
     *
     * @param data the data to store
     */
    public MyNode(E data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
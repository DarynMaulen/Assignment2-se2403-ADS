package interfaces;

public interface IMyMinHeap<T> {
    boolean empty();
    int size();
    T getMin();
    T extractMin();
    void insert(T newItem);
}
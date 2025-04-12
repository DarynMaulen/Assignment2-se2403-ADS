package interfaces;

public interface IMyQueue<T> {
    boolean empty();
    int size();
    T peek();
    T enqueue(T newItem);
    T dequeue();
}
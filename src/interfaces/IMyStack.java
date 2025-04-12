package interfaces;

public interface IMyStack <T>{
    boolean empty();
    int size();
    T peek();
    T push(T newItem);
    T pop();
}
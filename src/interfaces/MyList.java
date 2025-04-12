package interfaces;

import java.util.Comparator;

public interface MyList<T> extends Iterable<T> {
    void add(T element);
    void set(int index,T element);
    void add(int index,T element);
    void addFirst(T element);
    void addLast(T element);
    T get(int index);
    T getFirst();
    T getLast();
    void remove(int index);
    void removeLast();
    void removeFirst();
    void sort(Comparator<T> cmp);
    int indexOf(Object object);
    int lastIndexOf(Object object);
    boolean exists(Object object);
    public Object[] toArray();
    void clear();
    int size();
}
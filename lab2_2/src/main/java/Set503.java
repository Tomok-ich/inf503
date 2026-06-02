package src.main.java;

public interface Set503<T> extends Iterable<T> {
    int size();
    boolean isEmpty();
    void add(T value);
    boolean contains(T o);
    void remove(T o);
    void clear();
    Object[] toArray();
}
package ru.itis.inf503.lab2_2;

public interface Set503gen<T> {
    int size();

    boolean isEmpty();

    void add(T o);

    boolean contains(T o);

    void remove(T o);

    void clear();

    Object[] toArray();
}

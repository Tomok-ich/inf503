package src.main.java.ru.itis.inf503.lab2_2;

public interface List503<T> extends Iterable<T> {
    int size();
    boolean isEmpty();
    boolean contains(T o);
    void add(T o);
    void add(T o, int position);
    T remove(int position);
    void clear();
    T get(int position);
    Object[] toArray();
}


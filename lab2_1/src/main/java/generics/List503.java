package generics;

public interface List503<T> {

    int size();

    boolean isEmpty();

    boolean contains(T element);

    void add(T element);

    void add(int index, T element);

    T remove(int index);

    void clear();

    T get(int index);
    Object[] toArray();
}

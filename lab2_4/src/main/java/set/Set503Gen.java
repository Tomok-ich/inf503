package set;

public interface Set503Gen<T> {
    int size();
    boolean isEmpty();
    void add(T value);
    boolean contains(T o);
    void remove(T o);
    void clear();
    Object[] toArray();
}
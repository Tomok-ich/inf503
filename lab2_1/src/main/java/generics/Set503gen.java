package generics;

public interface Set503gen<T> {
    int size();
    boolean isEmpty();
    void add(T o);
    boolean contains(T o);
    void remove(T o);
    void clear();
    Object[] toArray();
}

/*

def <T> sum(T a,T b):
    return a + b

<Integer> sum(3, "5")

 */

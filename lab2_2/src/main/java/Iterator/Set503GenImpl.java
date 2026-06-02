package src.main.java.Iterator;


import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Set503GenImpl<T> implements Set503gen<T>, Iterable<T> {
    private Object[] set;
    private int size = 0;
    private int current = 0;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            public boolean hasNext() {
                return current < size;
            }

            public T next() {
                return (T)set[current++];
            }
        };
    }

    public Set503GenImpl() {
        this.set = new Object[3];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0) ? true : false;
    }

    @Override
    public void add(T o) {
        if (contains(o)) {
            return;
        }
        if (size == set.length) {
            Object[] temp = new Object[set.length * 2];
            for (int i = 0; i < size; i++) {
                temp[i] = set[i];
            }
            set = temp;
        }
        set[size++] = o;
    }

    @Override
    public boolean contains(T o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(set[i])) return true;
        }return false;
    }

    @Override
    public void remove(T o) {
        for (int i = 0; i < size; i++) {
            if (set[i].equals(o)) {
                if (i == size - 1) {
                    set[i] = null;
                } else {
                    for (int j = i; j < size - 1; j++) {
                        set[j] = set[j + 1];
                    }
                    set[size-1]=null;
                }
                size--;
                return;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public void clear() {
        set = new Object[set.length];
        size = 0;
    }

    @Override
    public Object[] toArray() {
        Object[] temp = new Object[size];
        System.arraycopy(set, 0, temp, 0, size);
        return temp;
    }

    public T[] toArray(T clazz) {
        T[] temp = (T[]) Array.newInstance(clazz.getClass(),size);
        System.arraycopy(set, 0, temp, 0, size);
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < set.length; i++) {
            sb.append(set[i]).append(", ");
        }
        return sb.toString();
    }
}
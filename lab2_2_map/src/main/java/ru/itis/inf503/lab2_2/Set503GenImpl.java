package src.main.java.ru.itis.inf503.lab2_2;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Set503GenImpl<T> implements Set503gen<T>, Iterable<T> {

    private Object[] set;
    private int size = 0;

    public Set503GenImpl() {
        this.set = new Object[3];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return (T) set[current++];
            }
        };
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(T o) {
        if (contains(o)) return;

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
            if (o == null) {
                if (set[i] == null) return true;
            } else {
                if (o.equals(set[i])) return true;
            }
        }
        return false;
    }

    @Override
    public void remove(T o) {
        for (int i = 0; i < size; i++) {
            if ((o == null && set[i] == null) || (o != null && o.equals(set[i]))) {

                for (int j = i; j < size - 1; j++) {
                    set[j] = set[j + 1];
                }

                set[--size] = null;
                return;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public void clear() {
        set = new Object[3];
        size = 0;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(set, 0, result, 0, size);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sb.append(set[i]);
            if (i < size - 1) sb.append(", ");
        }

        return sb.toString();
    }
}
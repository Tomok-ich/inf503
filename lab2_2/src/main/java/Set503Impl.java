package src.main.java;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Set503Impl<T> implements Set503<T> {
    private Object[] set;
    private int size;
    private int capacity = 3;

    public Set503Impl() {
        set = new Object[capacity];
        size = 0;
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public void add(T value) {
        if (contains(value)) return;
        if (size == capacity) {
            capacity *= 2;
            Object[] temp = new Object[capacity];
            System.arraycopy(set, 0, temp, 0, size);
            set = temp;
        }
        set[size++] = value;
    }

    @Override
    public boolean contains(T o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(set[i], o)) return true;
        }
        return false;
    }

    @Override
    public void remove(T o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(set[i], o)) {
                int numMoved = size - i - 1;
                if (numMoved > 0) {
                    System.arraycopy(set, i + 1, set, i, numMoved);
                }
                set[--size] = null;
                return;
            }
        }
        throw new NoSuchElementException("Элемент не найден");
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) set[i] = null;
        size = 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(set, size);
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(set, size, a.getClass());
        }
        System.arraycopy(set, 0, a, 0, size);
        if (a.length > size) a[size] = null;
        return a;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                @SuppressWarnings("unchecked")
                T result = (T) set[cursor++];
                return result;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(set[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
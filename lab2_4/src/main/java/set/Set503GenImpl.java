package set;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

//<T type, K key, V value>
public class Set503GenImpl<T> implements Set503Gen<T> {
    private int capacity = 3;
    private int currentSize = 0;
    private Object[] set;

    public Set503GenImpl() {
        this.set = new Object[capacity];
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public void add(T value) {
        if(contains(value)) {
            return;
        }
        if(size() == capacity) {
            capacity *=2;
            Object[] temp = new Object[capacity];
            for (int i = 0; i < size(); i++) {
                temp[i] = set[i];
            }
            set = temp;
        }
        set[currentSize++] = value;
    }

    @Override
    public boolean contains(T o) {
        for (int i = 0; i < size(); i++) {
            if(set[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(T o) {
        for (int i = 0; i < currentSize; i++) {
            if(set[i].equals(o)) {
                if(i == currentSize-1) {
                    set[i] = null;
                } else {
                    for (int j = i; j < currentSize-1; j++) {
                        set[j] = set[j+1];
                    }
                    set[currentSize-1] = null;
                }
                currentSize--;
                return;
            }
        }
        throw new NoSuchElementException("Элемент не был найден.");
    }

    @Override
    public void clear() {
        set = new Object[capacity];
        currentSize = 0;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[currentSize];
        System.arraycopy(set, 0, result, 0, currentSize);
        return result;
    }

    public T[] toArray(T classType) {
        T[] result = (T[]) Array.newInstance(classType.getClass(), currentSize);
        System.arraycopy(set, 0, result, 0, currentSize);
        return result;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < capacity; i++) {
            result.append(set[i] + ", ");
        }
        result.append("]");
        return result.toString();
    }
}
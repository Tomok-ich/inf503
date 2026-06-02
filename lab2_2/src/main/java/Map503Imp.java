package src.main.java;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Map503Imp<K, V> implements Map503<K, V> {

    private static class EntryImpl<K, V> implements Map503.Entry<K, V> {
        private final K key;
        private V value;

        EntryImpl(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() { return key; }

        @Override
        public V getValue() { return value; }

        @Override
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Map503.Entry)) return false;
            Map503.Entry<?, ?> other = (Map503.Entry<?, ?>) obj;
            return Objects.equals(key, other.getKey()) &&
                    Objects.equals(value, other.getValue());
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    private EntryImpl<K, V>[] entries;
    private int size;
    private int capacity = 3;

    @SuppressWarnings("unchecked")
    public Map503Imp() {
        entries = (EntryImpl<K, V>[]) new EntryImpl[capacity];
        size = 0;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(entries[i].getKey(), key)) return i;
        }
        return -1;
    }

    private void ensureCapacity() {
        if (size == entries.length) {
            capacity *= 2;
            @SuppressWarnings("unchecked")
            EntryImpl<K, V>[] newEntries = (EntryImpl<K, V>[]) new EntryImpl[capacity];
            System.arraycopy(entries, 0, newEntries, 0, size);
            entries = newEntries;
        }
    }

    @Override
    public void put(K key, V value) {
        int idx = indexOfKey(key);
        if (idx >= 0) {
            entries[idx].setValue(value);
        } else {
            ensureCapacity();
            entries[size++] = new EntryImpl<>(key, value);
        }
    }

    @Override
    public V get(K key) {
        int idx = indexOfKey(key);
        return idx >= 0 ? entries[idx].getValue() : null;
    }

    @Override
    public int size() { return size; }

    @Override
    public V remove(K key) {
        int idx = indexOfKey(key);
        if (idx < 0) return null;
        V old = entries[idx].getValue();
        int numMoved = size - idx - 1;
        if (numMoved > 0) {
            System.arraycopy(entries, idx + 1, entries, idx, numMoved);
        }
        entries[--size] = null;
        return old;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) entries[i] = null;
        size = 0;
    }

    @Override
    public Set503<Entry<K, V>> entrySet() {
        Set503Impl<Entry<K, V>> set = new Set503Impl<>();
        for (int i = 0; i < size; i++) {
            set.add(entries[i]);
        }
        return set;
    }

    @Override
    public Set503<K> keySet() {
        Set503Impl<K> set = new Set503Impl<>();
        for (int i = 0; i < size; i++) {
            set.add(entries[i].getKey());
        }
        return set;
    }

    @Override
    public List503<V> values() {
        ArrayList503<V> list = new ArrayList503<>();
        for (int i = 0; i < size; i++) {
            list.add(entries[i].getValue());
        }
        return list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < size; i++) {
            sb.append(entries[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }
}
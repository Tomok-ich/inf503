package src.main.java.ru.itis.inf503.lab2_2;

public class Map503Impl<K, V> implements Map503<K, V> {

    private Set503gen<Entry<K, V>> entries = new Set503GenImpl<>();

    private class EntryImpl implements Entry<K, V> {
        private K key;
        private V value;

        public EntryImpl(K key, V value) {
            this.key = key;
            this.value = value;
        }

        interface Entry<K, V> {
            K getKey();
            V getValue();
            void setValue(V value);
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (!(o instanceof Map503.Entry)) return false;

            Map503.Entry<?, ?> e = (Map503.Entry<?, ?>) o;

            return key.equals(e.getKey());
        }
    }

    @Override
    public void put(K key, V value) {

        for (Entry<K, V> e : entries) {
            if (e.getKey().equals(key)) {
                e.setValue(value);
                return;
            }
        }
        entries.add(new EntryImpl(key, value));
    }

    @Override
    public V get(K key) {
        for (Entry<K, V> e : entries) {
            if (e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return entries.size();
    }

    @Override
    public V remove(K key) {
        for (Entry<K, V> e : entries) {
            if (e.getKey().equals(key)) {
                V value = e.getValue();
                entries.remove(e);
                return value;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        entries.clear();
    }

    @Override
    public Set503gen<Entry<K, V>> entrySet() {
        return entries;
    }

    @Override
    public Set503gen<K> keySet() {
        Set503gen<K> keys = new Set503GenImpl<>();
        for (Entry<K, V> e : entries) {
            keys.add(e.getKey());
        }
        return keys;
    }

    @Override
    public List503<V> values() {
        List503<V> list = new List503Impl<>();
        for (Entry<K, V> e : entries) {
            list.add(e.getValue());
        }
        return list;
    }
}
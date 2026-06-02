package src.main.java;

public interface Map503<K, V> {
    interface Entry<K, V> {
        K getKey();
        V getValue();
        V setValue(V value);
    }

    void put(K key, V value);
    V get(K key);
    int size();
    V remove(K key);
    void clear();
    Set503<Entry<K, V>> entrySet();
    Set503<K> keySet();
    List503<V> values();
}
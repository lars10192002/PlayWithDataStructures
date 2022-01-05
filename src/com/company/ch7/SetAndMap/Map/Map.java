package com.company.ch7.SetAndMap.Map;

public interface Map<K,V> {
    void add(K key, V value);
    V remove();
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
    int getSize();
    boolean isEmpty();
}

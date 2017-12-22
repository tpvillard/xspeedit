package com.biffbangpow.xspeedit.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * A tree multi map.
 */
public class TreeMultimap<K, V> {

    private final TreeMap<K, List<V>> map = new TreeMap<>();

    /**
     * Returns the first element in the multimap for the key K
     * @param key the key
     * @return the first element in the multimap
     */
    public V get(K key) {
        List<V> list = map.get(key);
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * Put an element in the multimap at the specified key.
     * @param key the key
     * @param value the value
     */
    public void put(K key, V value) {
        List<V> list = map.get(key);
        if (list == null) {
            list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        } else {
            list.add(value);
        }
    }

    /**
     * Removes the mapping for this key and value from this map if present.
     * @param key the key
     * @param value the value
     * @return true if removed.
     */
    public boolean remove(K key, V value) {
        List<V> list = map.get(key);
        if (list != null) {
            if (list.remove(value)) {
                if (list.isEmpty()) {
                    map.remove(key);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the least key greater than or equal to the given key, or null if there is no such key.
     * @param key the key
     * @return the least key greater than or equal to key, or null if there is no such key
     */
    public K ceilingKey(K key) {
        return map.ceilingKey(key);
    }
}

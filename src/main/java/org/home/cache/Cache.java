package org.home.cache;

import java.util.HashMap;
import java.util.Map;

public class Cache<KEY, VALUE> {
    private final Map<KEY, VALUE> cache = new HashMap<>();

    public void put(KEY key, VALUE value) {
        cache.put(key, value);
    }

    public VALUE get(KEY key) {
        return cache.get(key);
    }
}

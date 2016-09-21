package org.home.cache;

import org.home.cache.clean.CleanCacheStrategy;

import java.util.HashMap;
import java.util.Map;

public class Cache<KEY, VALUE> {
    private final Map<KEY, VALUE> cache = new HashMap<>();
    private final CleanCacheStrategy<KEY> cleanCacheStrategy;
    private final int allowedSize;

    public Cache(CleanCacheStrategy<KEY> cleanCacheStrategy, int allowedSize) {
        this.cleanCacheStrategy = cleanCacheStrategy;
        this.allowedSize = allowedSize;
    }

    public void put(KEY key, VALUE value) {
        if (cache.size() == allowedSize) {
            cache.remove(cleanCacheStrategy.choosesToRemove());
        }

        cleanCacheStrategy.processesPutAction(key);
        cache.put(key, value);
    }

    public VALUE get(KEY key) {
        cleanCacheStrategy.processesGetAction(key);
        return cache.get(key);
    }
}

package org.home.cache.clean;

import java.util.HashMap;
import java.util.Map;

public class LessUsedElementCleanStrategy<KEY> implements CleanCacheStrategy<KEY> {
    private final Map<KEY, Integer> keyUsages = new HashMap<>();

    @Override
    public void processesPutAction(KEY key) {
        keyUsages.putIfAbsent(key, 0);
    }

    @Override
    public void processesGetAction(KEY key) {
        keyUsages.computeIfPresent(key, (currentKey, value) -> value + 1);
    }

    @Override
    public KEY choosesToRemove() {
        return keyUsages.entrySet().stream()
                        .sorted(Map.Entry.<KEY, Integer>comparingByValue())
                        .findFirst()
                        .orElseThrow(IllegalStateException::new)
                        .getKey();
    }
}

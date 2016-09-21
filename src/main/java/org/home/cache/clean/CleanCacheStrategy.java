package org.home.cache.clean;

public interface CleanCacheStrategy<KEY> {
    void processesPutAction(KEY key);

    void processesGetAction(KEY key);

    KEY choosesToRemove();
}

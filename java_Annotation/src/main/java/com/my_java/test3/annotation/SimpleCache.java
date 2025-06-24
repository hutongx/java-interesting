package com.my_java.test3.annotation;

import java.util.concurrent.*;

class CacheEntry {
    private final Object value;

    private final long timestamp;

    CacheEntry(Object v, long t) { this.value = v; this.timestamp = t; }

    public Object getValue() { return value; }

    public long getTimestamp() { return timestamp; }
}

/**
 * 简单线程安全的内存缓存
 */
public class SimpleCache {
    private final ConcurrentHashMap<String, CacheEntry> store = new ConcurrentHashMap<>();

    public Object get(String key) {
        CacheEntry e = store.get(key);
        return e != null ? e.getValue() : null;
    }

    public void put(String key, Object value) {
        store.put(key, new CacheEntry(value, System.currentTimeMillis()));
    }

    public void remove(String key) {
        store.remove(key);
    }

    public CacheEntry getEntry(String key) {
        return store.get(key);
    }
}


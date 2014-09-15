package org.lunivore.tyburn.threaded;


public interface QueuedMiniMap<K, V> {
    
    public void put(K key, V value);
    public V get(K key, long timeout) throws TimeoutException;
    public void remove(K key);
	public boolean has(K key);
}
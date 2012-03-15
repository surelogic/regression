package testBinder.typeSubOnTypeFormals;

import java.util.concurrent.ConcurrentMap;

public class ConcurrentCache<K, V> extends AbstractDelegatingCache<K, V> {
	public ConcurrentCache(ConcurrentMap<K, V> delegate, String name) {
		super(delegate, true);
		/*
		this.store = delegate;
		this.name = name;
		*/
	}
}

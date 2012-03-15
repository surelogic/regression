package testBinder.typeSubOnTypeFormals;

import java.util.Map;

public abstract class AbstractDelegatingCache<K, V> implements Cache<K, V> {
	public <D extends Map<K, V>> AbstractDelegatingCache(D delegate, boolean allowNullValues) {
		// Nothing to do
	}
}

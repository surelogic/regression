package testVertx;

public interface AsyncMap<K, V> {

	/**
	 * Get a value from the map, asynchronously.
	 *
	 * @param k  the key
	 * @param resultHandler - this will be called some time later with the async result.
	 */
	void get(K k, Handler<AsyncResult<V>> resultHandler);

	/**
	 * Put a value in the map, asynchronously.
	 *
	 * @param k  the key
	 * @param v  the value
	 * @param completionHandler - this will be called some time later to signify the value has been put
	 */
	void put(K k, V v, Handler<AsyncResult<Void>> completionHandler);
}

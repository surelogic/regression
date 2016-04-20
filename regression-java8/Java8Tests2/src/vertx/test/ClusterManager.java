package vertx.test;

import vertx.core.*;

public interface ClusterManager {
	<K, V> void getAsyncMultiMap(String name, Handler<AsyncResult<AsyncMultiMap<K, V>>> resultHandler);
}

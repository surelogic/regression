package vertx.test;

import vertx.core.*;

public class FakeClusterManager implements ClusterManager {
	@Override
	public <K, V> void getAsyncMultiMap(String name, Handler<AsyncResult<AsyncMultiMap<K, V>>> resultHandler) {		
	}
}

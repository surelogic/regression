package vertx.core;

public interface SharedData {
	/**
	 * Get the cluster wide map with the specified name. The map is accessible to all nodes in the cluster and data
	 * put into the map from any node is visible to to any other node.
	 *
	 * @param name  the name of the map
	 * @param resultHandler  the map will be returned asynchronously in this handler
	 */
	<K, V> void getClusterWideMap(String name, Handler<AsyncResult<AsyncMap<K, V>>> resultHandler);

}

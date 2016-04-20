package vertx.test;

public class VertxTestBase extends AsyncTestBase {
	protected Vertx vertx;
	protected Vertx[] vertices;

	protected ClusterManager getClusterManager() {
		return null;
	}

	protected void startNodes(int numNodes) {
	}
}

package vertx.test;

public interface VertxInternal extends Vertx {
	ClusterManager getClusterManager();
}

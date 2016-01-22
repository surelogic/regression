package testVertx;

public class ClusterWideMapTest extends VertxTestBase {
	protected Vertx getVertx() {
		return null;//vertices[0];
	}
	
	public void testMultipleMaps() {
		getVertx().sharedData().<String, String>getClusterWideMap("foo", onSuccess(map -> {
			map.put("foo", "bar", onSuccess(v -> {
				getVertx().sharedData().<String, String>getClusterWideMap("bar", onSuccess(map2 -> {
					map2.get("foo", onSuccess(res -> {
						assertNull(res);
						testComplete();
					}));
				}));
			}));
		}));
		await();
	}
}

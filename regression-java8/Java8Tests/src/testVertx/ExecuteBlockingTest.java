package testVertx;

public class ExecuteBlockingTest extends VertxTestBase {
	//@Test
	public void testExecuteBlockingSuccess() {
		vertx.executeBlocking(future -> {
			try {
				Thread.sleep(1000);
			} catch (Exception ignore) {
			}
			future.complete("done!");
		}, onSuccess(res -> {
			assertEquals("done!", res);
			testComplete();
		}));
		await();
	}
}

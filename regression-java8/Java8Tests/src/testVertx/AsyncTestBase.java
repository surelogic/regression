package testVertx;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class AsyncTestBase {
	protected void await() {
		await(2, TimeUnit.MINUTES);
	}

	public void await(long delay, TimeUnit timeUnit) {
		/*
		if (awaitCalled) {
			throw new IllegalStateException("await() already called");
		}
		awaitCalled = true;
		try {
			boolean ok = latch.await(delay, timeUnit);
			if (!ok) {
				// timed out
				throw new IllegalStateException("Timed out in waiting for test complete");
			} else {
				rethrowError();
			}
		} catch (InterruptedException e) {
			throw new IllegalStateException("Test thread was interrupted!");
		}
		 */
	}

	protected void testComplete() {		
	}
	
	protected void assertNull(Object object) {
		
	}
	
	protected void assertEquals(Object expected, Object actual) {
		/*
		checkThread();
		try {
			Assert.assertEquals(expected, actual);
		} catch (AssertionError e) {
			handleThrowable(e);
		}
		*/
	}

	protected void fail(String message) {
		/*
		checkThread();
		try {
			Assert.fail(message);
		} catch (AssertionError e) {
			handleThrowable(e);
		}
		 */
	}

	protected <T> Handler<AsyncResult<T>> onSuccess(Consumer<T> consumer) {
		return result -> {
			if (result.failed()) {
				result.cause().printStackTrace();
				fail(result.cause().getMessage());
			} else {
				consumer.accept(result.result());
			}
		};
	}
}

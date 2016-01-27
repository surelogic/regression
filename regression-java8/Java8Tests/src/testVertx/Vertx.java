package testVertx;

public interface Vertx {
	SharedData sharedData();

	/**
	 * Safely execute some blocking code.
	 * <p>
	 * Executes the blocking code in the handler {@code blockingCodeHandler} using a thread from the worker pool.
	 * <p>
	 * When the code is complete the handler {@code resultHandler} will be called with the result on the original context
	 * (e.g. on the original event loop of the caller).
	 * <p>
	 * A {@code Future} instance is passed into {@code blockingCodeHandler}. When the blocking code successfully completes,
	 * the handler should call the {@link Future#complete} or {@link Future#complete(Object)} method, or the {@link Future#fail}
	 * method if it failed.
	 *
	 * @param blockingCodeHandler  handler representing the blocking code to run
	 * @param resultHandler  handler that will be called when the blocking code is complete
	 * @param ordered  if true then if executeBlocking is called several times on the same context, the executions
	 *                 for that context will be executed serially, not in parallel. if false then they will be no ordering
	 *                 guarantees
	 * @param <T> the type of the result
	 */
	<T> void executeBlocking(Handler<Future<T>> blockingCodeHandler, boolean ordered, Handler<AsyncResult<T>> resultHandler);

	/**
	 * Like {@link #executeBlocking(Handler, boolean, Handler)} called with ordered = true.
	 */
	<T> void executeBlocking(Handler<Future<T>> blockingCodeHandler, Handler<AsyncResult<T>> resultHandler);

	FileSystem fileSystem();

	/**
	 * Set a one-shot timer to fire after {@code delay} milliseconds, at which point {@code handler} will be called with
	 * the id of the timer.
	 *
	 * @param delay  the delay in milliseconds, after which the timer will fire
	 * @param handler  the handler that will be called with the timer ID when the timer fires
	 * @return the unique ID of the timer
	 */
	long setTimer(long delay, Handler<Long> handler);
}

package testVertx;

public interface ContextInternal {
	/**
	 * Execute the context task and switch on this context if necessary, this also associates the
	 * current thread with the current context so {@link Vertx#currentContext()} returns this context.<p/>
	 *
	 * The caller thread should be the the event loop thread of this context.
	 *
	 * @param task the task to execute
	 */
	void executeFromIO(ContextTask task);
}

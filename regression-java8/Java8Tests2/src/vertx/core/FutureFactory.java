package vertx.core;

public interface FutureFactory {

	<T> Future<T> future();

	<T> Future<T> completedFuture();

	<T> Future<T> completedFuture(T result);

	<T> Future<T> completedFuture(Throwable t);

	<T> Future<T> completedFuture(String failureMessage, boolean failed);
}

package testVertx;

public interface Closeable {
	void close(Handler<AsyncResult<Void>> completionHandler);
}

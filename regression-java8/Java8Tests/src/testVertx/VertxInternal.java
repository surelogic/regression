package testVertx;

import java.io.File;

public interface VertxInternal extends Vertx {
	/**
	 * Get the current context
	 * @return the context
	 */
	ContextImpl getContext();	
	File resolveFile(String fileName);
	<T> void executeBlockingInternal(Action<T> action, Handler<AsyncResult<T>> resultHandler);	  
}

package vertx.core;

import vertx.core.buffer.Buffer;

public interface FileSystem {
	/**
	 * Blocking version of {@link #readFile(String, Handler)}
	 */
	Buffer readFileBlocking(String path) ;
}

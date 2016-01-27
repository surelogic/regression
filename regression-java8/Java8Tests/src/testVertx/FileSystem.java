package testVertx;

public interface FileSystem {
	/**
	 * Blocking version of {@link #readFile(String, Handler)}
	 */
	Buffer readFileBlocking(String path) ;
}

package vertx.core.buffer;

public interface Buffer {

	void appendInt(int length);

	void appendBytes(byte[] bytes);

	int getInt(int pos);

	String getString(int start, int i);

	static Buffer buffer(byte[] bytes) {
		return null;
	}
}

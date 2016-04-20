package vertx.json;

import vertx.core.buffer.Buffer;

public interface ClusterSerializable {
	  void writeToBuffer(Buffer buffer);

	  int readFromBuffer(int pos, Buffer buffer);
}
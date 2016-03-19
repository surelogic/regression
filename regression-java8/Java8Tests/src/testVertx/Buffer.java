package testVertx;

public interface Buffer {
	byte[] getBytes();
	
	  /**
	   * Returns a copy of a sub-sequence the Buffer as a {@code byte[]} starting at position {@code start}
	   * and ending at position {@code end - 1}
	   */
	  //@GenIgnore
	  byte[] getBytes(int start, int end);

	  /**
	   * Transfers the content of the Buffer into a {@code byte[]}.
	   *
	   * @param dst the destination byte array
	   * @throws IndexOutOfBoundsException if the content of the Buffer cannot fit into the destination byte array
	   */
	  //@GenIgnore
	  Buffer getBytes(byte[] dst);

	  /**
	   * Transfers the content of the Buffer into a {@code byte[]} at the specific destination.
	   *
	   * @param dst the destination byte array
	   * @throws IndexOutOfBoundsException if the content of the Buffer cannot fit into the destination byte array
	   */
	  //@GenIgnore
	  Buffer getBytes(byte[] dst, int dstIndex);

	  /**
	   * Transfers the content of the Buffer starting at position {@code start} and ending at position {@code end - 1}
	   * into a {@code byte[]}.
	   *
	   * @param dst the destination byte array
	   * @throws IndexOutOfBoundsException if the content of the Buffer cannot fit into the destination byte array
	   */
	  //@GenIgnore
	  Buffer getBytes(int start, int end, byte[] dst);

	  /**
	   * Transfers the content of the Buffer starting at position {@code start} and ending at position {@code end - 1}
	   * into a {@code byte[]} at the specific destination.
	   *
	   * @param dst the destination byte array
	   * @throws IndexOutOfBoundsException if the content of the Buffer cannot fit into the destination byte array
	   */
	  //@GenIgnore
	  Buffer getBytes(int start, int end, byte[] dst, int dstIndex);
}

package test;

public class Test2 {
	public void m(int f) {
		System.out.println("int");
	}

	public void m(byte b) {
		System.out.println("byte");
	}

	public void test(boolean f, int i, byte b) {
		m(f ? b : 5); // byte
		m(f ? b : (5 + 5)); // byte
	}

	public static void main(String[] args) {
		new Test2().test(true, 10, (byte) 5);
	}
}
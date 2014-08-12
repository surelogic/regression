package test;

public class Test {
	public void m1(final NoModels x) {
		synchronized (x) {
			// do stuff
		}
	}

	public void m2(final OneModel x) {
		synchronized (x) {
			// do stuff
		}
	}

	public void m3(final TwoModels x) {
		synchronized (x) {
			// do stuff
		}
	}
}

package testBinder.numericPromotion;

public class TestPromotion {
	float foo(int i, float f2) {
		return bar(-Math.signum(i) * f2);
	}

	private float bar(float f) {
		return -f;
	}
}

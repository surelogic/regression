package testBinder.shadowing;

public class Sub extends Super {
	static Sub shadow() {
		return null;
	}
	
	void sub() {		
	}
}

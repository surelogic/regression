package testBinder.rawOuterTypes;

public class Test {	
	void foo() {
		Outer o = new Outer();
		Outer.Inner i = o.new Inner();
	}
}

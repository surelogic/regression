package test;

import com.surelogic.Borrowed;

public class A {
	// Should link this Borrowed to the Borrowed on the super constructor
	@Borrowed("this")
	public A() {
		super();
	}
}


class B extends A {
	// Should link this Borrowed to the Borrowed on the super constructor
	@Borrowed("this")
	public B() {
		super(); // bad
	}
	
	@Borrowed("this")
	public void foo() {}
	
	// Should link this Borrowed to the Borrowed on foo()
	@Borrowed("this") 
	public void bar() {
		foo();
	}
	
	// Should link the Borrowed on 'b' to the Borrowed on foo()
	public static void xxx(@Borrowed B b) {
		b.foo();
	}
}
package testBinder.methodOnlyInACE;

public class TestAnonClassMethods {
	void foo() {
		new Object() {
			void bar() {				
			}
 		}.bar();
	}
}

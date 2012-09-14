package testBinder.localTypeInACE;

public class Test {
	public static class Inner {
		Outer foo() {
			return new Outer() {
				public void bar() {
					class Visitor {
						
					}
					Visitor v = new Visitor();
					v.toString();
				}	
			};
		}
	}
}

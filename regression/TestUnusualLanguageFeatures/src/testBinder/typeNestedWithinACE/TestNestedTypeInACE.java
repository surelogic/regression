package testBinder.typeNestedWithinACE;

public class TestNestedTypeInACE {
	Runnable get() {
		return new Runnable() {
			public void run() {
				// Use the nested class declared below
				new Nested();
			}	
			
			class Nested {
				// Nothing to do
			}
		};
	}
}

package testIDecls;

import com.surelogic.*;

public class TestIDecls {
	Runnable test() {
		return () -> {
			abstract class Test {
				@Starts("nothing") 
				abstract void foo();
			}
			new Test() {
				@Starts("nothing") 
				public void foo() {
					// Nothing to do
				}
			}.foo();
		};
	}
}

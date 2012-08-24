package testBinder.boxing;

import java.util.List;

public class TestBoxing {
	void foo(int i) {
		
	}
	
	List<? extends Integer> l = null;
	
	void bar() {
		foo(l.get(0));
	}
}

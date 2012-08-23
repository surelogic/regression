package testBinder.overloading;

import java.util.*;

class Super {
	Super get() { 
		return null; 
	}
}

public class TestOverloading {
	List<String> strings = null;
	
	TestOverloading get(Object... args) { 
		return null;
	}
	
	void testVarargs() {
        get().testBoxing();
    }

    void testBoxing() {
        strings.remove(0).charAt(0);
    }
	
	static <T> void staticMethod(T arg) {
		// Nothing to do
	}
	
	public static void main(String[] args) {
		staticMethod(true);
	}
}

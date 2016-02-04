package test;

import com.surelogic.Borrowed;
import com.surelogic.RegionLock;

@RegionLock("L is class protects Static")
class TestStatic {
	private static int s;
	
	@Borrowed("this")
	public TestStatic(int v) {
		s = v; // bad
		
		synchronized (TestStatic.class){
			s = 0; // good
		}
	}
	
	public TestStatic() {
		s = 100; // bad, should propose @Unique("return")
		
		synchronized (TestStatic.class) {
			s = 1000; // good
		}
	}
	
	static {
		s = 10000;
	}
	
	public void good() {
		synchronized (TestStatic.class) { 
			s = 10; // good
		}
	}
	
	public void bad() {
		s = 11; // bad, should propose @RequiresLock
	}
}


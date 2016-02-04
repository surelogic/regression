package test;

import com.surelogic.Borrowed;
import com.surelogic.RegionLock;

@RegionLock("L is this protects Instance")
class Test {
	private int f;
	
	@Borrowed("this")
	public Test(int v) {
		f = v; // good
	}
	
	public Test() {
		f = 100; // bad, should propose @Unique("return")
	}
	
	{
		f = 1000;
	}
	
	public synchronized void good() {
		f = 10; // good
	}
	
	public void bad() {
		f = 11; // bad, should propose @RequiresLock
	}
}


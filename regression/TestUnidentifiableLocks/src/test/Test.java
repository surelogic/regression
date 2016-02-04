package test;

import com.surelogic.PolicyLock;
import com.surelogic.RegionLock;

class Test {
	public static synchronized void staticMethod() {}
	
	public synchronized void method() {}
	
	public void doStuff() {
		synchronized (this) {
			// foo
		}
		synchronized (Test.class) {
			// foo
		}
	}
}

@RegionLock("L is this protects Instance")
class Test2 {
	public synchronized void method() {}
	
	public void doStuff() {
		synchronized (this) {
			// foo
		}
	}
}

@RegionLock("L is class protects Static")
class Test3 {
	public static synchronized void method() {}
	
	public void doStuff() {
		synchronized (Test3.class) {
			// foo
		}
	}
}

@PolicyLock("L is this")
class Test4 {
	public synchronized void method() {}
	
	public void doStuff() {
		synchronized (this) {
			// foo
		}
	}
}

@PolicyLock("L is class")
class Test5 {
	public static synchronized void method() {}
	
	public void doStuff() {
		synchronized (Test5.class) {
			// foo
		}
	}
}

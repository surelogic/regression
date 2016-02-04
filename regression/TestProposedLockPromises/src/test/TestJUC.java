package test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.surelogic.Borrowed;
import com.surelogic.RegionLock;

@RegionLock("L is lock protects Instance")
class TestJUC {
	public final Lock lock = new ReentrantLock();
	
	private int f;
	
	@Borrowed("this")
	public TestJUC(int v) {
		f = v; // good
	}
	
	public TestJUC() {
		f = 100; // bad, should propose @Unique("return")
	}
	
	public void good() {
		lock.lock();
		try {
			f = 10; // good
		} finally {
			lock.unlock();
		}
	}
	
	public void bad() {
		f = 11; // bad, should propose @RequiresLock
	}
}


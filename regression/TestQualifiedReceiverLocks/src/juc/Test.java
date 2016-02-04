package juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.surelogic.Region;
import com.surelogic.RegionLock;
import com.surelogic.ReturnsLock;

public class Test {
	private final Lock l2 = new ReentrantLock();

	@RegionLock("I2 is Test.this.l2 protects I2")
	@Region("public I2")
	public class Inner {
		@ReturnsLock("I2")
		public Object getI2_good() {
			return l2;
		}
		
		@ReturnsLock("I2")
		public Object getI3_bad() {
			return Other.o1;
		}
	}
}


class Other {
	public static final Lock o1 = new ReentrantLock();
}
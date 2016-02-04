package rw;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.surelogic.Region;
import com.surelogic.RegionLock;
import com.surelogic.ReturnsLock;

public class Test {
	private final ReadWriteLock l2 = new ReentrantReadWriteLock();

	
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
	public static final ReadWriteLock o1 = new ReentrantReadWriteLock();
}
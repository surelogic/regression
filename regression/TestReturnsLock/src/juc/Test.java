package juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.surelogic.Region;
import com.surelogic.RegionLock;
import com.surelogic.RegionLocks;
import com.surelogic.Regions;
import com.surelogic.ReturnsLock;

@RegionLocks({
	@RegionLock("L2 is l2 protects R2"),
	@RegionLock("L3 is l3 protects R3"),
	
	@RegionLock("S2 is s2 protects S2"),
	@RegionLock("S3 is s3 protects S3"),
	@RegionLock("S4 is Other.o1 protects S4"),
})
@Regions({
	@Region("public R1"),
	@Region("public R2"),
	@Region("public R3"),

	@Region("public static S1"),
	@Region("public static S2"),
	@Region("public static S3"),
	@Region("public static S4"),
	@Region("public static S5")
})
public class Test {
	private final Lock l2 = new ReentrantLock();
	private final Lock l3 = new ReentrantLock();
	private final Lock other = new ReentrantLock();
	
	private final static Lock s2 = new ReentrantLock();
	private final static Lock s3 = new ReentrantLock();

	
	@ReturnsLock("L2")
	public Object getL2_good() {
		return l2;
	}
	
	@ReturnsLock("L2")
	public Object getL2_bad() {
		return l3;
	}
	
	// -------
	
	@ReturnsLock("L3")
	public Object getL3_good() {
		return l3;
	}
	
	@ReturnsLock("L3")
	public Object getL3_bad() {
		return other;
	}
	
	// -------
	
	@ReturnsLock("S2")
	public static Object getS2_good() {
		return s2;
	}
	
	@ReturnsLock("S2")
	public static Object getS2_bad() {
		return s3;
	}
	
	// -------

	@ReturnsLock("S3")
	public static Object getS3_good() {
		return s3;
	}
	
	@ReturnsLock("S3")
	public static Object getS3_bad() {
		return Other.o1;
	}
	
	// -------

	@ReturnsLock("S4")
	public static Object getS4_good() {
		return Other.o1;
	}
	
	@ReturnsLock("S4")
	public static Object getS4_bad() {
		return Other.class;
	}

	// -------
	
	

	
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
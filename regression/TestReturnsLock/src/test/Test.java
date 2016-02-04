package test;

import com.surelogic.Region;
import com.surelogic.RegionLock;
import com.surelogic.RegionLocks;
import com.surelogic.Regions;
import com.surelogic.ReturnsLock;

@RegionLocks({
	@RegionLock("L1 is this protects R1"),
	@RegionLock("L2 is l2 protects R2"),
	@RegionLock("L3 is l3 protects R3"),
	
	@RegionLock("S1 is class protects S1"),
	@RegionLock("S2 is s2 protects S2"),
	@RegionLock("S3 is s3 protects S3"),
	@RegionLock("S4 is Other.o1 protects S4"),
	@RegionLock("S5 is Other.class protects S5")
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
	private final Object l2 = new Object();
	private final Object l3 = new Object();
	private final Object other = new Object();
	
	private final static Object s2 = new Object();
	private final static Object s3 = new Object();
	private final static Object zzz = new Object();
	
	@ReturnsLock("L1")
	public Object getL1_good() {
		return this;
	}
	
	@ReturnsLock("L1")
	public Object getL1_bad() {
		return l2;
	}
	
	// -------
	
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
	
	@ReturnsLock("S1")
	public static Object getS1_good() {
		return Test.class;
	}
	
	@ReturnsLock("S1")
	public static Object getS1_bad() {
		return zzz;
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

	@ReturnsLock("S5")
	public static Object getS5_good() {
		return Other.class;
	}
	
	@ReturnsLock("S5")
	public static Object getS5_bad() {
		return Other.o1;
	}
	
	// -------
	
	

	
	@RegionLocks({
		@RegionLock("I1 is Test.this protects I1"),
		@RegionLock("I2 is Test.this.l2 protects I2")
	})
	@Regions({
		@Region("public I1"),
		@Region("public I2")
	})
	public class Inner {
		@ReturnsLock("I1")
		public Object getI1_good() {
			return Test.this;
		}
		
		@ReturnsLock("I1")
		public Object getI1_bad() {
			return this;
		}
		
		// ---
		
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
	public static final Object o1 = new Object();
}

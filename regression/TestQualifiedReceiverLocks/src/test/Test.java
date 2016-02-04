package test;

import com.surelogic.InRegion;
import com.surelogic.Region;
import com.surelogic.RegionLock;
import com.surelogic.RegionLocks;
import com.surelogic.Regions;
import com.surelogic.ReturnsLock;

public class Test {
	private final Object l2 = new Object();

	@RegionLocks({
		@RegionLock("I1 is Test.this protects I1"),
		@RegionLock("I2 is Test.this.l2 protects I2")
	})
	@Regions({
		@Region("public I1"),
		@Region("public I2")
	})
	public class Inner {
		@InRegion("I1")
		private int f;
		
		
		public void doStuff() {
			f = 10; // bad
			
			synchronized (Test.this) {
				f = 11; // good
			}
			
			synchronized (getI1_good()) {
				f = 12; // good
			}
		}
		
		
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
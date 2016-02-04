package test;

import com.surelogic.PolicyLock;
import com.surelogic.PolicyLocks;
import com.surelogic.Region;
import com.surelogic.RegionLock;
import com.surelogic.RegionLocks;
import com.surelogic.Regions;
import com.surelogic.RequiresLock;

@Regions({
	@Region("public R1"),
	@Region("public R2")
})
@RegionLocks({
	@RegionLock("L1 is this protects R1"),
	@RegionLock("L2 is lock protects R2")
})
public class Test {
	public final Object lock = new Object();
	
	public synchronized void method1() {
		synchronized (this) {} // redundant
		synchronized (lock) {} // okay
	}
	
	@RequiresLock("L1")
	public void method2() {
		synchronized (this) {} // redundant
		synchronized (lock) {} // okay
	}
	
	public void method3() {
		synchronized (this) {
			synchronized (this) {} // redundant
			synchronized (lock) {} // okay
		}
	}
	
	@RequiresLock("L2")
	public void method4() {
		synchronized (this) {} // okay
		synchronized (lock) {} // redundant
	}
	
	public void method5() {
		synchronized (lock) {
			synchronized (this) {} // okay
			synchronized (lock) {} // redundant
		}
	}
}

@PolicyLocks({
	@PolicyLock("P1 is this"),
	@PolicyLock("P2 is lock")
})
class Test2 {
	public final Object lock = new Object();
	
	public synchronized void method1() {
		synchronized (this) {} // redundant
		synchronized (lock) {} // okay
	}
	
	@RequiresLock("P1")
	public void method2() {
		synchronized (this) {} // redundant
		synchronized (lock) {} // okay
	}
	
	public void method3() {
		synchronized (this) {
			synchronized (this) {} // redundant
			synchronized (lock) {} // okay
		}
	}
	
	@RequiresLock("P2")
	public void method4() {
		synchronized (this) {} // okay
		synchronized (lock) {} // redundant
	}
	
	public void method5() {
		synchronized (lock) {
			synchronized (this) {} // okay
			synchronized (lock) {} // redundant
		}
	}
}

@Regions({
	@Region("public static R1"),
	@Region("public static R2")
})
@RegionLocks({
	@RegionLock("L1 is class protects R1"),
	@RegionLock("L2 is lock protects R2")
})
class Test3 {
	public static final Object lock = new Object();
	
	public static synchronized void method1() {
		synchronized (Test3.class) {} // redundant
		synchronized (lock) {} // okay
	}
	
	@RequiresLock("L1")
	public static void method2() {
		synchronized (Test3.class) {} // redundant
		synchronized (lock) {} // okay
	}
	
	public static void method3() {
		synchronized (Test3.class) {
			synchronized (Test3.class) {} // redundant
			synchronized (lock) {} // okay
		}
	}
	
	@RequiresLock("L2")
	public static void method4() {
		synchronized (Test3.class) {} // okay
		synchronized (lock) {} // redundant
	}
	
	public static void method5() {
		synchronized (lock) {
			synchronized (Test3.class) {} // okay
			synchronized (lock) {} // redundant
		}
	}
}

@PolicyLocks({
	@PolicyLock("P1 is class"),
	@PolicyLock("P2 is lock")
})
class Test4 {
	public static final Object lock = new Object();
	
	public static synchronized void method1() {
		synchronized (Test4.class) {} // redundant
		synchronized (lock) {} // okay
	}
	
	@RequiresLock("P1")
	public static void method2() {
		synchronized (Test4.class) {} // redundant
		synchronized (lock) {} // okay
	}
	
	public static void method3() {
		synchronized (Test4.class) {
			synchronized (Test3.class) {} // redundant
			synchronized (lock) {} // okay
		}
	}
	
	@RequiresLock("P2")
	public static void method4() {
		synchronized (Test4.class) {} // okay
		synchronized (lock) {} // redundant
	}
	
	public static void method5() {
		synchronized (lock) {
			synchronized (Test4.class) {} // okay
			synchronized (lock) {} // redundant
		}
	}
}

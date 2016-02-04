package test;

import com.surelogic.Immutable;
import com.surelogic.RegionLock;
import com.surelogic.ThreadSafe;
import com.surelogic.Unique;

@RegionLock("Lock is this protects Instance")
public class Test<
		C1 extends Bad,
		C2 extends ImmutableClass,
		C3 extends ThreadSafeClass,
		C4 extends Locked,
		C5 extends Bad & AlsoBad,
		C6 extends ImmutableClass & AlsoBad,
		C7 extends ThreadSafeClass & AlsoBad,
		C8 extends Locked & AlsoBad> {
	// Not final, volatile, unique, or lock-protected
	private Bad bad1a;
	private C1 bad1b;
	private C5 bad1c;
	
	// immutable class
	private ImmutableClass good1a;
	private C2 good1b;
	private C6 good1c;
	
	// thread-safe class
	private ThreadSafeClass good2a;
	private C3 good2b;
	private C7 good2c;
	
	// Lock-protected class
	private Locked good3a;
	private C4 good3b;
	private C8 good3c;
	
	
	
	// ==== @Unique ====
	
	private @Unique Bad good10a;
	private @Unique C1 good10b;
	private @Unique C4 good10c;
	
	// ==== final ====
	
	private final Bad bad4a = new Bad();
	private volatile Bad bad4b = new Bad();

	// field is not lock-protected, so it isn't going to be accessed concurrently
	private static Bad good100;
	
	
	
	public void doStuff() {
		bad1a.method();
		bad1b.method();
		bad1c.method();

		good1a.method();
		good1b.method();
		good1c.method();

		good2a.method();
		good2b.method();
		good2c.method();

		good3a.method();
		good3b.method();
		good3c.method();

		good10a.method();
		good10b.method();
		good10c.method();
		
		bad4a.method();
		bad4b.method();
		
		good100.method();
	}
}

// Not immutable or threadsafe, and doesn't have locks
class Bad {
	public void method() {}
}

interface AlsoBad {}

@Immutable
class ImmutableClass {
	public void method() {}
}

@ThreadSafe
class ThreadSafeClass {
	public void method() {}
}

@RegionLock("LLL is this protects Instance")
class Locked {
	public void method() {}
}




class Test2 {
	private final Bad good8 = new Bad();
	private volatile Bad good9 = new Bad();

	public void doStuff() {
		good8.method(); // okay because Test2 isn't concurrent
		good9.method();
	}
}

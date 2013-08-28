package test;

import java.util.*;

import com.surelogic.*;

public class BrokenTest {
	@GuardedBy("this")
	static int foo;
	
	@GuardedBy("unknown")
	int bar;
	
	@GuardedBy("map")
	static int bar2;
	
	@GuardedBy("sLock")
	int bar3;
	
	@GuardedBy("map")
	final int bar4 = 0;
	
	static final Object sLock = new Object();
	
	@GuardedBy("Inner.class")
	static int baz;
	
	@GuardedBy("itself")
	boolean flag;
	
	final Map<String,String> map = new HashMap<String,String>();

	synchronized void incrFoo() {
		foo++;
	}
	
	String lookup(String key) {
		synchronized (map) {
			bar++;
			return map.get(key);
		}
	}
	
	class Inner {					
		@GuardedBy("Test.this") // Not an outer class!
		boolean nonsensical; 
		
		// Rejected by the lock sanity checks
		@GuardedBy("BrokenTest.this" /* is UNASSOCIATED */) 
		int count;
	}
}

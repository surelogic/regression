package test;

import java.util.*;

import com.surelogic.*;

public class Test {
	@GuardedBy("this")
	int foo;
	
	@GuardedBy("map")
	int bar;
	
	@GuardedBy("map")
	Object o;
	
	@GuardedBy("map")
	final String s = "";
	
	@GuardedBy("Test.Inner.class")
	static int baz;	
	
	@GuardedBy("itself")
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
		
	}
	
	@GuardedBy("this") 
	int getFoo() {
		return foo;
	}
	
	@GuardedBy("map")
	int getBar() {
		return bar;
	}
	
	@GuardedBy("Test.Inner.class") 
	static int getBaz() {
		return baz;
	}
}

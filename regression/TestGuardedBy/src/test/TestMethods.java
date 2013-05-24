package test;

import java.util.HashMap;
import java.util.Map;

import com.surelogic.*;

public class TestMethods {
	int foo;
	
	int bar;
	
	static int baz;	
	
	final Map<String,String> map = new HashMap<String,String>();
	
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

package test;

import java.io.Serializable;

import com.surelogic.Assume;

@Assume("@ReferenceObject for Class")
public class TestAssume {
	Class<?> c;
	
	@Assume("@Utility for java.lang.Object")
	Object foo;
	
	@Assume("@Immutable for java.io.Serializable")
	TestAssume(Serializable s) {		
	}
	
	@Assume("@Containable for java.lang.String")
	String bar() {		
		return null;
	}
}

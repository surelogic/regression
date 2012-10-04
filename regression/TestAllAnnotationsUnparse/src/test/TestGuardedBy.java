package test;

import java.util.*;

import com.surelogic.GuardedBy;

public class TestGuardedBy {
	@GuardedBy("this")
	double xPos = 1.0;
	
	@GuardedBy("this")
	double yPos = 1.0;
	
	@GuardedBy("itself")
	final List<Object> memo = new ArrayList<Object>();
	
	@GuardedBy("memo")
	Object bar;
	
	@GuardedBy("test.TestGuardedBy")
	static Object foo;
}

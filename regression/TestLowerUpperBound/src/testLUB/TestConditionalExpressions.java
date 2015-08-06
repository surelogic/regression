package testLUB;

import java.util.*;

public class TestConditionalExpressions {
	void rv(CharSequence s) {		
	}
	
	void testStrings(boolean cond) {
		rv(cond ? "" : new StringBuilder());
	}		
	
	void rv(AbstractList<?> l) {
		
	}
	
	void testLists(boolean cond) {
		rv(cond ? new ArrayList<String>() : new LinkedList<Object>());
	}
	
	void testStringLists(boolean cond) {
		rv(cond ? new ArrayList<String>() : new LinkedList<StringBuilder>());
	}
}

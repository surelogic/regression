package org.junit;

import org.hamcrest.Matcher;

public class Assert {
	static public void assertTrue(String message, boolean condition) {
		
	}
	
	public static void assertFalse(boolean condition) {
		
	}
	
	public static <T> void assertThat(T actual, Matcher<T> matcher) {
		assertThat("", actual, matcher);
	}
	
	public static <T> void assertThat(String reason, T actual, Matcher<T> matcher) {		
	}
}

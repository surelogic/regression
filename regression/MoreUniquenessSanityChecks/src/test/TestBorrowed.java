package test;

import com.surelogic.Borrowed;

public class TestBorrowed {
	public void badMethod(@Borrowed int x) {}
	
	public void goodMethod(@Borrowed Object o) {}
}
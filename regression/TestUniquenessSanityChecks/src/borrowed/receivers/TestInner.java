package borrowed.receivers;

import com.surelogic.Borrowed;

@SuppressWarnings("unused")
public class TestInner {
  @Borrowed("this") // bad -- no receiver on types
	private class Bad1 {}
	
	@Borrowed("TestInner.this") // good, properly names the enclosing type
	private class Good1 {}
	
	@Borrowed("X.this") // bad, no such type
	private class Bad2 {}
	
	@Borrowed("this, X.this") // bad
	private class Bad3 {}
	
	@Borrowed("x") // bad, no parameters in the context
	private class Bad4 {}
	
	
	
	private class Middle {
		@Borrowed("Middle.this") // good, properly names the enclosing type
		private class Good3 {}
		
		@Borrowed("TestInner.this") // bad, improperly names the parent of the enclosing type
		private class Bad5 {}
	}
	
	
	
	@Borrowed("TestInner.this") // bad: static classes don't have qualified receivers
	private static class Bad5 {
		public void m() {}
	}
	
	
	
}

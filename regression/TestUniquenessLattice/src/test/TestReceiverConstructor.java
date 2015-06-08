package test;

import com.surelogic.Borrowed;
import com.surelogic.Unique;
import com.surelogic.UniqueInRegion;

@SuppressWarnings("unused")
public class TestReceiverConstructor {
	// No annotations
	// ----------------------------------------------------------------------
	public TestReceiverConstructor() { /* empty */ }

	
	
	// One annotation
	// ----------------------------------------------------------------------
	@Borrowed("this")
	public TestReceiverConstructor(int a) { /* empty */ }
	
	@Unique("return")
	public TestReceiverConstructor(int a, int b) { /* empty */ }
	
	@Unique("this")
	public TestReceiverConstructor(int a, int b, int c, int d, int e) { /* empty */ }
	
	
	
	// Two annotations
	// ----------------------------------------------------------------------
	@Borrowed("this")
	@Unique("this")
	public TestReceiverConstructor(int a, int b, int c, int d, int e, int f, int g, int h, int i) { /* empty */ }
		
  @Unique("return, this")
	public TestReceiverConstructor(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l) { /* empty */ }
}

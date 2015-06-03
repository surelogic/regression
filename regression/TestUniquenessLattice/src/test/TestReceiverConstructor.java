package test;

import com.surelogic.Borrowed;
import com.surelogic.BorrowedInRegion;
import com.surelogic.Immutable;
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
	
	@Immutable("this")
	public TestReceiverConstructor(int a, int b, int c, int d) { /* empty */ }
	
	@Unique("this")
	public TestReceiverConstructor(int a, int b, int c, int d, int e) { /* empty */ }
	
	
	
	// Two annotations
	// ----------------------------------------------------------------------
	@Borrowed("this")
	@Immutable("this")
	public TestReceiverConstructor(int a, int b, int c, int d, int e, int f, int g, int h) { /* empty */ }
	
	@Borrowed("this")
	@Unique("this")
	public TestReceiverConstructor(int a, int b, int c, int d, int e, int f, int g, int h, int i) { /* empty */ }
		

	@Unique("return")
	@Immutable("this")
	public TestReceiverConstructor(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k) { /* empty */ }
	
	@Unique("return, this")
	public TestReceiverConstructor(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l) { /* empty */ }
		

	@Immutable("this")
	@Unique("this")
	public TestReceiverConstructor(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l, int m, int n, int o, int p) { /* empty */ }



	// Three annotations
	// ----------------------------------------------------------------------
	@Borrowed("this")
	@Immutable("this")
	@Unique("this")
	public TestReceiverConstructor(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l, int m, int n, int o, int p, int q, int r, int s, int t, int u) { /* empty */ }

	
	@Unique("return, this")
	@Immutable("this")
	public TestReceiverConstructor(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l, int m, int n, int o, int p, int q, int r, int s, int t, int u, int v, int w, int x, int y) { /* empty */ }
}

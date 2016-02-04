package test_final_exprs;

import com.surelogic.RegionLock;
import com.surelogic.ReturnsLock;

/**
 * Tests that class expressions, e.g., Foo.class, are treated as final 
 * expressions.  (There are only positive examples.  There should be no 
 * way to make a class expression not be final.)
 */
@RegionLock("LOCK is lockField protects Instance")
public class TestClassExprs {
	public final Object lockField = new Object();
	
	@ReturnsLock("LOCK")
  public Object good() {
    // Should get unidentifiable lock warning
    return Object.class;
  }
}

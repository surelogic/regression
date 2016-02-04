package test_final_exprs;

import com.surelogic.RegionLock;
import com.surelogic.ReturnsLock;

/**
 * Tests the finality or not of array reference expressions.
 * @author aarong
 *
 */
@RegionLock("LOCK is lockField protects Instance")
public class TestArrayRefs {
	public final Object lockField = new Object();
	
	@ReturnsLock("LOCK")
  public Object good_finalArray_constIdx() {
    final Object[] array = new Object[10];
    
    /* FINAL: array expression is final local variable; index is integer literal */
    // Should get unidentifiable lock warning
    return array[0];
  }

	@ReturnsLock("LOCK")
  public Object good_finalArray_constIdx(final Object[] array) {
    /* NOT-FINAL: array expression is final parameter; index is integer literal, but the value may after it is returned */
    // Should get unidentifiable lock warning
    return array[0];
  }

  
  
	@ReturnsLock("LOCK")
  public Object good_finalArray_finalIdx() {
    final Object[] array = new Object[10];
    final int idx = 5;
    
    /* NOT-FINAL: array expression is final local variable; index is final local, but the value may after it is returned  */
    // Should get unidentifiable lock warning
    return array[idx];
  }

	@ReturnsLock("LOCK")
  public Object good_finalArray_finalIdx(final Object[] array, final int idx) {
    /* NOT-FINAL: array expression is final parameter; index is final parameter, but the value may after it is returned  */
    // Should get unidentifiable lock warning
    return array[idx];
  }
}

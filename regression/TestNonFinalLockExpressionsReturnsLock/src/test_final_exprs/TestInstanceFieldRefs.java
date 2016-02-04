package test_final_exprs;

import com.surelogic.Borrowed;
import com.surelogic.RegionLock;
import com.surelogic.ReturnsLock;


/**
 * Tests the finalness or not of instance field references.
 */
@RegionLock("LOCK is lockField protects protectedField")
public class TestInstanceFieldRefs {
	public final Object lockField = new Object();
	
  private final Object finalField = new Object();
  private Object unprotectedField = new Object();
  
  // Just here so we can have a lock in the class to make the analysis think the class might be concurrent
  @SuppressWarnings("unused")
  private Object protectedField = new Object();
  
  
  @Borrowed("this")
  public TestInstanceFieldRefs() {
    // Needed to protect the initialization of "protectedField"
  }
  
  
  
  @ReturnsLock("LOCK")
  public Object good_finalField_implicitThis() {
    // FINAL: field is final and the object expression is final: implicit "this"
    // Should get unidentifiable lock expression
    return finalField;
  }
  
  @ReturnsLock("LOCK")
  public Object good_finalField_explicitThis() {
    // FINAL: field is final and the object expression is final: explicit "this"
    // Should get unidentifiable lock expression
    return this.finalField;
  }
  
  @ReturnsLock("LOCK")
  public Object good_finalField_finalParameter(final TestInstanceFieldRefs p) {
    // FINAL: field is final and the object expression is final: final parameter "p"
    // Should get unidentifiable lock expression
    return p.finalField;
  }
  
  @ReturnsLock("LOCK")
  public Object good_finalField_effectivelyFinalParameter(TestInstanceFieldRefs p) {
    /* FINAL: field is final and the object expression is final: parameter "p"
     * is effectively final because it is not modified inside of the synchronized
     * block.
     */
    // Should get unidentifiable lock expression
    return p.finalField;
  }

  
  
  @ReturnsLock("LOCK")
  public Object bad_nonfinalFieldUnprotected_implicitThis() {
    /* NON-FINAL: field is non-final and unprotected; 
     * the object expression is final: implicit "this"
     */
    return unprotectedField;
  }
  
  @ReturnsLock("LOCK")
  public Object bad_nonfinalFieldUnprotected_explicitThis() {
    /* NON-FINAL: field is non-final and unprotected; 
     * the object expression is final: explicit "this"
     */
    return this.unprotectedField;
  }
  
  @ReturnsLock("LOCK")
  public Object bad_nonfinalFieldUnprotected_finalParameter(final TestInstanceFieldRefs p) {
    /* NON-FINAL: field is non-final and unprotected; 
     * the object expression is final: final parameter "p"
     */
    return p.unprotectedField;
  }
}

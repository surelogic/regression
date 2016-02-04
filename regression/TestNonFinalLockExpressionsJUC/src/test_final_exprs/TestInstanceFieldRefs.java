package test_final_exprs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



/**
 * Tests the finalness or not of instance field references.
 */
public class TestInstanceFieldRefs {
	private final Lock finalField = new ReentrantLock();
  private Lock nonFinalField = new ReentrantLock();
  
    
  
  public void good_finalField_implicitThis() {
    // FINAL: field is final and the object expression is final: implicit "this"
    // Should get unidentifiable lock expression
  	finalField.lock();
  	try {} finally { 
  		finalField.unlock();
  	}
  }
  
  public void good_finalField_explicitThis() {
    // FINAL: field is final and the object expression is final: explicit "this"
    // Should get unidentifiable lock expression
  	this.finalField.lock();
  	try {} finally { 
  		this.finalField.unlock();
  	}
  }
  
  public void good_finalField_finalParameter(final TestInstanceFieldRefs p) {
    // FINAL: field is final and the object expression is final: final parameter "p"
    // Should get unidentifiable lock expression
  	p.finalField.lock();
  	try {} finally { 
  		p.finalField.unlock();
  	}
  }

  public void bad_nonfinalFieldUnprotected_implicitThis() {
    /* NON-FINAL: field is non-final and unprotected; 
     * the object expression is final: implicit "this"
     */
  	nonFinalField.lock();
  	try {} finally { 
  		nonFinalField.unlock();
  	}
  }
  
  public void bad_nonfinalFieldUnprotected_explicitThis() {
    /* NON-FINAL: field is non-final and unprotected; 
     * the object expression is final: explicit "this"
     */
  	this.nonFinalField.lock();
  	try {} finally { 
  		this.nonFinalField.unlock();
  	}
  }
  
  public void bad_nonfinalFieldUnprotected_finalParameter(final TestInstanceFieldRefs p) {
    /* NON-FINAL: field is non-final and unprotected; 
     * the object expression is final: final parameter "p"
     */
  	p.nonFinalField.lock();
  	try {} finally { 
  		p.nonFinalField.unlock();
  	}
  }
}

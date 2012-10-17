package test.methodIdentification;

import com.surelogic.ReferenceObject;
import com.surelogic.RegionEffects;

/* Test that analysis only looks at "void toString()" methods in types
 * that are @ReferenceObject.
 */
@ReferenceObject
public interface TestInterface {
  @RegionEffects("reads nothing")
  public String toString(); // Should be analyzed: GOOD
  
  public void m(); // Should not be analyzed
  
  public String toString(boolean f); // Should not be analyzed
}

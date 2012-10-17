package test.methodIdentification;

import com.surelogic.ReferenceObject;
import com.surelogic.RegionEffects;

/* Test that analysis only looks at "void toString()" methods in types
 * that are @ReferenceObject.
 */
@ReferenceObject
public class TestClass {
  @RegionEffects("reads nothing")
  public String toString() { // Should be analyzed: GOOD
    return "foo";
  }
  
  public void m() {} // Should not be analyzed
  
  public String toString(boolean f) { // Should not be analyzed
    return null;
  }
  
  
  
  @ReferenceObject
  class InnerClass {
    @RegionEffects("reads nothing")
    public String toString() { // Should be analyzed: GOOD
      return "X";
    }

    public void m() {} // Should not be analyzed

    public String toString(boolean f) { // Should not be analyzed
      return null;
    }
  }
  
  class InnerClass2 {
    @RegionEffects("reads nothing")
    public String toString() { // Should not be analyzed
      return "X";
    }

    public void m() {} // Should not be analyzed

    public String toString(boolean f) { // Should not be analyzed
      return null;
    }
  }

  

  
  @ReferenceObject
  interface InnerInterface {
    @RegionEffects("reads nothing")
    public String toString(); // Should be analyzed: GOOD

    public void m(); // Should not be analyzed

    public String toString(boolean f); // Should not be analyzed
  }

  interface InnerInterface2 {
    @RegionEffects("reads nothing")
    public String toString(); // Should not be analyzed

    public void m(); // Should not be analyzed

    public String toString(boolean f); // Should not be analyzed
  }

  

  public Object foo() {
    return new TestClass() { // error here, @ReferenceObject class cannot be extended this way
      @RegionEffects("reads nothing")
      public String toString() { // Should not be analyzed
        return "X";
      }

      public void m() {} // Should not be analyzed

      public String toString(boolean f) { // Should not be analyzed
        return null;
      }
    };
  }
}

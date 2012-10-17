package test;

import com.surelogic.ReferenceObject;
import com.surelogic.RegionEffects;

@ReferenceObject
public class Test {
  @RegionEffects("reads nothing")
  public String toString() {
    return "foo";
  }
  
  public void m() {}
  
  public String toString(boolean f) {
    return null;
  }
  
  class Inner {
    public String toString() {
      return "X";
    }

    public void m() {}

    public String toString(boolean f) {
      return null;
    }
  }

  @ReferenceObject
  class Inner2 {
    @RegionEffects("reads All")
    public String toString() {
      return "X";
    }

    public void m() {}

    public String toString(boolean f) {
      return null;
    }
  }

  @ReferenceObject
  class Inner3 {
    public String toString() {
      return "X";
    }
  }
  

  @ReferenceObject
  class Inner4 {
    @RegionEffects("reads this:Instance; writes any(Object):Instance")
    public String toString() {
      return "X";
    }

  }


  public Object foo() {
    return new Object() {
      public String toString() {
        return "Z";
      }
    };
  }
}

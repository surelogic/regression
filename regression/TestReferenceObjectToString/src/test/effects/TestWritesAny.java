package test.effects;

import com.surelogic.ReferenceObject;
import com.surelogic.RegionEffects;

@ReferenceObject
public class TestWritesAny {
  @RegionEffects("reads this:Instance; writes any(java.lang.Object):Instance")
  public String toString() { // bad
    return "foo";
  }
}

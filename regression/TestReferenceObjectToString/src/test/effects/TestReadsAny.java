package test.effects;

import com.surelogic.ReferenceObject;
import com.surelogic.RegionEffects;

@ReferenceObject
public class TestReadsAny {
  @RegionEffects("reads this:Instance, any(java.lang.Object):Instance")
  public String toString() { // Good, but warn
    return "foo";
  }
}

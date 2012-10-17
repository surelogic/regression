package test.effects;

import com.surelogic.ReferenceObject;
import com.surelogic.RegionEffects;

@ReferenceObject
public class TestReadsAll {
  @RegionEffects("reads All")
  public String toString() { // good, but warn
    return "foo";
  }
}

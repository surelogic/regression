package test.effects;

import com.surelogic.ReferenceObject;
import com.surelogic.RegionEffects;

@ReferenceObject
public class TestWritesAll {
  @RegionEffects("writes All")
  public String toString() { // bad
    return "foo";
  }
}

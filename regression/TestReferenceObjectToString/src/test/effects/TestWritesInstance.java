package test.effects;

import com.surelogic.ReferenceObject;
import com.surelogic.RegionEffects;

@ReferenceObject
public class TestWritesInstance {
  @RegionEffects("writes Instance")
  public String toString() { // bad
    return "foo";
  }
}

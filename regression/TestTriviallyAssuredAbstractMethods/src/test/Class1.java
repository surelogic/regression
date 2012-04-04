package test;

import com.surelogic.Immutable;
import com.surelogic.RegionEffects;

@Immutable
public class Class1 {
  /* Trivally assures: No body effects.
   */
  @RegionEffects("reads All")
  public double interpolate(double fraction) {
    return 0.0;
  }
}
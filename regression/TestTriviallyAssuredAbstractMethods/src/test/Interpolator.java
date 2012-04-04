package test;

import com.surelogic.Immutable;
import com.surelogic.RegionEffects;

@Immutable
public interface Interpolator {
  /* Trivally assures: Abstract method.  Used to be ignored by analysis 
   * and result in a red trusted dot.
   */
  @RegionEffects("reads All")
  public double interpolate(double fraction);
}
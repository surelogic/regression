package test;

import com.surelogic.Immutable;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

@Immutable(whenImmutable="A")
public class TestImmutable<A, B extends Other2, C> {
  // primitive
  @SuppressWarnings("unused")
  private final int f1 = 0; // good
  
  
  // @Immutable
  @Unique
  private final Other2 f2 = null; // good
  
  @Unique
  private final Other2[] f3 = null; // bad
  
  @Unique
  private final Other2[][] f4 = null; // bad
  
  
  // Immutable by annotation bounds
  @Unique
  private final A f5 = null; // good
  
  @Unique
  private final A[] f6 = null; // bad
  
  @Unique
  private final A[][] f7 = null; // bad
  
  
  // Immutable by type bounds
  @Unique 
  private final B f8 = null; // good
  
  @Unique
  private final B[] f9 = null; // bad
  
  @Unique
  private final B[][] f10 = null; // bad
  
  
  // Not immutable
  @Unique
  private final C f11 = null; // bad
  
  @Unique 
  private final C[] f12 = null; // bad
  
  @Unique
  private final C[][] f13 = null; // bad
  
  
  
  @RegionEffects("none")
  @Unique("return")
  public TestImmutable() {
    super();
  }
}


@Immutable
class Other2 {
  @Unique("return")
  @RegionEffects("none")
  public Other2() {}
}

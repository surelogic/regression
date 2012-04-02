package test;

import com.surelogic.Immutable;
import com.surelogic.RegionEffects;

public class Test {
  public void takesShared(final Object o) {
    // do stuff
  }
  
  public void doStuff1(final Var var) {
    takesShared(var); // Okay -- Var is a value type
  }
  
  public void doStuff2(final @Immutable Object o) {
    takesShared(o); // not okay, immutable reference
  }
  
  public void bad(final boolean f, final @Immutable Object o, final Var var) {
    final Object x = f ? o : var;
    takesShared(x); // not okay, x could be an immutable reference, or a value object.
  }
}

@Immutable
class Var {
  public final int value;
  
  @RegionEffects("none")
  public Var(final int v) { value = v; } 
}
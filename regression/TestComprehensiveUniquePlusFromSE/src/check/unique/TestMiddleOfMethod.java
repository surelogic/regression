package check.unique;

import com.surelogic.RegionEffects;
import com.surelogic.Unique;

// Test StoreLattice.check() --- how to get an error in the middle of a method instead of at the end of the method
@SuppressWarnings("unused")
public class TestMiddleOfMethod {
  private Other o;
  private int count;
  private int foo;

  @RegionEffects("none")
  private static void eatUnique(final Object p) {
  }

  public void m() {
    Other oo = this.o;
    Object t = oo.u;
    eatUnique(t);
    oo = null; // We lose track of the object whose 'u' field needs to be reset
               // by reseting oo to refer to something else.
    count += 1;
    foo += 10;
  }

  public void m2() {
    {
      Other oo = this.o;
      Object t = oo.u;
      eatUnique(t);
    } // oo goes out of scope: we lose track of the object whose 'u' field needs
      // to be reset
    count += 1;
    foo += 10;
  }
}

class Other {
  @Unique
  public Object u = null;
}

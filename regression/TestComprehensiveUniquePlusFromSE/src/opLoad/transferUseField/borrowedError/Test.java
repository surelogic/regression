package opLoad.transferUseField.borrowedError;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

class Set {
  // empty
}

class Iterator {
  @Borrowed
  public final Set set;
  
  @Unique("return")
  @RegionEffects("writes set:Instance")
  public Iterator(final @Borrowed(allowReturn=true) Set set) {
    this.set = set;
  }
}

public class Test {
  public void doStuff() {
    final Set s = new Set();
    final Iterator i = new Iterator(s);
    i.set.toString(); // BAD
  }
}
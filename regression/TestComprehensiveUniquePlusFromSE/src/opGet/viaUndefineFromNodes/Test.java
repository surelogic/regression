package opGet.viaUndefineFromNodes;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

class Set {
	public int f;
  // empty
	
	@RegionEffects("reads this:Instance")
	public void inc() {}
}

class Iterator {
  @Borrowed
  public final Set set;
  
  @Unique("return")
  @RegionEffects("writes set:Instance")
  public Iterator(final @Borrowed(allowReturn=true) Set set) {
    this.set = set;
  }
  
  @RegionEffects("reads Instance")
  public boolean hasNext() {
  	return false;
  }
}

public class Test {
  public void byFieldRead() {
    final Set s = new Set();
    final Iterator i = new Iterator(s);
    int v = s.f; // kill from field
    i.hasNext(); // i is undefined
  }

  public void byFieldWrite() {
    final Set s = new Set();
    final Iterator i = new Iterator(s);
    s.f = 1; // kill from field
    i.hasNext(); // i is undefined
  }

  public void byOpLoadReachable() {
    final Set s = new Set();
    final Iterator i = new Iterator(s);
    s.inc(); // kill from field
    i.hasNext(); // i is undefined
  }
}
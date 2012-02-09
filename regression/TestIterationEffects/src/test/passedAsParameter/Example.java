package test.passedAsParameter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.surelogic.Borrowed;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

public class Example {
  @Unique
  private List<Integer> list = new ArrayList<Integer>();
  
  // other stuff
  
  @RegionEffects("reads Instance")
  public int sum(final boolean flag) {
    int sum = 0;
    Iterator<Integer> it = list.iterator();
    
    final Iterator<Integer> x = it;
    final Iterator<Integer> y = flag ? x : null;
    doStuff(y); // force write effect!
    
    while (it.hasNext()) {
      final int v = it.next();
      sum += v;
    }
    return sum;
  }
  
  @RegionEffects("none")
  public void doStuff(final @Borrowed Object o) {
    // do stuff
  }
}

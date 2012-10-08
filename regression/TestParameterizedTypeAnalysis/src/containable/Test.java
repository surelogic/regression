package containable;

import com.surelogic.AnnotationBounds;
import com.surelogic.Containable;
import com.surelogic.Unique;

@AnnotationBounds(containable="T")
public class Test<T> {
  @Containable
  private class Good {
    @Unique("return")
    public Good() {}
  }
  
  private class Bad {
    public Bad() {}
  }
  
  
  
  private C<T> good1;
  private C<T[]> good2;  // used to be good, but now is bad: only primitive types are allowed
  private C<T[][]> bad1;
  
  private C<Good> good10;
  private C<Good[]> good11; // used to be good, but now is bad: only primitive types are allowed
  private C<Good[][]> bad10;
  
  public C<int[]> good100() { return null; }
  public C<int[][]> bad100() { return null; }
  
  public void bad1000(C<Bad> p) {}
}

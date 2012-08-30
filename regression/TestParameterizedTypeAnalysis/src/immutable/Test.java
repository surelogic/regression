package immutable;

import com.surelogic.AnnotationBounds;
import com.surelogic.Immutable;
import com.surelogic.RegionEffects;

@AnnotationBounds(immutable="T")
public class Test<T> {
  @Immutable
  private class Good {
    @RegionEffects("none")
    public Good() {}
  }
  
  private class Bad {
    public Bad() {}
  }
  
  
  
  private C<T> good1;
  private C<T[]> bad1;
  private C<T[][]> bad2;
  
  private C<Good> good10;
  private C<Good[]> bad10;
  private C<Good[][]> bad11;
  
  public C<int[]> bad100() { return null; }
  public C<int[][]> bad101() { return null; }
  
  public void bad1000(C<Bad> p) {}
}

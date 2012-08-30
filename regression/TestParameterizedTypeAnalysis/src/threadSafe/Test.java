package threadSafe;

import com.surelogic.AnnotationBounds;
import com.surelogic.Immutable;
import com.surelogic.RegionEffects;
import com.surelogic.ThreadSafe;

@AnnotationBounds(immutable="I", threadSafe="TS")
public class Test<I, TS> {
  @Immutable
  private class GoodI {
    @RegionEffects("none")
    public GoodI() {}
  }
  
  @ThreadSafe
  private class GoodTS {
    @RegionEffects("none")
    public GoodTS() {}
  }
  
  private class Bad {
    public Bad() {}
  }
  
  
  
  private C<I> good1;
  private C<I[]> bad1;
  private C<I[][]> bad2;
  
  private C<TS> good10;
  private C<TS[]> bad11;
  private C<TS[][]> bad12;
  
  private C<GoodI> good100;
  private C<GoodI[]> bad100;
  private C<GoodI[][]> bad101;
  
  private C<GoodTS> good200;
  private C<GoodTS[]> bad200;
  private C<GoodTS[][]> bad201;
  
  public C<int[]> bad100() { return null; }
  public C<int[][]> bad101() { return null; }
  
  public void bad1000(C<Bad> p) {}
}

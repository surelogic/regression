package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;

public class TestMethodReturn {
  @NonNull
  public static Object s1() { return new Object(); }
  
  @Nullable
  public static Object s2() { return new Object(); }
    
  public static Object s3() { return new Object(); }
  
  
  
  @NonNull
  public Object m1() { return new Object(); }
  
  @Nullable
  public Object m2() { return new Object(); }
    
  public Object m3() { return new Object(); }
  
  
  
  private static void use(final Object o) {
    // empty
  }
  
  public void m(final TestMethodReturn other) {
    Object x = this.m1(); // @NonNull
    Object y = this.m2(); // @Nullable
    Object z = this.m3(); // @Nullable
    
    use(x); // @NonNull
    use(y); // @Nullable
    use(z); // @Nullable
    
    z = x;  // @NonNull
    use(z); // @NonNull
    
    Object a = other.m1();
    Object b = other.m2();
    Object c = other.m3();
    
    use(a); // @NonNull
    use(b); // @Nullable
    use(c); // @Nullable
    
    Object aa = s1();
    Object bb = s2();
    Object cc = s3();
    
    use(aa); // @NonNull
    use(bb); // @Nullable
    use(cc); // @Nullable
  }
}

package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;

public class TestFields {
  @NonNull
  private static Object s1;
  
  @Nullable
  private static Object s2;
  
  private static Object s3;
  
  
  
  @NonNull
  private Object f1;
  
  @Nullable
  private Object f2;
  
  private Object f3;
  
  
  
  private static void use(final Object o) {
    // empty
  }
  
  public void m(final TestFields other) {
    Object x = this.f1; // @NonNull
    Object y = this.f2; // @Nullable
    Object z = this.f3; // @Nullable
    
    use(x); // @NonNull
    use(y); // @Nullable
    use(z); // @Nullable
    
    z = x;  // @NonNull
    use(z); // @NonNull
    
    Object a = other.f1;
    Object b = other.f2;
    Object c = other.f3;
    
    use(a); // @NonNull
    use(b); // @Nullable
    use(c); // @Nullable
    
    Object aa = s1;
    Object bb = s2;
    Object cc = s3;
    
    use(aa); // @NonNull
    use(bb); // @Nullable
    use(cc); // @Nullable
  }
}

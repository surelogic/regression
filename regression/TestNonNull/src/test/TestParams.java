package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;

public class TestParams {
  private static void use(final Object o) {
    // empty
  }
  
  public void m(@NonNull Object p1, @Nullable Object p2, Object p3, boolean flag) {
    Object x = p1; // @NonNull
    Object y = p2; // @Nullable
    Object z = p3; // @Nullable
    
    use(x); // @NonNull
    use(y); // @Nullable
    use(z); // @Nullable
    
    p1 = null;
    p2 = null;
    p3 = null;
    
    use(p1); // @Nullable
    use(p2); // @Nullable
    use(p3); // @Nullable
    
    z = x;  // @NonNull
    use(z); // @NonNull
    
    Object q = flag ? p1 : z;  // @Nullable / @NonNull
    Object r = flag ? z : x;   // @NonNull / @NonNull 
    Object s = flag ? p2 : p3; // @Nullable / @Nullable
    
    use(q); // @Nullable
    use(r); // @NonNull
    use(s); // @Nullable
    
    try {
      // stuff
    } catch (final Exception e) {
      p1 = e; // @NonNull
      use(p1); // @NonNull
    }
    
    use(p1); // @Nullable
  }
}

package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;

public class Test {
  public void takesNonNull(@NonNull Object p) {
    // foo
  }
  
  public void callsStuff(@NonNull Object a, @Nullable Object b, Object c) {
    takesNonNull(a); // good
    takesNonNull(b); // bad
    takesNonNull(c); // bad, but propose to make 'c' @NonNull
  }
  
  public void nextLevel(final @NonNull Object a, Object b) {
    callsStuff(a, b, b); // ultimately, b should also be @NonNull
  }
  
  
  public @NonNull Object get() { return new Object(); }
  
  public void use(final Object o) {}
  
  public void locals(@NonNull Object a, @Nullable Object b, Object c, boolean flag) {
    Object x = new Object();
    Object y = get();
    Object z = new int[10];
    x = a;
    y = a;
    z = flag ? a : b; // z cannot be @NonNull
    x = get();
    y = b; // y cannot be @NonNull
    z = a;
    use(y);
    use(x);
    use(z);
  }
}

package test;

import com.surelogic.NonNull;

public class CC {
  private @NonNull Object f;
  
  public CC(Object v) {
    if (v == null) throw new IllegalArgumentException();
    f = v;
  }
  
  
}

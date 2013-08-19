package test;

import com.surelogic.NonNull;

public class CCC {
  static @NonNull Object s;
  
  private final @NonNull Object f;
  
  public CCC(Object v) {
    if (v == null) throw new IllegalArgumentException();
    f = v;
  }
  
  public CCC() {
    this("X");
  }
  
}

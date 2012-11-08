package test;

import com.surelogic.ValueObject;

@ValueObject
public class V {
  private final int v;
  
  public V(int x) { v = x; }

  @Override
  public boolean equals(final Object o) {
    if (o instanceof V) {
      return v == ((V) o).v;
    } else {
      return false;
    }
  }
  
  @Override
  public int hashCode() {
    return v * 31;
  }
}

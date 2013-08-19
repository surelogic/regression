package test;

public class C {
  private final Object f;
  
  public C(Object v) {
    if (v == null) throw new IllegalArgumentException();
    f = v;
  }
  
  
}

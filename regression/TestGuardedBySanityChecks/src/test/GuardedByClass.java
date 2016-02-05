package test;

import com.surelogic.GuardedBy;

public class GuardedByClass {
  @GuardedBy("Object.class")
  private final int x = 0; // bad - final
  
  @GuardedBy("Object.class")
  private int xx = 0; // good
  
  @GuardedBy("Object.class")
  private final Object y = null; // bad - final
  
  @GuardedBy("Object.class")
  private String yy = null; // good
  
  

  @GuardedBy("Object.class")
  protected static final int s_x = 0; // bad - final
  
  @GuardedBy("Object.class")
  protected static int s_xx = 0; // good
  
  @GuardedBy("Object.class")
  protected static final Object s_y = null; // bad - final
  
  @GuardedBy("Object.class")
  protected static String s_yy = null; // good
  
  

  @GuardedBy("Object.class") // good
  public GuardedByClass() {
    super();
  }
  
  @GuardedBy("Object.class") // good
  void method1() {
    return;
  }
  
  @GuardedBy("Object.class") // good
  public static void staticMethod1() {
    return;
  }
}

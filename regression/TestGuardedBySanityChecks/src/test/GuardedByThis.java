package test;

import com.surelogic.GuardedBy;

public class GuardedByThis {
  @GuardedBy("this")
  private final int x = 0; // bad - final
  
  @GuardedBy("this")
  private int xx = 0; // good
  
  @GuardedBy("this")
  private final Object y = null; // bad - final
  
  @GuardedBy("this")
  private String yy = null; // good
  
  

  @GuardedBy("this")
  protected static final int s_x = 0; // bad - static
  
  @GuardedBy("this")
  protected static int s_xx = 0; // bad - static
  
  @GuardedBy("this")
  protected static final Object s_y = null; // bad - static
  
  @GuardedBy("this")
  protected static String s_yy = null; // bad - static
  
  

  @GuardedBy("this") // bad - constructor
  public GuardedByThis() {
    super();
  }
  
  @GuardedBy("this") // good
  void method1() {
    return;
  }
  
  @GuardedBy("this") // bad - static
  public static void staticMethod1() {
    return;
  }
}

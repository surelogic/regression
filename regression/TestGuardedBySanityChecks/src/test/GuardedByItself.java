package test;

import com.surelogic.GuardedBy;

public class GuardedByItself {
  @GuardedBy("itself")
  private final int x = 0; // bad - not reference
  
  @GuardedBy("itself")
  private int xx = 0; // bad - not reference, not final
  
  @GuardedBy("itself")
  private final Object y = null; // good
  
  @GuardedBy("itself")
  private String yy = null; // bad - not final
  
  

  @GuardedBy("itself")
  protected static final int s_x = 0; // bad - not reference
  
  @GuardedBy("itself")
  protected static int s_xx = 0; // bad - not final, not reference
  
  @GuardedBy("itself")
  protected static final Object s_y = null; // good
  
  @GuardedBy("itself")
  protected static String s_yy = null; // bad - not final
  
  

  @GuardedBy("itself") // bad - constructor
  public GuardedByItself() {
    super();
  }
  
  @GuardedBy("itself") // bad - method
  void method1() {
    return;
  }
  
  @GuardedBy("itself") // bad - method
  public static void staticMethod1() {
    return;
  }
}

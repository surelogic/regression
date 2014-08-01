package test.fields;

import com.surelogic.Vouch;

public class Class {
  private int f1;
  private final int f2 = 0;
  
  protected Object o1 = new Object();
  protected final String s1 = "xyz";
  
  @Vouch("final")
  int x1;
  
  @Vouch("final")
  Object z1 = null, z2 = new Object();
}

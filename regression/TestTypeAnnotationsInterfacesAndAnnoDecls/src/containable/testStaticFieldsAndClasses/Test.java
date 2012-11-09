package containable.testStaticFieldsAndClasses;


import com.surelogic.Containable;
import com.surelogic.Unique;

import containable.helpers.Bad;
import containable.helpers.Other;

@Containable
public class Test {
  @Unique("return")
  public Test() {}
  
  
  int f1; // good
  
  @Unique
  Other f2; // good
  
  @Unique
  int[] f3; // good
  
  @Unique
  Bad f4; // bad
  
  Bad f5; // worse
  
  
  // ===
  
  
  static int s1; // not checked
  
  static Other s2; // not checked
  
  static int[] s3; // not checked
  
  static Bad s4; // not checked
  
  static Bad s5; // not checked
}

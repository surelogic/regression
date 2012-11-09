package containable.testStaticFieldsAndClasses;


import com.surelogic.Containable;
import com.surelogic.Unique;

import containable.helpers.Bad;
import containable.helpers.Other;

@Containable
public class StaticFieldsOnly {
  @Unique("return")
  public StaticFieldsOnly() {}

  
  
  static int s1; // not checked
  
  static Other s2; // not checked
  
  static int[] s3; // not checked
  
  static Bad s4; // not checked
  
  static Bad s5; // not checked
}

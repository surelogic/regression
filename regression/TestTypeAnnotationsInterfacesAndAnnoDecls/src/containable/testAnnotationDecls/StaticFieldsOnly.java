package containable.testAnnotationDecls;


import com.surelogic.Containable;

import containable.helpers.Bad;
import containable.helpers.Other;

@Containable
public interface StaticFieldsOnly {
  static int s1 = 0; // not checked
  
  static Other s2 = null; // not checked
  
  static int[] s3 = null; // not checked
  
  static Bad s4 = null; // not checked
  
  static Bad s5 = null; // not checked
}

package threadSafe.testInterfaces;

import immutable.helpers.I;
import immutable.helpers.Other;
import immutable.helpers.TS;

import com.surelogic.Part;
import com.surelogic.ThreadSafe;

@ThreadSafe(appliesTo=Part.Instance)
public interface StaticPartNotThreadSafe {
  public static int x = 0; // not checked
  public static Other o = null; // not checked
  public static int[] a = new int[] { 0, 1, 2 }; // not checked
  public static I i = null;  // not checked
  
  public static TS ts = null; // not checked
}

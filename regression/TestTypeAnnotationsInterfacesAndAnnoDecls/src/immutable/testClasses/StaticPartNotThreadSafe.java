package immutable.testClasses;

import immutable.helpers.I;
import immutable.helpers.Other;
import immutable.helpers.TS;

import com.surelogic.Immutable;
import com.surelogic.Part;

@Immutable(appliesTo=Part.Instance)
public class StaticPartNotThreadSafe {
  public static final int x = 0; // not checked
  public static final Other o = null; // not checked
  public static final int[] a = new int[] { 0, 1, 2 }; // not checked
  public static final I i = null;  // not checked
  
  public static final TS ts = null; // not checked
}

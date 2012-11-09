package immutable.testClasses;

import immutable.helpers.I;
import immutable.helpers.Other;
import immutable.helpers.TS;

import com.surelogic.Immutable;

@Immutable(staticPart="Immutable")
public class StaticPartImmutable {
  public static final int x = 0; // good
  public static final Other o = null; // bad
  public static final int[] a = new int[] { 0, 1, 2 }; // bad
  public static final I i = null; // good
  
  public static final TS ts = null; // bad
}

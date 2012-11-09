package immutable.testInterfaces;

import immutable.helpers.I;
import immutable.helpers.Other;
import immutable.helpers.TS;

import com.surelogic.Immutable;

@Immutable(staticPart="Immutable")
public interface StaticPartImmutable {
  public static int x = 0; // good
  public static Other o = null; // bad
  public static int[] a = new int[] { 0, 1, 2 }; // bad
  public static I i = null; // good
  
  public static TS ts = null; // bad
}

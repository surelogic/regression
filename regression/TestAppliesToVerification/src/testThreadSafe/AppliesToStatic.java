package testThreadSafe;

import helpers.ImmutableClass;
import helpers.MutClass;
import helpers.TS;

import com.surelogic.Part;
import com.surelogic.RegionLock;
import com.surelogic.ThreadSafe;

@ThreadSafe(appliesTo=Part.Static)
@RegionLock("L is class protects Static")
public class AppliesToStatic {
  private static final MutClass static1 = null; // bad
  private static final ImmutableClass static2 = null; // good
  private static final TS static3 = null; // good
  private static TS static4  = null; // good
  private static Object static5 = null; // bad
  private static int static6 = 0; // good

  private final TS instance1 = null; // NOT CHECKED: good
  private int instance2 = 0; // NOT CHECKED: bad
}

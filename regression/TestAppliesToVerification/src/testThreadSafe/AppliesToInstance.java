package testThreadSafe;

import helpers.ImmutableClass;
import helpers.MutClass;
import helpers.TS;

import com.surelogic.Part;
import com.surelogic.ThreadSafe;

@ThreadSafe(appliesTo=Part.Instance)
public class AppliesToInstance {
  private static final MutClass static1 = null; // good -- not even checked
  private static final ImmutableClass static2 = null; // good -- not even checked
  private static final TS static3 = null; // good -- not even checked
  private static TS static4  = null; // good -- not even checked
  private static Object static5 = null; // good -- not even checked
  private static int static6 = 0; // good -- not even checked

  private final TS instance1 = null; // good
  private int instance2 = 0; // bad
}

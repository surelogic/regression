package testImmutable;

import helpers.ImmutableClass;
import helpers.MutClass;
import helpers.TS;

import com.surelogic.Immutable;
import com.surelogic.Part;

@Immutable(appliesTo=Part.Static)
public class AppliesToStatic {
  private static final MutClass static1 = null; // bad
  private static final ImmutableClass static2 = null; // good
  private static final TS static3 = null; // bad
  private static TS static4  = null; // bad
  private static Object static5 = null; // bad
  private static int static6 = 0; // bad
  
  private final MutClass instance1 = null; // NOT CHECKED: bad
  private final ImmutableClass instance2 = null; // NOT CHECKED: good
}

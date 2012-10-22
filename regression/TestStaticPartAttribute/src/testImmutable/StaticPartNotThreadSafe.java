package testImmutable;

import helpers.ImmutableClass;
import helpers.MutClass;
import helpers.TS;

import com.surelogic.Immutable;

@Immutable(staticPart="NotThreadSafe")
public class StaticPartNotThreadSafe {
  private static final MutClass static1 = null; // good -- not even checked
  private static final ImmutableClass static2 = null; // good -- not even checked
  private static final TS static3 = null; // good -- not even checked
  private static TS static4  = null; // good -- not even checked
  private static Object static5 = null; // good -- not even checked
  private static int static6 = 0; // good -- not even checked
  
  private final MutClass instance1 = null; // bad
  private final ImmutableClass instance2 = null; // good
}

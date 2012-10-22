package testImmutable;

import helpers.ImmutableClass;
import helpers.MutClass;
import helpers.TS;

import com.surelogic.Immutable;
import com.surelogic.RegionLock;

@Immutable(staticPart="ThreadSafe")
@RegionLock("L is class protects Static")
public class StaticPartThreadSafe {
  private static final MutClass static1 = null; // bad
  private static final ImmutableClass static2 = null; // good
  private static final TS static3 = null; // good
  private static TS static4  = null; // good
  private static Object static5 = null; // bad
  private static int static6 = 0; // good
  
  private final MutClass instance1 = null; // bad
  private final ImmutableClass instance2 = null; // good
}

package test;

import com.surelogic.Immutable;

@Immutable
public class TestImmutable {
  private final Immut<String> good1 = new Immut<String>(); // good: type is immutable and the parameterized type assures
  private final Object good2 = new Immut<Integer>(); // good: field is final, initialized to an immutable object, and the parameterized type assures
  
  private final Immut<Thread> bad1 = new Immut<Thread>(); // bad: type is immutable, but the parameterized type doesn't assure
  private final Object bad2 = new Immut<Thread>(); // bade: field is final, initialized to an immutable object, but the parameterized type doesn't assure.
}

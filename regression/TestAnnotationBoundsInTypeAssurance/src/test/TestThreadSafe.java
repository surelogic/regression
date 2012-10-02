package test;

import com.surelogic.ThreadSafe;

@ThreadSafe
public class TestThreadSafe {
  private final TS<String> good1 = new TS<String>(); // good: type is threadsafe and the parameterized type assures
  private final Object good2 = new TS<Integer>(); // good: field is final, initialized to a threadsafe object, and the paramteraized type assures 
  
  private final TS<Thread> bad1 = new TS<Thread>(); // bad: type is threadsafe, but the parameterized type doesn't assure
  private final Object bad2 = new TS<Thread>(); // bad: field is final, initialized to a threadsafe object, but the parameterized type doesn't assure
}

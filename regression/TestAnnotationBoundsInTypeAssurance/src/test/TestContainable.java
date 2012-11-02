package test;

import com.surelogic.Containable;
import com.surelogic.Unique;

@Containable
public class TestContainable {
	@Unique("return")
	public TestContainable() {}
	
  @Unique
  private final Contain<String> good1a = new Contain<String>(); // good: type of the field is containable & the parameterized type assures
  @Unique
  private Contain<String> good1b = new Contain<String>(); // good: type of the field is containable & the parameterized type assures
  @Unique
  private final Object good2a = new Contain<Integer>(); // good: field is final and initialized to a containable object & the parameterized type assures
  @Unique
  private Object good2b = new Contain<Integer>(); // bad: field is NOT final, but is initialized to a containable object & the parameterized type assures
  
  @Unique
  private final Contain<Thread> bad1a = new Contain<Thread>(); // bad:  type of the field is containable but the parameterized type doesn't assure
  @Unique
  private Contain<Thread> bad1b = new Contain<Thread>(); // bad:  type of the field is containable but the parameterized type doesn't assure
  @Unique
  private final Object bad2a = new Contain<Thread>(); // bad: field is final and initialized to a containable object but, the parameterized type doesn't assure
  @Unique
  private Object bad2b = new Contain<Thread>(); // bad: field is NOT final, but is initialized to a containable object where the parameterized type doesn't assure
}

package test;

import com.surelogic.Unique;

@SuppressWarnings("unused")
public class Test {
  // BAD: Field is primitive
  @Unique
  private final int bad1 = 0;
  
  // GOOD: Field is reference-typed
  @Unique
  private final Object good1 = new Object();
  
  // BAD: volatile fields cannot be unique
  @Unique
  private volatile Object bad2 = new Object();
  
  
  
  // Good: non-final instance field
  @Unique
  private Object good10 = new Object();
  
  // Good: final instance field
  @Unique
  private final Object good11 = new Object();
  
  // Good: non-final static field
  @Unique
  private static Object good12 = new Object();
  
  // Good: final static field --- Used to be bad, but now aggregates into Static
  @Unique
  private final static Object bad10 = new Object();
}

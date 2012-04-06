package test;

import com.surelogic.Immutable;

@Immutable
public class Test {
  // GOOD:  final and primitive
  protected final int good1 = 1;
  
  // BAD: non-final primitive
  protected int bad1 = 2;
  
  
  
  // GOOD: final and Immutable
  protected final Point good2 = new Point(1, 2);
  
  // BAD: not-final and Immutable
  protected Point bad2 = new Point(1, 2);
  
  // GOOD: final and references and immutable implementation
  protected final Object good3a = new Object();
  
  // BAD: final and references a mutable type
  protected final NotImmutable bad3b = new NotImmutable();
  
  // BAD: non-final and mutable
  protected Object bad4 = null;
}

class NotImmutable {
	
}
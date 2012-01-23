package test;

import com.surelogic.ThreadSafe;


@ThreadSafe(implementationOnly=true)
class X {
  protected final int v = 1; 
}

// Not threadsafe
class Y extends X {
  // foo
}

@ThreadSafe(implementationOnly=true)
class Z extends X {
  protected final int vv = 0;
}

@ThreadSafe
public class Test {
  private static X getX() { return null; }
  private static Y getY() { return null; }
  private static Z getZ() { return null; }

  
  
  private final X a = new X(); // good
  private final X b = new Y(); // bad
  private final X c = new Z(); // good
  
  private final X aa = getX(); // bad: could return a non-thread safe implementation subclass
  private final X bb = getY(); // bad: could return a non-thread safe implementation subclass
  private final X cc = getZ(); // bad: could return a non-thread safe implementation subclass
}

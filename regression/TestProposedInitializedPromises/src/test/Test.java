package test;

import com.surelogic.Initialized;

class Super {}

public class Test extends Super {
  private int x;
  private int y;
  private int z;
  
  public Test(int a, int b, int c) {
    setX(a); // Should trigger a proposal of @Initialized(through="Super") on receiver of setX()
    setY(b); // Should trigger a proposal of @Initialized(through="Super") on receiver of setY()
    setZ(c); // Should trigger a proposal of @Initialized(through="Super") on receiver of setZ()
    other(this); // Should trigger a proposal of @Initialized(through="Super") on formal 't' of other()
  }
  
  public void doStuff1(@Initialized(through="Object") Test t) {
    t.setX(0); // Should trigger a proposal of @Initialized(through="Object") on receiver of setX()
    t.setY(1); // Should trigger a proposal of @Initialized(through="Object") on receiver of setY()
    t.setZ(2); // Should trigger a proposal of @Initialized(through="Object") on receiver of setZ()
    other(t); // Should trigger a proposal of @Initialized(through="Object") on formal 't' of other()
  }
  
  public void doStuff2(@Initialized(through="Super") Test t) {
    t.setX(0); // Should trigger a proposal of @Initialized(through="Super") on receiver of setX()
    t.setY(1); // Should trigger a proposal of @Initialized(through="Super") on receiver of setY()
    t.setZ(2); // Should trigger a proposal of @Initialized(through="Super") on receiver of setZ()
    other(t); // Should trigger a proposal of @Initialized(through="Super") on formal 't' of other()
  }
  
  
  
  
  public void setX(int v) { x = v; }
  public void setY(int v) { y = v; }
  public void setZ(int v) { z = v; }
  
  public static void other(Test t) {
    // do stuff
  }
}

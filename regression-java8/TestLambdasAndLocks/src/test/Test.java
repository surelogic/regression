package test;

import com.surelogic.RegionLock;
import com.surelogic.RequiresLock;

@RegionLock("LOCK is this protects Instance")
public class Test {
  @SuppressWarnings("unused")
  private int value;
  
  @RequiresLock("LOCK")
  public void foo() {
    // do stuff
  }
  
  public void doStuff(final int x) {
    // Normal access: unprotected
    value = 10;
    foo();
    
    // Normal access: protected
    synchronized (this) {
      value = x;
      foo();
    }
    
    
    
    // Lambdas with preconditions
    final LockedConsumer c1 = o -> o.value = x;
    final LockedConsumer c2 = o -> o.foo();
    
    // unprotected
    c1.consume(this);
    c2.consume(this);
    
    // protected
    synchronized (this) {
      c1.consume(this);
      c2.consume(this);
    }

  
  
    // Lambdas without preconditions
    final UnlockedConsumer c3 = o -> o.value = x;  //bad
    final UnlockedConsumer c4 = o -> o.foo();  // bad
    final UnlockedConsumer c5 = o -> { synchronized (o) { o.value = x; } };  // good
    final UnlockedConsumer c6 = o -> { synchronized (o) { o.foo(); } };  // good
    
    c3.consume(this);
    c4.consume(this);
    c5.consume(this);
    c6.consume(this);
  }



  public void doStuff2(final int x) {
    // Normal access: unprotected
    value = 10;
    foo();
    
    // Normal access: protected
    synchronized (this) {
      value = x;
      foo();
    }
    
    
    
    // Lambdas with preconditions
    final LockedConsumer2 c1 = o -> o.value = x;
    final LockedConsumer2 c2 = o -> o.foo();
    
    // unprotected
    c1.eat(this);
    c2.eat(this);
    
    // protected
    synchronized (this) {
      c1.eat(this);
      c2.eat(this);
    }

  
  
    // Lambdas without preconditions
    final UnlockedConsumer2 c3 = o -> o.value = x;  //bad
    final UnlockedConsumer2 c4 = o -> o.foo();  // bad
    final UnlockedConsumer2 c5 = o -> { synchronized (o) { o.value = x; } };  // good
    final UnlockedConsumer2 c6 = o -> { synchronized (o) { o.foo(); } };  // good
    
    c3.eatAgain(this);
    c4.eatAgain(this);
    c5.eatAgain(this);
    c6.eatAgain(this);
  }



  public void doStuff3(final int x) {
    // Normal access: unprotected
    value = 10;
    foo();
    
    // Normal access: protected
    synchronized (this) {
      value = x;
      foo();
    }
    
    
    
    // Lambdas with preconditions
    final LockedConsumer3 c1 = (o, v) -> o.value = x;
    final LockedConsumer3 c2 = (o, v) -> o.foo();
    
    // unprotected
    c1.stuff(this, 1);
    c2.stuff(this, 2);
    
    // protected
    synchronized (this) {
      c1.stuff(this, 3);
      c2.stuff(this, 4);
    }

  
  
    // Lambdas without preconditions
    final UnlockedConsumer3 c3 = (o, a, b) -> o.value = x;  //bad
    final UnlockedConsumer3 c4 = (o, a, b) -> o.foo();  // bad
    final UnlockedConsumer3 c5 = (o, a, b) -> { synchronized (o) { o.value = x; } };  // good
    final UnlockedConsumer3 c6 = (o, a, b) -> { synchronized (o) { o.foo(); } };  // good
    
    c3.moreStuff(this, 0, 0);
    c4.moreStuff(this, 1, 1);
    c5.moreStuff(this, 2, 2);
    c6.moreStuff(this, 3, 3);
  }
}



// Interfaces with the same signatures: test for binder confusion

interface LockedConsumer {
  @RequiresLock("t:LOCK")
  public void consume(Test t);
}

interface UnlockedConsumer {
  public void consume(Test t);
}



// Different signatures

interface LockedConsumer2 {
  @RequiresLock("t:LOCK")
  public void eat(Test t);
}

interface UnlockedConsumer2 {
  public void eatAgain(Test t);
}



// Even more different signatures

interface LockedConsumer3 {
@RequiresLock("t:LOCK")
  public void stuff(Test t, int v);
}

interface UnlockedConsumer3 {
  public void moreStuff(Test t, int x, int y);
}


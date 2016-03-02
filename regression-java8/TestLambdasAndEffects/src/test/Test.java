package test;

import com.surelogic.RegionEffects;

public class Test {
  private int value;
  
  public void foo() {
    // do stuff
  }
  
  @SuppressWarnings("unused")
  @RegionEffects("reads this:Instance")
  public void doStuff(final Test other) {
    int x = value; // good
    value = 10; // bad
    
    
    
    // Lambdas with preconditions
    final EffectsConsumer c1 = o -> o.value; // good
    final EffectsConsumer c2 = o -> o.value++; // bad
    
    c1.consume(this); // good
    c2.consume(this); // good
    
    c1.consume(other); // bad
    c2.consume(other); // bad

  
  
    // Lambdas without preconditions
    final BareConsumer c3 = o -> o.value; // good
    final BareConsumer c4 = o -> o.value++; // good
  }


  
  @SuppressWarnings("unused")
  @RegionEffects("reads this:Instance")
  public void doStuff2(final Test other) {
    int x = value; // good
    value = 10; // bad
    
    
    
    // Lambdas with preconditions
    final EffectsConsumer2 c1 = o -> o.value; // good
    final EffectsConsumer2 c2 = o -> o.value++; // bad
    
    c1.eat(this); // good
    c2.eat(this); // good
    
    c1.eat(other); // bad
    c2.eat(other); // bad

  
  
    // Lambdas without preconditions
    final BareConsumer2 c3 = o -> o.value; // good
    final BareConsumer2 c4 = o -> o.value++; // good
  }


  
  @SuppressWarnings("unused")
  @RegionEffects("reads this:Instance")
  public void doStuff3(final Test other) {
    int x = value; // good
    value = 10; // bad
    
    
    
    // Lambdas with preconditions
    final EffectsConsumer3 c1 = (o, q) -> o.value; // good
    final EffectsConsumer3 c2 = (o, q) -> o.value = q; // bad
    
    c1.stuff(this, 0); // good
    c2.stuff(this, 1); // good
    
    c1.stuff(other, 2); // bad
    c2.stuff(other, 3); // bad

  
  
    // Lambdas without preconditions
    final BareConsumer3 c3 = (o, a, b) -> o.value; // good
    final BareConsumer3 c4 = (o, a, b) -> o.value += a; // good
  }
}



// Interfaces with the same signatures: test for binder confusion

interface EffectsConsumer {
  @RegionEffects("reads t:Instance")
  public int consume(Test t);
}

interface BareConsumer {
  public int consume(Test t);
}



// Different signatures

interface EffectsConsumer2 {
  @RegionEffects("reads t:Instance")
  public int eat(Test t);
}

interface BareConsumer2 {
  public int eatAgain(Test t);
}



// Even more different signatures

interface EffectsConsumer3 {
  @RegionEffects("reads t:Instance")
  public int stuff(Test t, int v);
}

interface BareConsumer3 {
  public int moreStuff(Test t, int x, int y);
}


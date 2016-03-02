package test;

import com.surelogic.NonNull;
import com.surelogic.TrackPartiallyInitialized;

@TrackPartiallyInitialized
public class Test {
  @NonNull
  private String value;
  
  public Test() {
    value = "";
  }
  
  public void foo(@NonNull Object o) {
    // do stuff
  }
  
  public void doStuff(final int x) {
    value = null; // bad
    value = "good"; // good
    
    foo(null); // bad
    foo("good"); // good
    
    
    
    // Lambdas with preconditions
    final NonNullConsumer c1 = o -> value = o; // good
    final NonNullConsumer c2 = o -> foo(o); // good
    
    c1.consume(null); // bad
    c2.consume(null); // bad
    
    c1.consume("good"); // good
    c2.consume("good"); // good

  
  
    // Lambdas without preconditions
    final MaybeNullConsumer c3 = o -> value = o; // bad
    final MaybeNullConsumer c4 = o -> foo(o); // bad
    final MaybeNullConsumer c5 = o -> value = "good"; // good
    final MaybeNullConsumer c6 = o -> foo("good"); // good
    
    c3.consume(null);
    c4.consume(null);
    c5.consume(null);
    c6.consume(null);
  }



  public void doStuff2(final int x) {
    value = null; // bad
    value = "good"; // good
    
    foo(null); // bad
    foo("good"); // good
    
    
    
    // Lambdas with preconditions
    final NonNullConsumer2 c1 = o -> value = o; // good
    final NonNullConsumer2 c2 = o -> foo(o); // good
    
    c1.eat(null); // bad
    c2.eat(null); // bad
    
    c1.eat("good"); // good
    c2.eat("good"); // good

  
  
    // Lambdas without preconditions
    final MaybeNullConsumer2 c3 = o -> value = o; // bad
    final MaybeNullConsumer2 c4 = o -> foo(o); // bad
    final MaybeNullConsumer2 c5 = o -> value = "good"; // good
    final MaybeNullConsumer2 c6 = o -> foo("good"); // good
    
    c3.eatAgain(null);
    c4.eatAgain(null);
    c5.eatAgain(null);
    c6.eatAgain(null);
  }



  public void doStuff3(final int x) {
    value = null; // bad
    value = "good"; // good
    
    foo(null); // bad
    foo("good"); // good
    
    
    
    // Lambdas with preconditions
    final NonNullConsumer3 c1 = (o, v) -> value = o; // good
    final NonNullConsumer3 c2 = (o, v) -> foo(o); // good
    
    c1.stuff(null, 0); // bad
    c2.stuff(null, 1); // bad
    
    c1.stuff("good", 2); // good
    c2.stuff("good", 3); // good

  
  
    // Lambdas without preconditions
    final MaybeNullConsumer3 c3 = (o, a, b) -> value = o; // bad
    final MaybeNullConsumer3 c4 = (o, a, b) -> foo(o); // bad
    final MaybeNullConsumer3 c5 = (o, a, b) -> value = "good"; // good
    final MaybeNullConsumer3 c6 = (o, a, b) -> foo("good"); // good
    
    c3.moreStuff(null, 0, 0);
    c4.moreStuff(null, 1, 1);
    c5.moreStuff(null, 2, 2);
    c6.moreStuff(null, 3, 3);
  }
}



// Interfaces with the same signatures: test for binder confusion

interface NonNullConsumer {
  public void consume(@NonNull String s);
}

interface MaybeNullConsumer {
  public void consume(String s);
}



// Different signatures

interface NonNullConsumer2 {
  public void eat(@NonNull String t);
}

interface MaybeNullConsumer2 {
  public void eatAgain(String t);
}



// Even more different signatures

interface NonNullConsumer3 {
  public void stuff(@NonNull String t, int v);
}

interface MaybeNullConsumer3 {
  public void moreStuff(String t, int x, int y);
}


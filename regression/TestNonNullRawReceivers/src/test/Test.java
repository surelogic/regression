package test;

import com.surelogic.NonNull;
import com.surelogic.Raw;

public class Test {
  public void doStuff(final @NonNull Object other) {
    // do stuff
  }
  
  @Raw("this")
  public void testRawReceiver() {
    // passing raw receiver to a method that doesn't expect a raw receiver!
    doStuff(this); // receiver is bad, and other is bad
    
    // passing raw receiver to a method that doesn't expect a raw receiver!
    doStuff(1); // receiver is bad, other is good
    
    xxx(this); // bad
    
    new Test().doStuff(2);
  }


  public static void xxx(final Object other) {
    // do stuff
  }
}

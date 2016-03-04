package more;

import com.surelogic.NonNull;
import com.surelogic.Nullable;

public class Test {
  public void doStuff1(final @NonNull Object value) {
    // Implicit nullable: okay
    final NullableInterface q1 = o -> o == null ? "null" : o.toString();

    // Explicit nullable: okay
    final NullableInterface q2 = (@Nullable Object o) -> o == null ? "null" : o.toString();

    // Explicit NonNull: bad
    final NullableInterface q3 = (@NonNull Object o) -> o.toString();
    
    q1.method1(value);
    q2.method1(value);
    q3.method1(value);

    q1.method1(null);
    q2.method1(null);
    q3.method1(null);
  }



  public void doStuff2(final @NonNull Object value) {
    // Implicit nullable: okay
    final NonNullInterface q1 = o -> o == null ? "null" : o.toString();

    // Explicit nullable: okay
    final NonNullInterface q2 = (@Nullable Object o) -> o == null ? "null" : o.toString();

    // Explicit NonNull: okay
    final NonNullInterface q3 = (@NonNull Object o) -> o.toString();
    
    q1.method2(value);
    q2.method2(value);
    q3.method2(value);

    q1.method2(null);
    q2.method2(null);
    q3.method2(null);
  }
  
  
  
  public String needsNonNull(@NonNull Object o) {
    return "string";
  }
  
  public void doStuff3() {
    final NonNullInterface q1 = o -> needsNonNull(o); // good
    final NullableInterface q2 = o -> needsNonNull(o); // bad
    
    // Make sure the flow-analysis happens on the guts of the lambda
    final NullableInterface a1 = o -> {
      Object x;
      if (o == null) {
        x = "X";
      } else {
        x = o;
      }
      return needsNonNull(x); // good
    };
  }
}




interface NullableInterface {
  public String method1(@Nullable Object o);
}

interface NonNullInterface {
  public String method2(@NonNull Object o);
}
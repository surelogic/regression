package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;
import com.surelogic.TrackPartiallyInitialized;

public class TestAnonClassExpression {
  public static void main(String[] args) {
    final X x = new X("Bob") {
      {
        badCall();
      }
      
      @NonNull
      private String s = "Joe";

      {
        badCall();
      }

      private void badCall() {
        System.out.println(name + " " + s);
      }
    };

  
  
    final X xx = new X("Bob") {
      {
        goodCall();
      }
      
      @Nullable
      private String s = "Joe";

      {
        goodCall();
      }

      private void goodCall() {
        System.out.println(name + " " + s);
      }
    };
  }
}


@TrackPartiallyInitialized
class X {
  public String name;
  
  public X(final String n) {
    name = n;
  }
}
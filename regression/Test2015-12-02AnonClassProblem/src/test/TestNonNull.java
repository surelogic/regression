package test;

import com.surelogic.NonNull;

public class TestNonNull {
  public static class CC { 
    @NonNull
    public Object ggg = new Object();
  }
  
  
  
  public void method(final CC cc) {
    new Runnable() {
      public void run() {
        cc.ggg = null;
      }
    };
  }
}

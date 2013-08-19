package test;

import com.surelogic.NonNull;

public class TestInit {
  private @NonNull Object bad;
  private @NonNull Object good = new Object();
  
  private static @NonNull Object badStatic;
  private static @NonNull Object goodStatic1 = new Object();
  private static @NonNull Object goodStatic2;
  private static @NonNull Object goodStatic3;
  
  static {
    goodStatic2 = new Object();
  }
  
  public TestInit() {
    super();
  }
  
  static {
    goodStatic3 = "x";
  }
}

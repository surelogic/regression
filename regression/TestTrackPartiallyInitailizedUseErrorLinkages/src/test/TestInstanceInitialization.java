package test;

import com.surelogic.NonNull;
import com.surelogic.TrackPartiallyInitialized;

@TrackPartiallyInitialized
public class TestInstanceInitialization {
  @NonNull
  protected String name;
  
  {
    TestInstanceInitialization t = this;
    t.bad();
    staticBad(t);
  }
  
  public void bad() {
    // do stuff
  }
  
  public static void staticBad(TestInstanceInitialization t) {
    // do stuff
  }
}

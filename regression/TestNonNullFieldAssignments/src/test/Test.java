package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;
import com.surelogic.TrackPartiallyInitialized;

@TrackPartiallyInitialized
public class Test {
  private Other unannotated;
  private @Nullable Other nullable;
  private @NonNull Other nonNull = null; // bad
  
  private Test t1 = this; // bad: this is currently raw
  private @Nullable Test t2 = this; // bad: this is currently raw
  private @NonNull Test t3 = this; // bad: this is currently raw
  
  public Test() {
    unannotated = null; // good
    nullable = null; // good
    nonNull = null; // bad

    t1 = this; // bad
    t2 = this; // bad
    t3 = this; // bad
    
    // Don't care about unannotated locals
    @NonNull Other o = null; // bad
    Test z = null; // not checked by type checker
    z = this; // not checked by type checker
  }
}

class Other {
  public Other() {
    super();
  }
}
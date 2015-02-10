package test;

import com.surelogic.Initialized;
import com.surelogic.NonNull;
import com.surelogic.TrackPartiallyInitialized;

@TrackPartiallyInitialized
public class TestConstructor {
  @NonNull
  protected String name;
  
  public TestConstructor(@NonNull String s, @Initialized(through="Object") TestConstructor other) {
    super();
    TestConstructor t = this;
    t.bad();
    staticBad(t);
    name = s;
    
    // These should not link to the @TPI
    other.bad2();
    staticBad(other);
    
    goodButIndirectlyBad(t);
  }
  
  public void bad() {
    // do stuff
  }
  
  public static void staticBad(TestConstructor t) {
    // do stuff
  }
  
  public static void goodButIndirectlyBad(@Initialized(through="Object") TestConstructor x) {
    x.bad2();
    staticBad3(x);
  }
  
  
  // Any bad @Initialized uses below should not appear linked to the @TrackPartiallyInitialized annotation
  
  public void enter(@Initialized(through="Object") TestConstructor other) {
    other.bad2();
    staticBad2(other);
    staticBad3(other);
  }
  
  public void bad2() {
    // do stuff
  }
  
  public static void staticBad2(TestConstructor t) {
    // do stuff
  }
  
  public static void staticBad3(@Initialized(through="test.TestConstructor") TestConstructor w) {
    // do stff
  }
}

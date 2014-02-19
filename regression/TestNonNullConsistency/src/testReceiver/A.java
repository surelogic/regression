package testReceiver;

import com.surelogic.Initialized;

public class A {
  // implicitly @NonNull
  public void nonNullReceiver() {}
  
  @Initialized(through="Object", value=" this")
  public void rawStarReceiver() {}
  
  @Initialized(through="java.lang.Object", value="this")
  public void rawObjectReceiver() {}
  
  @Initialized(through="testReceiver.A", value="this")
  public void rawAReceiver() {}
}

class B extends A {
  // good
  @Initialized(through="testReceiver.B", value="this")
  @Override
  public void nonNullReceiver() {}
  
  // bad
  @Initialized(through="testReceiver.B", value="this")
  @Override
  public void rawStarReceiver() {}
  
  // bad
  @Initialized(through="testReceiver.B", value="this")
  @Override
  public void rawObjectReceiver() {}
  
  // bad
  @Initialized(through="testReceiver.B", value="this")
  @Override
  public void rawAReceiver() {}
}

class BB extends A {
  // good
  @Initialized(through="testReceiver.BB", value="this")
  @Override
  public void nonNullReceiver() {}
  
  // bad
  @Initialized(through="testReceiver.BB", value="this")
  @Override
  public void rawStarReceiver() {}
  
  // Good
  @Initialized(through="Object", value=" this")
  @Override
  public void rawObjectReceiver() {}
  
  // Good
  @Initialized(through="java.lang.Object", value="this")
  @Override
  public void rawAReceiver() {}
}

class C extends B {
  // good
  @Initialized(through="testReceiver.A", value="this")
  @Override
  public void nonNullReceiver() {}
  
  // Good -- but method is bad in class B
  @Initialized(through="testReceiver.A", value="this")
  @Override
  public void rawStarReceiver() {}
  
  // Good -- but method is bad in class B
  @Initialized(through="testReceiver.A", value="this")
  @Override
  public void rawObjectReceiver() {}
  
  // bad
  @Initialized(through="testReceiver.C", value="this")
  @Override
  public void rawAReceiver() {}
}
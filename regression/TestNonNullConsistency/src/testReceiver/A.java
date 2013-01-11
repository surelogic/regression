package testReceiver;

import com.surelogic.Raw;

public class A {
  // implicitly @NonNull
  public void nonNullReceiver() {}
  
  @Raw("this")
  public void rawStarReceiver() {}
  
  @Raw(upTo="java.lang.Object", value="this")
  public void rawObjectReceiver() {}
  
  @Raw(upTo="testReceiver.A", value="this")
  public void rawAReceiver() {}
}

class B extends A {
  // good
  @Raw(upTo="testReceiver.B", value="this")
  @Override
  public void nonNullReceiver() {}
  
  // bad
  @Raw(upTo="testReceiver.B", value="this")
  @Override
  public void rawStarReceiver() {}
  
  // bad
  @Raw(upTo="testReceiver.B", value="this")
  @Override
  public void rawObjectReceiver() {}
  
  // bad
  @Raw(upTo="testReceiver.B", value="this")
  @Override
  public void rawAReceiver() {}
}

class BB extends A {
  // good
  @Raw(upTo="testReceiver.BB", value="this")
  @Override
  public void nonNullReceiver() {}
  
  // bad
  @Raw(upTo="testReceiver.BB", value="this")
  @Override
  public void rawStarReceiver() {}
  
  // Good
  @Raw("this")
  @Override
  public void rawObjectReceiver() {}
  
  // Good
  @Raw(upTo="java.lang.Object", value="this")
  @Override
  public void rawAReceiver() {}
}

class C extends B {
  // good
  @Raw(upTo="testReceiver.A", value="this")
  @Override
  public void nonNullReceiver() {}
  
  // Good -- but method is bad in class B
  @Raw(upTo="testReceiver.A", value="this")
  @Override
  public void rawStarReceiver() {}
  
  // Good -- but method is bad in class B
  @Raw(upTo="testReceiver.A", value="this")
  @Override
  public void rawObjectReceiver() {}
  
  // bad
  @Raw(upTo="testReceiver.C", value="this")
  @Override
  public void rawAReceiver() {}
}
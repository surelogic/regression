package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;
import com.surelogic.Raw;

public class TestInit {
  @Nullable
  private B nullableField;
  
  @SuppressWarnings("unused")
  private B unannotatedField;
  
  
  
  @Raw(upTo="A", value="return")
  private B getRawA() { return new B(); }
  
  @Nullable
  public B nullableReturn() { return getRawA(); } // bad
  
  public B unannotatedReturn() { return getRawA(); } // bad
  
  public void nullableParam(@Nullable B param) {
    // do stuff
  }
  
  public void unannotatedParam(B param) {
    // do stuff
  }
  
  
  
  public void passToNullableParam() {
    nullableParam(getRawA()); // bad -- has annotation to use
    unannotatedParam(getRawA()); // bad -- no annotation to use
  }
  
  public void assignToNullableField() {
    nullableField = getRawA(); // bad -- has annotation to use
    unannotatedField = getRawA(); // bad -- no annotation to use
  }
  
  public void other(@NonNull B w) {
    unannotatedField = new B(); // good -- no annotation to use
    unannotatedField = w; // good -- no annotation to use
  }
}

class A {}
class B extends A {}

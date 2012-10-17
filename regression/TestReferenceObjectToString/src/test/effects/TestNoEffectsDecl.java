package test.effects;

import com.surelogic.ReferenceObject;

@ReferenceObject
public class TestNoEffectsDecl {
  public String toString() { // BAD: like writes all
    return "foo";
  }
}

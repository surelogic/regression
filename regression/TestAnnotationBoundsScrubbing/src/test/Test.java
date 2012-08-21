package test;

import com.surelogic.AnnotationBounds;

@AnnotationBounds(
		threadSafe="B",   // B doesn't exist
		containable="F",  // F doesn't exist
		immutable="Y")    // Y doesn't exist
public class Test<A, E, X> {
  @AnnotationBounds(
      threadSafe={"A", "B", "B"},   // A is outer, and B is duplicated
      containable={"E", "F", "F"},  // E is outer, and F is duplicated
      immutable={"X", "Y", "Y"})    // X is outer, and Y is duplicated
  public class Inner2<B, F, Y> {
    // Empty
  }
}

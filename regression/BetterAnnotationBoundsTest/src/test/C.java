package test;

import com.surelogic.AnnotationBounds;
import com.surelogic.ThreadSafe;
import com.surelogic.ValueObject;

/* Actual types passed to A must be a non-empty subset of 
 * {@ThreadSafe, @ReferenceObject}
 */
@AnnotationBounds(threadSafe="A", referenceObject="A")
public class C<A> {
  // not interesting
}

@AnnotationBounds(
    threadSafe="X, Z, V",
    referenceObject="Y, Z",
    valueObject="V, U",
    containable="U")  
class Tester<X, Y, Z, W, V, U> {
  private C<X> f1; // good: thread safe
  private C<Y> f2; // good: refObj
  private C<Z> f3; // good: both
  private C<W> f4; // bad: empty
  private C<V> f5; // bad: non-empty intersection, but not subset
  private C<U> f6; // bad: completely disjoint
  
  private C<Q> f7; // bad: like f5
}

@ValueObject
@ThreadSafe
class Q {
  
}
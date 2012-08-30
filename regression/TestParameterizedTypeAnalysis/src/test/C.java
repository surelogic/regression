package test;

import com.surelogic.AnnotationBounds;

@AnnotationBounds(
    containable="X",
    immutable={"X", "Y"},
    threadSafe={"X", "Y", "Z"})
public class C<X, Y, Z> {

}

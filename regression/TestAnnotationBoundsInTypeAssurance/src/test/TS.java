package test;

import com.surelogic.AnnotationBounds;
import com.surelogic.ThreadSafe;

@ThreadSafe
@AnnotationBounds(immutable="T")
public class TS<T> {
  // do nothing
}

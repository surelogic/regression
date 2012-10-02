package test;

import com.surelogic.AnnotationBounds;
import com.surelogic.Containable;
import com.surelogic.Unique;

@Containable
@AnnotationBounds(immutable="T")
public class Contain<T> {
  @Unique("return")
  public Contain() {
    //  do nothing
  }
}

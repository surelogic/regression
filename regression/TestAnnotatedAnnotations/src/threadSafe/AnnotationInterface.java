package threadSafe;

import com.surelogic.ThreadSafe;

@ThreadSafe
public @interface AnnotationInterface {
  @ThreadSafe
  public @interface NestedAnnotationInterface {
    
  }
}

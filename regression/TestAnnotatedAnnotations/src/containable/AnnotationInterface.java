package containable;

import com.surelogic.Containable;

@Containable
public @interface AnnotationInterface {
  @Containable
  public @interface NestedAnnotationInterface {
    
  }
}

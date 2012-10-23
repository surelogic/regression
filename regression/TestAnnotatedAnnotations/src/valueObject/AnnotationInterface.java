package valueObject;

import com.surelogic.ValueObject;

@ValueObject
public @interface AnnotationInterface {
  @ValueObject
  public @interface NestedAnnotationInterface {
    
  }
}

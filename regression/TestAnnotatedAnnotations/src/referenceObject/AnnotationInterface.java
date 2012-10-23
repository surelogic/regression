package referenceObject;

import com.surelogic.ReferenceObject;

@ReferenceObject
public @interface AnnotationInterface {
  @ReferenceObject
  public @interface NestedAnnotationInterface {
    
  }
}

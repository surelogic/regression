package immutable;

import com.surelogic.Immutable;

@Immutable
public @interface AnnotationInterface {
  @Immutable
  public @interface NestedAnnotationInterface {
    
  }
}

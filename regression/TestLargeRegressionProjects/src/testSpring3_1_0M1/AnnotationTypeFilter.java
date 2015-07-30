package testSpring3_1_0M1;

import java.lang.annotation.*;

public class AnnotationTypeFilter {
	public AnnotationTypeFilter(Class<? extends Annotation> annotationType, boolean considerMetaAnnotations) {
		//super(annotationType.isAnnotationPresent(Inherited.class), false);
		annotationType.isAnnotationPresent(Inherited.class);
	}
}

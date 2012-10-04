package test;

import com.surelogic.AnnotationBounds;

@AnnotationBounds(containable={"T"},
		immutable={"K"},
		referenceObject={"K,V"},
		threadSafe={"V"},
		valueObject={"T"}		
)
public class TestAnnotationBounds<T,K,V> {
	@AnnotationBounds()
	class Inner {
		
	}
}

package equality;

import com.surelogic.AnnotationBounds;
import com.surelogic.Containable;
import com.surelogic.Immutable;
import com.surelogic.ReferenceObject;
import com.surelogic.ThreadSafe;
import com.surelogic.ValueObject;

@AnnotationBounds(referenceObject="X", valueObject="Y")
public class Test<X, Y> {
	
	public static void test() {
		Test<TS, I> v1 = null;
		Test<R, V> v2 = null;
		Test<V, R> v3 = null;
		Test<C, TS> v4 = null;
	}
}



@ThreadSafe
class TS {}

@Immutable
class I {}

@Containable
class C {}

@ValueObject
class V {}

@ReferenceObject
class R {}

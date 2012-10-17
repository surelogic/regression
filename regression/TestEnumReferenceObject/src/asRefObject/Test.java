package asRefObject;

import java.util.concurrent.CopyOnWriteArrayList;

public class Test {
	public Object method() {
		// Should assure with E satisfying the @ReferenceObject constraint
		CopyOnWriteArrayList<E> list;
		return null;
	}

	public Object method2() {
		// Should assure with E satisfying the @ReferenceObject constraint
		CopyOnWriteArrayList<? extends Enum> list;
		return null;
	}
}

// Implicitly @ReferenceObject
enum E {
	A, B, C;
}

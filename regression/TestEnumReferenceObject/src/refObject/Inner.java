package refObject;

import com.surelogic.ReferenceObject;

public class Inner {
	// illegal
	@ReferenceObject
	private enum E {
		A, B, C;
	}
}

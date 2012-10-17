package valObject;

import com.surelogic.ValueObject;

public class Inner {
	// illegal
	@ValueObject
	private enum E {
		A, B, C;
	}
}

package testTrivialMessages.testImmutable;

import com.surelogic.Immutable;
import com.surelogic.Part;

@Immutable(appliesTo=Part.Instance)
public class AppliesToInstanceHasStatic {
	public static int staticF;
}

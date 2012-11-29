package testTrivialMessages.testImmutable;

import com.surelogic.Immutable;
import com.surelogic.Part;

@Immutable(appliesTo=Part.Static)
public class AppliesToStaticHasStatic {
	public static int staticF;
}

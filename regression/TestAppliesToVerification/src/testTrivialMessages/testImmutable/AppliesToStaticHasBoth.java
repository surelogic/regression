package testTrivialMessages.testImmutable;

import com.surelogic.Immutable;
import com.surelogic.Part;

@Immutable(appliesTo=Part.Static)
public class AppliesToStaticHasBoth {
	public static int staticF;
	public int instanceF;
}

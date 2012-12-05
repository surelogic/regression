package testTrivialMessages.testImmutable;

import com.surelogic.Immutable;
import com.surelogic.Part;

@Immutable(appliesTo=Part.Instance)
public class AppliesToInstanceHasBoth {
	public static int staticF;
	public int instanceF;
}
package testTrivialMessages.testThreadSafe;

import com.surelogic.ThreadSafe;
import com.surelogic.Part;

@ThreadSafe(appliesTo=Part.Static)
public class AppliesToStaticHasStatic {
	public static int staticF;
}

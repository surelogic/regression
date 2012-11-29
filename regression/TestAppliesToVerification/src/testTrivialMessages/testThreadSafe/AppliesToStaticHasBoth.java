package testTrivialMessages.testThreadSafe;

import com.surelogic.ThreadSafe;
import com.surelogic.Part;

@ThreadSafe(appliesTo=Part.Static)
public class AppliesToStaticHasBoth {
	public static int staticF;
	public int instanceF;
}

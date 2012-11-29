package testTrivialMessages.testThreadSafe;

import com.surelogic.ThreadSafe;
import com.surelogic.Part;

@ThreadSafe(appliesTo=Part.Instance)
public class AppliesToInstanceHasBoth {
	public static int staticF;
	public int instanceF;
}

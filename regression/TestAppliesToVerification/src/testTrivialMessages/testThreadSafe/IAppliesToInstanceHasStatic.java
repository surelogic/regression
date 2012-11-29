package testTrivialMessages.testThreadSafe;

import com.surelogic.ThreadSafe;
import com.surelogic.Part;

@ThreadSafe(appliesTo=Part.Instance)
public interface IAppliesToInstanceHasStatic {
	public static int staticF = 0;
}

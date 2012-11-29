package testTrivialMessages.testThreadSafe;

import com.surelogic.ThreadSafe;

@ThreadSafe
public interface IAppliesToBothHasStatic {
	public static int staticF = 0;
}

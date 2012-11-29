package testTrivialMessages.testThreadSafe;

import com.surelogic.ThreadSafe;
import com.surelogic.Part;

@ThreadSafe(appliesTo=Part.Static)
public interface IAppliesToStaticHasStatic {
	public static int staticF = 0;
}

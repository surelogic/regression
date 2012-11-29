package testTrivialMessages.testImmutable;

import com.surelogic.Immutable;
import com.surelogic.Part;

@Immutable(appliesTo=Part.Static)
public interface IAppliesToStaticHasStatic {
	public static int staticF = 0;
}

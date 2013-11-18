package test;

import com.surelogic.*;
import static test.TestConstExprsInAnnos.*;

@RegionLocks({
	@RegionLock("L"+_+"is"+_+me+" protects foo"+(1+1))
})
@ThreadSafe(implementationOnly=false ? 1 == 2: true)
public class TestConstExprsInAnnos {
	static final char _ = ' ';
	static final String me = "this";
	int foo2;

	@Borrowed(value=me, allowReturn=true ? 1 == 2: false)
	public TestConstExprsInAnnos() {
	}
}

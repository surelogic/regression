package test;

import com.surelogic.*;

@Promises({
	@Promise("@Unique(return)"),
	@Promise("@Borrowed(this) for **(**)")
})
public class TestPromise {
	Object foo() {
		return null;
	}
}

package test.rcvr;

import com.surelogic.Borrowed;
import com.surelogic.Unique;

public class Root {
	@Unique("this")
	public void unique() {}
	
	public void shared() {}
	
	@Borrowed("this")
	public void borrowed(){}
}

class BorrowedReceiver extends Root {
	// GOOD
	@Borrowed("this")
	public void unique() {}

	// GOOD
	@Borrowed("this")
	public void shared() {}

	// GOOD
	@Borrowed("this")
	public void borrowed() {}
}

class SharedReceiver extends Root {
	// GOOD
	public void unique() {}

	// GOOD
	public void shared() {}

	// BAD
	public void borrowed() {}
}

class UniqueReceiver extends Root {
	// GOOD
	@Unique("this")
	public void unique() {}

	// BAD
	@Unique("this")
	public void shared() {}

	// BAD
	@Unique("this")
	public void borrowed() {}
}

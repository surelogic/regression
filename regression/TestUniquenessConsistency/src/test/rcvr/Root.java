package test.rcvr;

import com.surelogic.Borrowed;
import com.surelogic.Immutable;
import com.surelogic.Unique;

public class Root {
	@Unique("this")
	public void unique() {}
	
	@Unique(value="this", allowRead=true)
	public void allowRead() {}
	
	@Immutable("this")
	public void immutable() {}
	
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
	public void allowRead() {}

	// GOOD
	@Borrowed("this")
	public void immutable() {}

	// GOOD
	@Borrowed("this")
	public void shared() {}

	// GOOD
	@Borrowed("this")
	public void borrowed() {}
}

class ImmutableReceiver extends Root {
	// GOOD
	@Immutable("this")
	public void unique() {}

	// GOOD
	@Immutable("this")
	public void allowRead() {}

	// GOOD
	@Immutable("this")
	public void immutable() {}

	// BAD
	@Immutable("this")
	public void shared() {}

	// BAD
	@Immutable("this")
	public void borrowed() {}
}

class SharedReceiver extends Root {
	// GOOD
	public void unique() {}

	// GOOD
	public void allowRead() {}

	// BAD
	public void immutable() {}

	// GOOD
	public void shared() {}

	// BAD
	public void borrowed() {}
}

class AllowReadReceiver extends Root {
	// GOOD
	@Unique(value="this", allowRead=true)
	public void unique() {}
	
	// GOOD
	@Unique(value="this", allowRead=true)
	public void allowRead() {}

	// BAD
	@Unique(value="this", allowRead=true)
	public void immutable() {}

	// BAD
	@Unique(value="this", allowRead=true)
	public void shared() {}

	// BAD
	@Unique(value="this", allowRead=true)
	public void borrowed() {}
}

class UniqueReceiver extends Root {
	// GOOD
	@Unique("this")
	public void unique() {}

	// BAD
	@Unique("this")
	public void allowRead() {}

	// BAD
	@Unique("this")
	public void immutable() {}

	// BAD
	@Unique("this")
	public void shared() {}

	// BAD
	@Unique("this")
	public void borrowed() {}
}

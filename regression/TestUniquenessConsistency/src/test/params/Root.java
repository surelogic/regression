package test.params;

import com.surelogic.Borrowed;
import com.surelogic.Immutable;
import com.surelogic.Unique;

public class Root {
	public void unique(@Unique Object p) {}
	public void immutable(@Immutable Object p) {}
	public void shared(Object p) {}
	public void borrowed(@Borrowed Object p) {}
}

class BorrowedParam extends Root {
	// GOOD
	public void unique(@Borrowed Object p) {}
	// GOOD
	public void immutable(@Borrowed Object p) {}
	// GOOD
	public void shared(@Borrowed Object p) {}
	// GOOD
	public void borrowed(@Borrowed Object p) {}
}

class ImmutableParam extends Root {
	// GOOD
	public void unique(@Immutable Object p) {}
	// GOOD
	public void immutable(@Immutable Object p) {}
	// BAD
	public void shared(@Immutable Object p) {}
	// BAD
	public void borrowed(@Immutable Object p) {}
}

class SharedParam extends Root {
	// GOOD
	public void unique(Object p) {}
	// BAD
	public void immutable(Object p) {}
	// GOOD
	public void shared(Object p) {}
	// BAD
	public void borrowed(Object p) {}
}

class UniqueParam extends Root {
	// GOOD
	public void unique(@Unique Object p) {}
	// BAD
	public void immutable(@Unique Object p) {}
	// BAD
	public void shared(@Unique Object p) {}
	// BAD
	public void borrowed(@Unique Object p) {}
}

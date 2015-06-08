package test.params;

import com.surelogic.Borrowed;
import com.surelogic.Unique;

public class Root {
	public void unique(@Unique Object p) {}
	public void shared(Object p) {}
	public void borrowed(@Borrowed Object p) {}
}

class BorrowedParam extends Root {
	// GOOD
	public void unique(@Borrowed Object p) {}
	// GOOD
	public void shared(@Borrowed Object p) {}
	// GOOD
	public void borrowed(@Borrowed Object p) {}
}

class SharedParam extends Root {
	// GOOD
	public void unique(Object p) {}
	// GOOD
	public void shared(Object p) {}
	// BAD
	public void borrowed(Object p) {}
}

class UniqueParam extends Root {
	// GOOD
	public void unique(@Unique Object p) {}
	// BAD
	public void shared(@Unique Object p) {}
	// BAD
	public void borrowed(@Unique Object p) {}
}

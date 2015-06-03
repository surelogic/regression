package test.returns;

import com.surelogic.Immutable;
import com.surelogic.Unique;

public class Root {
	@Unique("return")
	public Object unique() { return null; }
	
	@Immutable("return")
	public Object immutable() { return null; }
	
	public Object shared() { return null; }
}

class ImmutableReturn extends Root {
	// BAD
	@Immutable("return")
	public Object unique() { return null; }

	// GOOD
	@Immutable("return")
	public Object immutable() { return null; }

	// BAD
	@Immutable("return")
	public Object shared() { return null; }
}

class SharedReturn extends Root {
	// BAD
	public Object unique() { return null; }

	// BAD
	public Object immutable() { return null; }

	// GOOD
	public Object shared() { return null; }
}

class UniqueReturn extends Root {
	// GOOD
	@Unique("return")
	public Object unique() { return null; }

	// GOOD
	@Unique("return")
	public Object immutable() { return null; }

	// GOOD
	@Unique("return")
	public Object shared() { return null; }
}

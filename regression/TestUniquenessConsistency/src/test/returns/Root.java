package test.returns;

import com.surelogic.Immutable;
import com.surelogic.Unique;

public class Root {
	@Unique("return")
	public Object unique() { return null; }
	
	@Unique(value="return", allowRead=true)
	public Object allowRead() { return null; }
	
	@Immutable("return")
	public Object immutable() { return null; }
	
	public Object shared() { return null; }
}

class ImmutableReturn extends Root {
	// BAD
	@Immutable("return")
	public Object unique() { return null; }

	// BAD
	@Immutable("return")
	public Object allowRead() { return null; }

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
	public Object allowRead() { return null; }

	// BAD
	public Object immutable() { return null; }

	// GOOD
	public Object shared() { return null; }
}

class AllowReadReturn extends Root {
	// BAD
	@Unique(value="return", allowRead=true)
	public Object unique() { return null; }
	
	// GOOD
	@Unique(value="return", allowRead=true)
	public Object allowRead() { return null; }

	// GOOD
	@Unique(value="return", allowRead=true)
	public Object immutable() { return null; }

	// GOOD
	@Unique(value="return", allowRead=true)
	public Object shared() { return null; }
}

class UniqueReturn extends Root {
	// GOOD
	@Unique("return")
	public Object unique() { return null; }

	// GOOD
	@Unique("return")
	public Object allowRead() { return null; }

	// GOOD
	@Unique("return")
	public Object immutable() { return null; }

	// GOOD
	@Unique("return")
	public Object shared() { return null; }
}

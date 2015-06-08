package test.returns;

import com.surelogic.Unique;

public class Root {
	@Unique("return")
	public Object unique() { return null; }
	
	public Object shared() { return null; }
}

class SharedReturn extends Root {
	// BAD
	public Object unique() { return null; }

	// GOOD
	public Object shared() { return null; }
}

class UniqueReturn extends Root {
	// GOOD
	@Unique("return")
	public Object unique() { return null; }

	// GOOD
	@Unique("return")
	public Object shared() { return null; }
}

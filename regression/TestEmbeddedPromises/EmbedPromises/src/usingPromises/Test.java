package usingPromises;

import com.surelogic.*;

@Immutable(implementationOnly=true)
@Region("Foo")
@RegionLock("L is this protects Foo")
@Promises({
	@Promise("@InRegion(Foo)"),
	@Promise("@RequiresLock(L) for *(**)")
})
public class Test {
	@Unique(allowRead=true)
	Test() {
		foo = 0;
	}
	
	@ReturnsLock("L")
	Object foo() {
		return null;
	}
	
	@InRegion("Foo")
	final int foo;
}

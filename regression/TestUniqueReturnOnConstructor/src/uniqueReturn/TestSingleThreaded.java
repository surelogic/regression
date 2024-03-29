package uniqueReturn;

import com.surelogic.RegionEffects;
import com.surelogic.Starts;
import com.surelogic.Unique;

public class TestSingleThreaded {
	public Object alias;
	private int value;
	
	@Unique("return")
	public TestSingleThreaded() {
		value = 0;
	}
	
	@Starts("nothing")
	@RegionEffects("none")
	public TestSingleThreaded(final int v) {
		value = v;
	}
	
	@Starts("nothing")
	@RegionEffects("none")
	@Unique("return")
	public TestSingleThreaded(final int v, final int w) {
		value = v + w;
	}
	
	@Starts("nothing")
	@RegionEffects("none")
	@Unique("return")  // violated by this one
	public TestSingleThreaded(final int v, final int w, final int z) {
		value = v + w + z;
		alias = this;
	}
	
	@Starts("nothing")// violated by this one
	@RegionEffects("none")
	@Unique("return")
	public TestSingleThreaded(final int v, final int w, final int z, final int zz) {
		value = v + w + z + zz;
		final Thread t = new Thread();
		t.start();
	}
}

package opLoad.viaTransferUseField.sharedQualifiedReceiver;

import com.surelogic.RegionEffects;
import com.surelogic.Unique;

class Other {
	@RegionEffects("none")
	@Unique("return")
	public Other() {
		super();
	}
	
	class Inner {
		@RegionEffects("writes Other.this:Instance")
		@Unique("return")
		public Inner() {
			super();
		}
	}	
}

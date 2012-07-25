package opLoadReachable.viaConsiderDeclaredEffects.viaTransferCall.sharedReceiver;

import com.surelogic.RegionEffects;
import com.surelogic.Unique;

class Other {
	@RegionEffects("none")
	@Unique("return")
	public Other() {
		super();
	}
	
	@RegionEffects("none")
	public void call() {
		// foo
	}
}

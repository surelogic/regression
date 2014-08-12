package test;

import com.surelogic.Region;
import com.surelogic.RegionLock;
import com.surelogic.RegionLocks;
import com.surelogic.Regions;

import java.util.concurrent.locks.Lock;

@Regions({
	@Region("private R1"),
	@Region("private R2")
})
@RegionLocks({
	@RegionLock("L1 is lock1 protects R1"),
	@RegionLock("L2 is lock2 protects R2")
})
public class TwoModels {
	private final Lock lock1 = null;
	private final Lock lock2 = null;
	
}

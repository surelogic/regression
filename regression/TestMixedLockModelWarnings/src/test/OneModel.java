package test;

import com.surelogic.Region;
import com.surelogic.RegionLock;
import com.surelogic.Regions;

import java.util.concurrent.locks.Lock;

@Regions({
	@Region("private R1"),
	@Region("private R2")
})
@RegionLock("L1 is lock1 protects R1")
public class OneModel {
	private final Lock lock1 = null;
	private final Lock lock2 = null;
	
}

package test;

import com.surelogic.*;

@RegionLock("Lock is this protects Instance")
@Promise("@Borrowed(this) for new(**)")
public class Example {
	int x = 1;
	int y = 1;
}

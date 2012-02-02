import java.util.LinkedList;

import com.surelogic.*;

@Assume("@Borrowed(this) for !static **(**) in LinkedList in java.util")

@ThreadSafe
@RegionLock("lock is this protects Instance")
/*
@Assumes({
    @Assume("@Containable for LinkedList in java.util"), // not realy true
    @Assume("@Containable for AbstractSequentialList in java.util") // not realy true
})
*/
public class ListClient {
	@Unique
	@Assume("@Containable for LinkedList in java.util") // not realy true
	LinkedList<Object> x = new LinkedList<Object>();
	
	@Unique("return")
	public ListClient() {}

	public synchronized void push(@Unique Object o) {
		x.add(o);
		notifyAll();
	}
	
      @Unique("return")
	public synchronized Object pull() throws InterruptedException {
		while (x.isEmpty()) {
			wait();
		}
		return x.remove();
	}
}

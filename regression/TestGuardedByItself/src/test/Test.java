package test;

import com.surelogic.GuardedBy;
import com.surelogic.RegionEffects;

public class Test {
	@GuardedBy("itself")
	private final Other other = new Other();
	@GuardedBy("itself")
	private final int[] array = new int[10];


	
	public void method() {
		int v;
		
		other.x = 10;		
		v = other.x;
		array[0] = 10;
		v = array[1];
		other.doStuff();
		
		synchronized (other) {
			other.x = 10;
			v = other.x;
			other.doStuff();
		}
		synchronized (array) {
			array[0] = 10;
			v = array[1];
		}
	}
}


class Other {
	public int x;
	
	@RegionEffects("writes Instance")
	public void doStuff() {}
}
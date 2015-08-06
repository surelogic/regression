package testJSure;

import java.util.*;

public class PromiseDropStorage {
	private static List<BooleanPromiseDropStorage<? extends BooleanPromiseDrop<?>>> booleans = 
			new ArrayList<BooleanPromiseDropStorage<? extends BooleanPromiseDrop<?>>>();
		private static List<SinglePromiseDropStorage<? extends PromiseDrop<?>>> nodes = 
			new ArrayList<SinglePromiseDropStorage<? extends PromiseDrop<?>>>();
	
	public static void clearDrops(IRNode n) {
		for(BooleanPromiseDropStorage<?> b : booleans) {
			if (b.getSlotInfo() == null) {
				continue;
			}
			BooleanPromiseDrop<?> o = n.getSlotValue(b.getSlotInfo());
			/*
			if (o != null) {
				//System.out.println("Cleared: "+b.name()+" on "+n);
				o.invalidate();
				n.setSlotValue(b.getSlotInfo(), null);			
			}
			*/
		}
		for(SinglePromiseDropStorage<?> s : nodes) {
			if (s.getSlotInfo() == null) {
				continue;
			}
			PromiseDrop<?> o = n.getSlotValue(s.getSlotInfo());
		}
	}
}

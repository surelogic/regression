package testBinder.typeSubBetweenOuterInnerClasses;

import java.io.IOException;

public class ReduceContext<KEYIN,VALUEIN,KEYOUT,VALUEOUT> {
	public boolean nextKey() throws IOException,InterruptedException {
		return true;
	}
	
	public KEYIN getCurrentKey() {
		return null;
	}
}


package test;

import com.surelogic.*;

public class VerifyConstComputation {
	static final double DOUBLE_ONE = 1.0;
	static final float MAX_FLOAT = Float.MAX_VALUE;
	static final float MIN_FLOAT = - Float.MAX_VALUE;
	static final long LONG_ONE = 1L;
	static final int MAX_INT = Integer.MAX_VALUE;
	static final int MIN_INT = Integer.MIN_VALUE;
	
	@Assumes({
		@Assume("Overflow: "+(MAX_INT + 1)),
		@Assume("Ok      : "+(MAX_INT + LONG_ONE)),
		@Assume("Overflow: "+(MAX_FLOAT + 1)),
		@Assume("Ok      : "+(MAX_FLOAT + DOUBLE_ONE)),
	})
	void add() {}
	
	@Assumes({
		@Assume("Overflow: "+(MAX_INT * 2)),
		@Assume("Ok      : "+(MAX_INT * (1+LONG_ONE))),
		@Assume("Overflow: "+(MAX_FLOAT * 2)),
		@Assume("Ok      : "+(MAX_FLOAT * (1+DOUBLE_ONE))),
	})
	void multiply() {}
	
	@Assumes({
		@Assume("Overflow: "+(MIN_INT - 1)),
		@Assume("Ok      : "+(MIN_INT - LONG_ONE)),
		@Assume("Overflow: "+(MIN_FLOAT - 1)),
		@Assume("Ok      : "+(MIN_FLOAT - DOUBLE_ONE)),
	})
	void subtract() {}
	
	@Assumes({
		//@Assume("Overflow: "+(MIN_INT / 2)),
		//@Assume("Ok      : "+(MIN_INT / LONG_ONE)),
		@Assume("Overflow: "+(Float.MIN_VALUE / 2)),
		@Assume("Ok      : "+(Float.MIN_VALUE / (1+DOUBLE_ONE))),
	})
	void divide() {}
	
	@Assumes({
		@Assume("Ok      : "+(100 % 7)),
		@Assume("Ok      : "+(100 % 7L)),
		@Assume("Overflow: "+(100.5f % 7)),
		@Assume("Ok      : "+(100.5f % 7.2)),
	})
	void mod() {}
	
	@Assumes({
		@Assume("Ok      : "+(100 & 7)),
		@Assume("Ok      : "+(0x100000000L & 7)),
	})
	void and() {}
		
	@Assumes({
		@Assume("Ok      : "+(100 | 7)),
		@Assume("Ok      : "+(0x100000000L | 7)),
	})
	void or() {}
		
	@Assumes({
		@Assume("Ok      : "+(100 ^ 7)),
		@Assume("Ok      : "+(0x100000000L ^ 7)),
	})
	void xor() {}
}

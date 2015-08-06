package testJSure;

public class TestJSure {
	void test() {
		final ModifiedBooleanPromiseDrop<?> d = null;
		boolean rv = isStaticOnly(d);
		
		final PromiseDrop<? extends IAASTRootNode> p = null;
		final ResultDrop result = new ResultDrop(/*context*/);
		result.addChecked(p);
	}
	
    protected final boolean isStaticOnly(final ModifiedBooleanPromiseDrop<? extends AbstractModifiedBooleanNode> drop) {
    	return false;
    }
}

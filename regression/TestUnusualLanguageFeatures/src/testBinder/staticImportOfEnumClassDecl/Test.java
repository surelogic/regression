package testBinder.staticImportOfEnumClassDecl;

import static testBinder.staticImportOfEnumClassDecl.EventType.Lock;

/**
 * Originally from flashlight
 * 
 * @author Edwin
 */
public class Test {	
	/**
	 * Lock can bind to the import, instead of the type in the package
	 */
	void writeLockEvent(byte header, Lock e) {
		// Nothing to do right now
	}
	
	void test(Child e) {
		writeLockEvent((byte) 0, e);
	}
}

package testBinder.genericMethod;

import java.util.EnumSet;

public class Test3 {
	Object foo() {
		// Also fails below, so it's not because of the varargs overloading
		//return EnumSet.of(HttpMethod.GET, HttpMethod.OPTIONS, HttpMethod.HEAD, HttpMethod.TRACE);
		return EnumSet.of(HttpMethod.GET);
	}
}

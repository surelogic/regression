package testBinder;

import java.io.*;
import java.util.*;

class TestGenericMethods {
	public static <base, T extends base> 
	T getOption(Class<T> cls, base [] opts) throws IOException {
		return null;
	}

	static void test() throws IOException {
		// Type inference is currently too naive?
		Object[] opts = new Object[]{1, "hi", true, "bye", 'x'};
		getOption(Integer.class, opts).intValue();

		List l = null;
		Comparator c = null;
		Collections.sort(l, c);
	}
}
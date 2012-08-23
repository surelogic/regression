package testBinder.polymorphicMethods;

import java.util.*;

public class TestPolyMethods {
	public static void main(String[] args) {
		List key = null;
		Arrays.binarySearch(args, key, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return 0;
			}});
	}
}

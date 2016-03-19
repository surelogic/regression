package testVertx.codegen;

import java.util.*;

public class JsonArray implements Iterable<Object>/*, ClusterSerializable*/ {
	private List<Object> list;

	/**
	 * Create an instance from a String of JSON
	 *
	 * @param json the string of JSON
	 */
	public JsonArray(String json) {
		fromJson(json);
	}

	/**
	 * Create an empty instance
	 */
	public JsonArray() {
		list = new ArrayList<>();
	}

	/**
	 * Create an instance from a List. The List is not copied.
	 *
	 * @param list
	 */
	public JsonArray(List list) {
		this.list = list;
	}

	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	private void fromJson(String json) {		
	}
}

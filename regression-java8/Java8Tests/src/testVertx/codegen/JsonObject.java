package testVertx.codegen;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class JsonObject implements Iterable<Map.Entry<String, Object>>/*, ClusterSerializable*/ {

	@Override
	public Iterator<Entry<String, Object>> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public JsonObject put(String key, JsonArray value) {
		return null;
	}
	
	public JsonObject put(String key, Object value) {
		return null;
	}
}

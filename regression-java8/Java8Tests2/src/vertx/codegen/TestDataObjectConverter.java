package vertx.codegen;

import vertx.json.*;

public class TestDataObjectConverter {
	public static void toJson(TestDataObject obj, JsonObject json) {
	    if (obj.getStringValues() != null) {
	    	/* BROKEN computeB_4
	    	 * 
	        json.put("stringValues", new JsonArray(
	            obj.getStringValues().
	                stream().
	                map(item -> item).
	                collect(java.util.stream.Collectors.toList())));
	                */
	      }		
	}
}

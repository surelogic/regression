package testVertx.codegen;

public class TestDataObjectConverter {
	public static void toJson(TestDataObject obj, JsonObject json) {
	    if (obj.getJsonObjects() != null) {
	        json.put("jsonObjects", new JsonArray(
	            obj.getJsonObjects().
	                stream().
	                map(item -> item).
	                collect(java.util.stream.Collectors.toList())));
	    }		
	}
}

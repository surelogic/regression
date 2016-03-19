package testVertx.codegen;

public class DeploymentOptionsConverter {
	public static void toJson(DeploymentOptions obj, JsonObject json) {
		if (obj.getIsolatedClasses() != null) {
			json.put("isolatedClasses", new JsonArray(
					obj.getIsolatedClasses().
					stream().
					map(item -> item).
					collect(java.util.stream.Collectors.toList())));
		}
	}
}

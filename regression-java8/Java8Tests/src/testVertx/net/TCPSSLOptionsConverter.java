package testVertx.net;

import testVertx.codegen.*;

public class TCPSSLOptionsConverter {
	  public static void toJson(TCPSSLOptions obj, JsonObject json) {
		    if (obj.getCrlValues() != null) {
		      json.put("crlValues", new JsonArray(
		          obj.getCrlValues().
		              stream().
		              map(item -> item.getBytes()).
		              collect(java.util.stream.Collectors.toList())));
		    }
	  }
}

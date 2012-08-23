package testBinder;

import static testBinder.Info.*;

class TestNameResolution {
	private String processName;
	private String sessionId;

	//private Object TestNameResolution;
	
	TestNameResolution(String processName, String sessionId) {
		this.processName = processName;
		this.sessionId = sessionId;
	}

	public static TestNameResolution create(String processName, String sessionId,
			MetricsSystem ms) {
		return ms.register(TestNameResolution.name(), TestNameResolution.description(),
				new TestNameResolution(processName, sessionId));
	}
}

enum Info {
	TestNameResolution;
	
	String description() {
		return null;
	}
}
 
class MetricsSystem {
	TestNameResolution register(String name, String description,
			TestNameResolution testNameResolution) {
		// TODO Auto-generated method stub
		return null;
	}	
}
package testHadoop;

import java.util.EnumSet;

public class TestRMRestart {
	void main() {
	    GetApplicationsRequest request1 =
	            GetApplicationsRequest.newInstance(EnumSet.of(
	              YarnApplicationState.FINISHED, YarnApplicationState.KILLED,
	              YarnApplicationState.FAILED));
	}
}

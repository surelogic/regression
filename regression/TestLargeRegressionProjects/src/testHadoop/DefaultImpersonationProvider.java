package testHadoop;

public class DefaultImpersonationProvider {//implements ImpersonationProvider {
	public static synchronized DefaultImpersonationProvider getTestProvider() {
		return null;
	}
	
	public String getProxySuperuserGroupConfKey(String userName) {
		return null;
	}
}

package testHadoop;

import java.io.*;

public class YARNRunner implements ClientProtocol {
	void addHistoryToken(Credentials ts) throws IOException, InterruptedException {
		/* check if we have a hsproxy, if not, no need */
		MRClientProtocol hsProxy = null;//clientCache.getInitializedHSProxy();
		if (true) {//UserGroupInformation.isSecurityEnabled() && (hsProxy != null)) {
			/*
			 * note that get delegation token was called. Again this is hack for oozie
			 * to make sure we add history server delegation tokens to the credentials
			 */
			RMDelegationTokenSelector tokenSelector = new RMDelegationTokenSelector();
			Text service = null;//resMgrDelegate.getRMDelegationTokenService();
			if (tokenSelector.selectToken(service, ts.getAllTokens()) != null) {
				Text hsService = null;//SecurityUtil.buildTokenService(hsProxy.getConnectAddress());
				if (true) {//ts.getToken(hsService) == null) {
					ts.addToken(hsService, getDelegationTokenFromHS(hsProxy));
				}
			}
		}
	}
	
	Token<?> getDelegationTokenFromHS(MRClientProtocol hsProxy)
			throws IOException, InterruptedException {
		return null;
	}
}

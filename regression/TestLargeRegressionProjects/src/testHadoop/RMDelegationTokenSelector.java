package testHadoop;

import java.util.Collection;

public class RMDelegationTokenSelector /*implements
TokenSelector<RMDelegationTokenIdentifier>*/ {
	/*
	private static final Log LOG = LogFactory
			.getLog(RMDelegationTokenSelector.class);

	private boolean checkService(Text service,
			Token<? extends TokenIdentifier> token) {
		if (service == null || token.getService() == null) {
			return false;
		}
		return token.getService().toString().contains(service.toString());
	}
    */
	@SuppressWarnings("unchecked")
	public Token<RMDelegationTokenIdentifier> selectToken(Text service,
			Collection<Token<? extends TokenIdentifier>> tokens) {
		/*
		if (service == null) {
			return null;
		}
		LOG.debug("Looking for a token with service " + service.toString());
		for (Token<? extends TokenIdentifier> token : tokens) {
			LOG.debug("Token kind is " + token.getKind().toString()
					+ " and the token's service name is " + token.getService());
			if (RMDelegationTokenIdentifier.KIND_NAME.equals(token.getKind())
					&& checkService(service, token)) {
				return (Token<RMDelegationTokenIdentifier>) token;
			}
		}
		*/
		return null;
	}

}

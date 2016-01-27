package testVertx.net;

import testVertx.ContextImpl;

public abstract class ConnectionBase {
	protected abstract void handleInterestedOpsChanged();	
	
	protected ContextImpl getContext() {
		return null;
	}
}

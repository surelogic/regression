package testVertx;

public abstract class ContextImpl implements ContextInternal {
	// This is called to execute code where the origin is IO (from Netty probably).
	// In such a case we should already be on an event loop thread (as Netty manages the event loops)
	// but check this anyway, then execute directly
	public void executeFromIO(ContextTask task) {
	}
	
	public static void setContext(ContextImpl context) {		
	}
}
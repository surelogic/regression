package testVertx;

import java.util.*;

public class HAManager {
	private final VertxInternal vertx = null;
	private final Map<String, String> clusterMap = null;
	private volatile boolean stopped;
	
	private synchronized void checkQuorumWhenAdded(final String nodeID, final long start) {
		if (clusterMap.containsKey(nodeID)) {
			//checkQuorum();
		} else {
			vertx.setTimer(200, tid -> {
				// This can block on a monitor so it needs to run as a worker
				vertx.executeBlockingInternal(() -> {
					if (System.currentTimeMillis() - start > 10000) {
						System.out.println/*log.warn*/("Timed out waiting for group information to appear");
					} else if (!stopped) {
						ContextImpl context = vertx.getContext();
						try {
							// Remove any context we have here (from the timer) otherwise will screw things up when verticles are deployed
							ContextImpl.setContext(null);
							checkQuorumWhenAdded(nodeID, start);
						} finally {
							ContextImpl.setContext(context);
						}
					}
					return null;
				}, null);
			});
		}
	}
}

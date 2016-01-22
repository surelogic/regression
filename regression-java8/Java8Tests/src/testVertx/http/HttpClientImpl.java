package testVertx.http;

import testVertx.Closeable;
import testVertx.Future;

public class HttpClientImpl implements HttpClient, MetricsProvider {
	private final Closeable closeHook;

	public HttpClientImpl(/*VertxInternal vertx, HttpClientOptions options*/) {
		/*
		this.vertx = vertx;
		this.options = new HttpClientOptions(options);
		this.sslHelper = new SSLHelper(options, KeyStoreHelper.create(vertx, options.getKeyCertOptions()), KeyStoreHelper.create(vertx, options.getTrustOptions()));
		this.creatingContext = vertx.getContext();
		 */
		closeHook = completionHandler -> {
			HttpClientImpl.this.close();
			completionHandler.handle(Future.succeededFuture());
		};
		/*
		if (creatingContext != null) {
			if (creatingContext.isMultiThreadedWorkerContext()) {
				throw new IllegalStateException("Cannot use HttpClient in a multi-threaded worker verticle");
			}
			creatingContext.addCloseHook(closeHook);
		}
		pool = new ConnectionManager(options.getMaxPoolSize(), options.isKeepAlive(), options.isPipelining())  {
			protected void connect(String host, int port, Handler<ClientConnection> connectHandler, Handler<Throwable> connectErrorHandler, ContextImpl context,
					ConnectionLifeCycleListener listener) {
				internalConnect(context, port, host, connectHandler, connectErrorHandler, listener);
			}
		};
		this.metrics = vertx.metricsSPI().createMetrics(this, options);
		 */
	}

	@Override
	public synchronized void close() {
		/*
		checkClosed();
		pool.close();
		for (ClientConnection conn : connectionMap.values()) {
			conn.close();
		}
		if (creatingContext != null) {
			creatingContext.removeCloseHook(closeHook);
		}
		closed = true;
		metrics.close();
		*/
	}	
}

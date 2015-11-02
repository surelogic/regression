package testHadoop;

import java.util.Date;

import org.apache.commons.logging.*;

public class SelfThrottlingIntercept {
	public static final Log LOG = LogFactory
		      .getLog(SelfThrottlingIntercept.class);
	
	public void responseReceived(/*ResponseReceivedEvent event*/) {
		/*
		RequestResult result = event.getRequestResult();
		Date startDate = result.getStartDate();
		Date stopDate = result.getStopDate();
	    */
		long elapsed = 0;//stopDate.getTime() - startDate.getTime();
        /*
		synchronized (this) {
			this.lastE2Elatency = elapsed;
		}
		 */
		if (LOG.isDebugEnabled()) {
			int statusCode = 0;//result.getStatusCode();
			String etag = "";//result.getEtag();
			/*
			HttpURLConnection urlConnection = (HttpURLConnection) event
					.getConnectionObject();
			*/
			int contentLength = 0;//urlConnection.getContentLength();
			String requestMethod = "";//urlConnection.getRequestMethod();
			long threadId = 0;//Thread.currentThread().getId();			
			LOG.debug(String
					.format(
							"SelfThrottlingIntercept:: ResponseReceived: threadId=%d, Status=%d, Elapsed(ms)=%d, ETAG=%s, contentLength=%d, requestMethod=%s",
							threadId, statusCode, elapsed, etag, contentLength, requestMethod));
		}
	}
}

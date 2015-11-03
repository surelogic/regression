package testHadoop;

import java.util.concurrent.TimeoutException;

class QuorumCall<KEY, RESULT> {
	public synchronized void waitFor(
			int minResponses, int minSuccesses, int maxExceptions,
			int millis, String operationName)
					throws InterruptedException, TimeoutException {
		long st = 0;//Time.monotonicNow();
		long nextLogTime = 0;//st + (long)(millis * WAIT_PROGRESS_INFO_THRESHOLD);
		long et = st + millis;
		while (true) {
			/*
			checkAssertionErrors();
			if (minResponses > 0 && countResponses() >= minResponses) return;
			if (minSuccesses > 0 && countSuccesses() >= minSuccesses) return;
			if (maxExceptions >= 0 && countExceptions() > maxExceptions) return;
			*/
			long now = 0;//Time.monotonicNow();
            
			if (now > nextLogTime) {
				long waited = now - st;
				String msg = String.format(
						"Waited %s ms (timeout=%s ms) for a response for %s",
						waited, millis, operationName);
				/*
				if (!successes.isEmpty()) {
					msg += ". Succeeded so far: [" + Joiner.on(",").join(successes.keySet()) + "]";
				}
				if (!exceptions.isEmpty()) {
					msg += ". Exceptions so far: [" + getExceptionMapString() + "]";
				}
				if (successes.isEmpty() && exceptions.isEmpty()) {
					msg += ". No responses yet.";
				}
				if (waited > millis * WAIT_PROGRESS_WARN_THRESHOLD) {
					QuorumJournalManager.LOG.warn(msg);
				} else {
					QuorumJournalManager.LOG.info(msg);
				}
				nextLogTime = now + WAIT_PROGRESS_INTERVAL_MILLIS;
				*/
			}
			long rem = et - now;
			if (rem <= 0) {
				throw new TimeoutException();
			}
			rem = Math.min(rem, nextLogTime - now);
			rem = Math.max(rem, 1);
			wait(rem);
		}
	}
}

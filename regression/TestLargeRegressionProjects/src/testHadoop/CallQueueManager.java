package testHadoop;

import java.lang.reflect.Constructor;
import java.util.concurrent.BlockingQueue;

public class CallQueueManager<E> {
	private <T extends BlockingQueue<E>> T createCallQueueInstance(
			Class<T> theClass, int maxLen, String ns, Configuration conf) {

		// Used for custom, configurable callqueues
		try {
			Constructor<T> ctor = theClass.getDeclaredConstructor(int.class, String.class,
					Configuration.class);
			return ctor.newInstance(maxLen, ns, conf);
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
		}

		// Used for LinkedBlockingQueue, ArrayBlockingQueue, etc
		try {
			Constructor<T> ctor = theClass.getDeclaredConstructor(int.class);
			return ctor.newInstance(maxLen);
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
		}

		// Last attempt
		try {
			Constructor<T> ctor = theClass.getDeclaredConstructor();
			return ctor.newInstance();
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
		}

		// Nothing worked
		throw new RuntimeException(theClass.getName() +
				" could not be constructed.");
	}
}

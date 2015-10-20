package testHadoop;

import java.io.IOException;

public class MultithreadedMapper<K1, V1, K2, V2> 
extends Mapper<K1, V1, K2, V2> {
	private Class<? extends Mapper<K1,V1,K2,V2>> mapClass;
	//private Context outer;
	//private List<MapRunner> runners;
	  
	/**
	 * Get the application's mapper class.
	 * @param <K1> the map's input key type
	 * @param <V1> the map's input value type
	 * @param <K2> the map's output key type
	 * @param <V2> the map's output value type
	 * @param job the job
	 * @return the mapper class to run
	 */
	@SuppressWarnings("unchecked")
	public static <K1,V1,K2,V2>
	Class<Mapper<K1,V1,K2,V2>> getMapperClass(JobContext job) {
		/*
		return (Class<Mapper<K1,V1,K2,V2>>) 
				job.getConfiguration().getClass(MAP_CLASS, Mapper.class);
				*/
		return null;
	}	

	/**
	 * Run the application's maps using a thread pool.
	 */
	@Override
	public void run(Context context) throws IOException, InterruptedException {
		//outer = context;
		//int numberOfThreads = getNumberOfThreads(context);
		mapClass = getMapperClass(context);
		/*
		if (LOG.isDebugEnabled()) {
			LOG.debug("Configuring multithread runner to use " + numberOfThreads + 
					" threads");
		}

		runners =  new ArrayList<MapRunner>(numberOfThreads);
		for(int i=0; i < numberOfThreads; ++i) {
			MapRunner thread = new MapRunner(context);
			thread.start();
			runners.add(i, thread);
		}
		for(int i=0; i < numberOfThreads; ++i) {
			MapRunner thread = runners.get(i);
			thread.join();
			Throwable th = thread.throwable;
			if (th != null) {
				if (th instanceof IOException) {
					throw (IOException) th;
				} else if (th instanceof InterruptedException) {
					throw (InterruptedException) th;
				} else {
					throw new RuntimeException(th);
				}
			}
		}
		*/
	}	
}

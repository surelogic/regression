package testHadoop;

import java.io.IOException;

abstract public class Task implements Writable/*, Configurable*/ {
	public static abstract class CombinerRunner<K,V> {
		protected final Counters.Counter inputCounter = null;
		protected final JobConf job = null;
		protected final TaskReporter reporter = null;	
	}
	protected static class NewCombinerRunner<K, V> extends CombinerRunner<K,V> {
		private final Class<? extends /*org.apache.hadoop.mapreduce.*/Reducer<K,V,K,V>> 
	        reducerClass = null;
	    private final /*org.apache.hadoop.mapreduce.*/TaskAttemptID taskId = null;
	    private final RawComparator<K> comparator = null;
	    private final Class<K> keyClass = null;
	    private final Class<V> valueClass = null;
	    private final /*org.apache.hadoop.mapreduce.*/OutputCommitter committer = null;
		
		@SuppressWarnings("unchecked")
		//@Override
		public void combine(RawKeyValueIterator iterator, 
				OutputCollector<K,V> collector
				) throws IOException, InterruptedException,
				ClassNotFoundException {
			// make a reducer
			/*org.apache.hadoop.mapreduce.*/Reducer<K,V,K,V> reducer = null;
			/*
					(org.apache.hadoop.mapreduce.Reducer<K,V,K,V>)
					ReflectionUtils.newInstance(reducerClass, job);
			*/
			/*org.apache.hadoop.mapreduce.*/Reducer.Context 
			reducerContext = createReduceContext(reducer, job, taskId,
					iterator, null, inputCounter, 
					new OutputConverter(collector),
					committer,
					reporter, comparator, keyClass,
					valueClass);
			//reducer.run(reducerContext);
		} 
	}
	
	public class TaskReporter 
	extends /*org.apache.hadoop.mapreduce.*/StatusReporter
	implements Runnable {//, Reporter {
		@Override
		public void run() {
			// TODO Auto-generated method stub			
		}

		@Override
		public Counter getCounter(Enum<?> name) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Counter getCounter(String group, String name) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void progress() {
			// TODO Auto-generated method stub
		}

		@Override
		public float getProgress() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void setStatus(String status) {
			// TODO Auto-generated method stub
		}
	}
	
    private static class OutputConverter<K,V>
    extends /*org.apache.hadoop.mapreduce.*/RecordWriter<K,V> {
    	OutputCollector<K,V> output;
    	OutputConverter(OutputCollector<K,V> output) {
    		this.output = output;
    	}
    }
    
    protected static <INKEY,INVALUE,OUTKEY,OUTVALUE> 
    /*org.apache.hadoop.mapreduce.*/Reducer<INKEY,INVALUE,OUTKEY,OUTVALUE>.Context
    createReduceContext(/*org.apache.hadoop.mapreduce.*/Reducer
                          <INKEY,INVALUE,OUTKEY,OUTVALUE> reducer,
                        Configuration job,
                        /*org.apache.hadoop.mapreduce.*/TaskAttemptID taskId, 
                        RawKeyValueIterator rIter,
                        /*org.apache.hadoop.mapreduce.*/Counter inputKeyCounter,
                        /*org.apache.hadoop.mapreduce.*/Counter inputValueCounter,
                        /*org.apache.hadoop.mapreduce.*/RecordWriter<OUTKEY,OUTVALUE> output, 
                        /*org.apache.hadoop.mapreduce.*/OutputCommitter committer,
                        /*org.apache.hadoop.mapreduce.*/StatusReporter reporter,
                        RawComparator<INKEY> comparator,
                        Class<INKEY> keyClass, Class<INVALUE> valueClass
    ) throws IOException, InterruptedException {
    	return null;
    }
}

package testHadoop;

import java.io.IOException;

public class DBInputFormat<T extends DBWritable>
/*
extends org.apache.hadoop.mapreduce.lib.db.DBInputFormat<T> 
implements InputFormat<LongWritable, T>, JobConfigurable*/
{
	public static class NullDBWritable /*extends 
	org.apache.hadoop.mapreduce.lib.db.DBInputFormat.NullDBWritable */
	implements DBWritable/*, Writable*/ {
	}	
	
	protected class DBRecordReader /*extends
	org.apache.hadoop.mapreduce.lib.db.DBRecordReader<T>
	implements RecordReader<LongWritable, T> */ {
		public LongWritable createKey() {
			return new LongWritable();  
		}

		/** {@inheritDoc} */
		public T createValue() {
			return null;
		}

		public long getPos() throws IOException {
			return 0;
		}

		/** {@inheritDoc} */
		public boolean next(LongWritable key, T value) throws IOException {	
			return false;
		}
	}
}

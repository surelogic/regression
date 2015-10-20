package testHadoop;

import testHadoop.DBInputFormat.DBRecordReader;
import testHadoop.DBInputFormat.NullDBWritable;
import static org.junit.Assert.assertFalse;

public class TestDBInputFormat {
	@SuppressWarnings("unchecked")
	public void testDBRecordReader() throws Exception {
		/*
		JobConf job = mock(JobConf.class);
		DBConfiguration dbConfig = mock(DBConfiguration.class);
		String[] fields = { "field1", "filed2" };
        */
		@SuppressWarnings("rawtypes")
		DBRecordReader reader = new DBInputFormat<NullDBWritable>().new DBRecordReader();
		/*new DBInputFormat<NullDBWritable>().new DBRecordReader(
				new DBInputSplit(),  NullDBWritable.class, job,
				DriverForTest.getConnection(), dbConfig, "condition", fields, "table");
				*/
		LongWritable key = reader.createKey();
		//assertEquals(0, key.get());
		DBWritable value = reader.createValue();
		/*
		assertEquals(
				"org.apache.hadoop.mapred.lib.db.DBInputFormat$NullDBWritable", value
				.getClass().getName());
		assertEquals(0, reader.getPos());
		*/
		assertFalse(reader.next(key, value));
	}
}

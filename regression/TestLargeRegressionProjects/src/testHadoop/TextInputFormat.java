package testHadoop;

import java.io.IOException;

public class TextInputFormat /*extends FileInputFormat<LongWritable, Text>
implements JobConfigurable*/ 
implements InputFormat<LongWritable, Text> {
	@Override
	public InputSplit[] getSplits(JobConf job, int numSplits)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
}

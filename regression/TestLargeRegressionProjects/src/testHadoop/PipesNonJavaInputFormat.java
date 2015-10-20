package testHadoop;

import java.io.IOException;

class PipesNonJavaInputFormat {
	public InputSplit[] getSplits(JobConf job, int numSplits) throws IOException {
		// Delegate the generation of input splits to the 'original' InputFormat
		return ReflectionUtils.newInstance(
				job.getClass(Submitter.INPUT_FORMAT, 
						TextInputFormat.class, 
						InputFormat.class), job).getSplits(job, numSplits);
	}
}

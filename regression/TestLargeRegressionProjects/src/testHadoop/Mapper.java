package testHadoop;

import java.io.IOException;

public class Mapper<KEYIN, VALUEIN, KEYOUT, VALUEOUT> {

	/**
	 * The <code>Context</code> passed on to the {@link Mapper} implementations.
	 */
	public abstract class Context
	implements MapContext<KEYIN,VALUEIN,KEYOUT,VALUEOUT> {
	}

	/**
	 * Expert users can override this method for more complete control over the
	 * execution of the Mapper.
	 * @param context
	 * @throws IOException
	 */
	public void run(Context context) throws IOException, InterruptedException {
		/*
		setup(context);
		try {
			while (context.nextKeyValue()) {
				map(context.getCurrentKey(), context.getCurrentValue(), context);
			}
		} finally {
			cleanup(context);
		}
		*/
	}	   
}

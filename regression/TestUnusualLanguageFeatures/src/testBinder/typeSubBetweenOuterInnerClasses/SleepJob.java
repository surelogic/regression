package testBinder.typeSubBetweenOuterInnerClasses;

import java.io.IOException;


public class SleepJob {
  public static class SleepReducer
    extends Reducer<GridmixKey, NullWritable, NullWritable, NullWritable> {

    protected void setup(Context context)
      throws IOException, InterruptedException {
      if (!context.nextKey() ||
        // THIS will only work if the type substitutions are done properly
        context.getCurrentKey().getType() != null) {
        throw new IOException("Missing reduce spec");
      }
    }
    
    protected void test(Reducer<GridmixKey, ?, ?, ?>.Context context) {
    	context.getCurrentKey().getType();
    }
  }
}


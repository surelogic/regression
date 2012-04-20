package testCanon.genericsWithinForEachLoop;

public class TestCounters /*extends TestCase*/ {
  enum myCounters {TEST1, TEST2};
  private static final long MAX_VALUE = 10;
  
  // Generates enum based counters
  private Counters getEnumCounters(Enum[] keys) {
    Counters counters = new Counters();
    for (Enum key : keys) {
      for (long i = 0; i < MAX_VALUE; ++i) {
        counters.incrCounter(key, i);
      }
    }
    return counters;
  }

  static class Counters {
	public void incrCounter(Enum key, long i) {
		// TODO Auto-generated method stub
		
	}
  }
}
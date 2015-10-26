package testHadoop;

import java.util.Iterator;

public class Counters 
extends AbstractCounters<Counters.Counter, Counters.Group> {
	public static class Counter implements /*org.apache.hadoop.mapreduce.*/testHadoop.Counter {
	}
	
	public static class Group implements CounterGroupBase<Counter> {
		@Override
		public Iterator<Counter> iterator() {
			// TODO Auto-generated method stub
			return null;
		}		
	}

	@Override
	public Iterator<Group> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}

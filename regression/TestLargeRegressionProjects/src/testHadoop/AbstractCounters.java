package testHadoop;

public abstract class AbstractCounters<C extends Counter,
G extends CounterGroupBase<C>>
implements Writable, Iterable<G> {
	public synchronized C findCounter(Enum<?> key) {	
		return null;
	}
}

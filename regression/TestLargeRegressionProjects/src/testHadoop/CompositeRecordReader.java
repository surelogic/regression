package testHadoop;

import java.io.*;

public abstract class CompositeRecordReader<
K extends WritableComparable, // key type
V extends Writable,           // accepts RecordReader<K,V> as children
X extends Writable>           // emits Writables of this type
implements Configurable {
	private int id;

	class JoinCollector {
	    /**
	     * Register a given iterator at position id.
	     */
	    public void add(int id, ResetableIterator<X> i)
	        throws IOException {	    	
	    }
	}

	/**
	 * If key provided matches that of this Composite, give JoinCollector
	 * iterator over values it may emit.
	 */
	@SuppressWarnings("unchecked") // No values from static EMPTY class
	public void accept(CompositeRecordReader.JoinCollector jc, K key)
			throws IOException {
		if (true/*hasNext() && 0 == cmp.compare(key, key())*/) {
			//fillJoinCollector(createKey());
			jc.add(id, getDelegate());
			return;
		}
		//jc.add(id, EMPTY);
	}

	/**
	 * Obtain an iterator over the child RRs apropos of the value type
	 * ultimately emitted from this join.
	 */
	protected abstract ResetableIterator<X> getDelegate();
}

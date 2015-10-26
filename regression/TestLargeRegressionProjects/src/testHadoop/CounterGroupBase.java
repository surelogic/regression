package testHadoop;

public interface CounterGroupBase<T extends Counter>
extends Writable, Iterable<T> {

}

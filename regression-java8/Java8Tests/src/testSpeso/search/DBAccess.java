package testSpeso.search;

public interface DBAccess extends AutoCloseable {
	public <T> T query(DBQuery<T> q);
	public void transact(TransactionConsumer consumer);
}

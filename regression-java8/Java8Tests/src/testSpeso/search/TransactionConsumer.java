package testSpeso.search;

@FunctionalInterface
public interface TransactionConsumer {
	/**
	 * Performs this operation on the given argument.
	 *
	 * @param t
	 * @throws Exception
	 */
	void accept(Transaction t) throws Exception;
}

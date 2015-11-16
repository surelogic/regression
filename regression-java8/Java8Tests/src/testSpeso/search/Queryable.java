package testSpeso.search;

import java.sql.SQLException;

public interface Queryable<T> extends AutoCloseable {

	// void call(Object... args) throws SQLException;

	T call(Object... args) throws SQLException;

	@Override
	void close() throws SQLException;

	// T call(Handler<T> h, Object[] args) throws SQLException;
}

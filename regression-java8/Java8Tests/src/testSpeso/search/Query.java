package testSpeso.search;

import java.sql.*;

import testSpeso.SpesoCollectors.IntCollector;

public interface Query {
	public <A, R> Queryable<R> prepared(String key, IntRowHandler rh,
			IntCollector<A, R> collector) throws SQLException;
}

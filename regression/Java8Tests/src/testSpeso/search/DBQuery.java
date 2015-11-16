package testSpeso.search;

import java.sql.*;

public interface DBQuery<T> {
	T query(Query q) throws SQLException;
}

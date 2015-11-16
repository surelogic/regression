package testSpeso.search;

import java.sql.ResultSet;
import java.sql.SQLException;

import testSpeso.RuntimeSQLException;

@FunctionalInterface
public interface IntRowHandler {

	default int handle(ResultSet rs) {
		try {
			return accept(rs);
		} catch (SQLException e) {
			throw new RuntimeSQLException(e);
		}
	}

	int accept(ResultSet rs) throws SQLException;
}

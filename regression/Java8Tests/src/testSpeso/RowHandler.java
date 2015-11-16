package testSpeso;
//package com.speso.dbaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

//import com.speso.exceptions.RuntimeSQLException;

@FunctionalInterface
public interface RowHandler<T> {

	default T handle(ResultSet rs) {
		try {
			return accept(rs);
		} catch (SQLException e) {
			throw new RuntimeSQLException(e);
		}
	}

	T accept(ResultSet rs) throws SQLException;

	default ResultHandler<Optional<T>> toOptionalResult() {
		return rs -> {
			if (rs.next())
				return Optional.of(this.accept(rs));
			else
				return Optional.empty();
		};
	}
}

package testSpeso;
//package com.speso.dbaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//import com.speso.collectors.SpesoCollectors;
//import com.speso.exceptions.RuntimeSQLException;

@FunctionalInterface
public interface ResultHandler<T> extends Handler<T> {
	@Override
	default T handle(ResultSet rs) {
		try {
			return accept(rs);
		} catch (SQLException e) {
			throw new RuntimeSQLException(e);
		}
	}

	T accept(ResultSet rs) throws SQLException;

	
	public static <T> RowResultHandler<T, ?, List<T>> listHandler(
			RowHandler<T> rh) {
		return new RowResultHandler<>(rh, SpesoCollectors.toArrayList());
	}
    
	public static ResultHandler<Integer> SINGLE_INT_HANDLER = rs -> {
		if (rs.next())
			return rs.getInt(1);
		else
			throw new RuntimeSQLException("No value returned");
	};
}


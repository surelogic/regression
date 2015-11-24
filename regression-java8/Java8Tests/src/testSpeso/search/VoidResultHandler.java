package testSpeso.search;
//package com.speso.dbaccess;

import java.sql.ResultSet;
import java.sql.SQLException;

import testSpeso.RuntimeSQLException;

public interface VoidResultHandler {

	default void handle(ResultSet rs) {
		try {
			accept(rs);
		} catch (SQLException e) {
			throw new RuntimeSQLException(e);
		}
	}

	void accept(ResultSet rs) throws SQLException;

	public static VoidRowResultHandler listHandler(VoidRowHandler rh) {
		return new VoidRowResultHandler(rh);
	}
}


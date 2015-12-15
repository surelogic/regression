package testSpeso.search;
//package com.speso.dbaccess;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface BatchingInstructions<T> {
	void batch(PreparedStatement st, T t) throws SQLException;

	// TODO can this be used?
	// default PreparedStatement fill(PreparedStatement st, Object... args)
	// throws SQLException {
	// return JDBCUtilities.fill(st, args);
	// }
}

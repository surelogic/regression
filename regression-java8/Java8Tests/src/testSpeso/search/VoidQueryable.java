package testSpeso.search;
//package com.speso.dbaccess;

import java.sql.SQLException;

public interface VoidQueryable extends AutoCloseable {

	// void call(Object... args) throws SQLException;

	void call(Object... args) throws SQLException;

	@Override
	void close() throws SQLException;

	// T call(Handler<T> h, Object[] args) throws SQLException;
}

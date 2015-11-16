package testSpeso;
//package com.speso.dbaccess;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface Handler<T> {

	public T handle(ResultSet rs) throws SQLException;
}


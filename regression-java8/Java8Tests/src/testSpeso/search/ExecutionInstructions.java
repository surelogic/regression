package testSpeso.search;
//package com.speso.dbaccess;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface ExecutionInstructions<T> {
	void execute(PreparedStatement st, T t) throws SQLException;
}


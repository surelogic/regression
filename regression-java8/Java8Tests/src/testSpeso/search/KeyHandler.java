package testSpeso.search;
//package com.speso.dbaccess;

import java.sql.ResultSet;
import java.sql.SQLException;

import testSpeso.Handler;

public interface KeyHandler<T> extends Handler<T> {

	@Override
	public T handle(ResultSet rs) throws SQLException;

}



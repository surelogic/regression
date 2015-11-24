package testSpeso.search;
//package com.speso.dbaccess;

import java.sql.ResultSet;
import java.sql.SQLException;

class VoidRowResultHandler implements VoidResultHandler {
	private final VoidRowHandler rh;

	public VoidRowResultHandler(VoidRowHandler rh) {
		this.rh = rh;
	}

	@Override
	public void accept(ResultSet rs) throws SQLException {
		while (rs.next()) {
			rh.handle(rs);
		}
	}
}


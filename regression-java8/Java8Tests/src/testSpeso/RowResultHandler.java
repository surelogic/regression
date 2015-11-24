package testSpeso;
//package com.speso.dbaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Collector;

class RowResultHandler<T, A, R> implements ResultHandler<R> {
	private final RowHandler<T> rh;
	private final Collector<T, A, R> collector;

	public RowResultHandler(RowHandler<T> rh, Collector<T, A, R> collector) {
		this.rh = rh;
		this.collector = collector;
	}

	@Override
	public R accept(ResultSet rs) throws SQLException {
		A container = collector.supplier().get();
		while (rs.next()) {
			collector.accumulator().accept(container, rh.handle(rs));
		}
		return collector.finisher().apply(container);
	}
}


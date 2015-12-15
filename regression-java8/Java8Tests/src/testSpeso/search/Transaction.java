package testSpeso.search;

//package com.speso.dbaccess;

import java.sql.SQLException;

public interface Transaction extends AutoCloseable {

	public abstract <T> void batchMany(String queryKey, Iterable<T> ts,
			BatchingInstructions<T> bi) throws SQLException;

	// public abstract void batchMany(String queryKey, int[] ts,
	// IntBatchingInstructions bi)
	// throws SQLException;

	public abstract <T> void batchOne(String queryKey, T t,
			BatchingInstructions<T> bi) throws SQLException;

	public abstract <T> boolean execute(String queryKey, T t,
			ExecutionInstructions<T> ei) throws SQLException;

	public abstract boolean executeInstruction(String queryKey)
			throws SQLException;

	public abstract int insertReturnKey(String queryKey, Object... args)
			throws SQLException;

	public abstract <T> int insert(String queryKey, Object... args)
			throws SQLException;

	public abstract <T> int update(String queryKey, T t,
			ExecutionInstructions<T> ei) throws SQLException;

	public abstract void commit() throws SQLException;

	public abstract <T extends Exception> void rollback(T e);

	public abstract void setReadUncommitted() throws SQLException;

	@Override
	public abstract void close() throws SQLException;

}


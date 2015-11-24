package testSpeso.search;

import java.sql.*;

import testSpeso.*;
import testSpeso.SpesoCollectors.IntCollector;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collector;

/**
 * Classes that implement query can return {@link Queryable} objects by a given
 * key. The existing implementation of Query is {@link ConnectionQuery}.
 *
 * @author nathan
 * @author jake
 *
 */
public interface Query {

	/**
	 * Return a Queryable object representing the prepared statement stored at
	 * the provided key.
	 *
	 * @param key
	 * @return
	 * @throws SQLException
	 */
	Queryable<Void> prepared(String key) throws SQLException;

	/**
	 * Return a Queryable object representing the prepared statement stored at
	 * the provided key that will return the result of evaluating the provided
	 * {@link RowHandler} against each row when called. The objects returned by
	 * the {@link RowHandler} will be collected by the {@link Collector}
	 *
	 * @param key
	 * @param rh
	 * @param collector
	 * @return the return of the collector
	 * @throws SQLException
	 */
	public <T, A, R> Queryable<R> prepared(String key, RowHandler<T> rh,
			Collector<T, A, R> collector) throws SQLException;

	/**
	 * Return a Queryable object representing the prepared statement stored at
	 * the provided key
	 *
	 * @param st
	 * @param rh
	 * @return
	 * @throws SQLException
	 */
	VoidQueryable prepared(String st, VoidResultHandler rh) throws SQLException;

	/**
	 * Return a Queryable object representing the prepared statement stored at
	 * the provided key that will return the result of evaluating the provided
	 * {@link RowHandler} against each row when called. The objects returned by
	 * the {@link RowHandler} will be collected by the {@link Collector}
	 *
	 * @param key
	 * @param rh
	 * @param collector
	 * @return the return of the collector
	 * @throws SQLException
	 */
	public <A, R> Queryable<R> prepared(String key, IntRowHandler rh,
			IntCollector<A, R> collector) throws SQLException;

	/**
	 * Return a Queryable object representing the prepared statement stored at
	 * the provided key that will return the result of evaluating the provided
	 * {@link RowHandler} against each row when called.
	 *
	 * @param <T>
	 * @param key
	 * @param rh
	 * @return a list of objects returned by the RowHandler
	 * @throws SQLException
	 */
	public default <T> Queryable<List<T>> prepared(String key, RowHandler<T> rh)
			throws SQLException {
		return prepared(key, ResultHandler.listHandler(rh));
	}

	/**
	 * Return a Queryable object representing the prepared statement stored at
	 * the provided key that will return the result of evaluating the provided
	 * {@link ResultHandler} against the full result set when called.
	 *
	 * @param <T>
	 * @param key
	 * @param rh
	 * @return the return of the ResultHandler
	 * @throws SQLException
	 */
	<T> Queryable<T> prepared(String key, ResultHandler<T> rh)
			throws SQLException;

	/**
	 * Return a Queryable object representing the prepared statement stored at
	 * the provided key that will return the result of evaluating the provided
	 * {@link KeyHandler} when called.
	 *
	 * @param <T>
	 * @param key
	 * @param rh
	 * @return
	 * @throws SQLException
	 */
	<T> Queryable<T> prepared(String key, KeyHandler<T> kh) throws SQLException;

	/**
	 * Return a Queryable object representing the statement stored at the
	 * provided key.
	 *
	 * @param key
	 * @return
	 */
	Queryable<Void> statement(String key);

	<T, A, R> Queryable<R> statement(String key, RowHandler<T> rh,
			Collector<T, A, R> collector) throws SQLException;

	/**
	 * Return a Queryable object representing the statement stored at the
	 * provided key that will return the result of evaluating the provided
	 * {@link RowHandler} against each row when called.
	 *
	 * @param <T>
	 * @param key
	 * @param rh
	 * @return
	 * @throws SQLException
	 */
	default <T> Queryable<List<T>> statement(String key, RowHandler<T> rh)
			throws SQLException {
		return statement(key, ResultHandler.listHandler(rh));
	}
	/**
	 * Return a Queryable object representing the prepared statement stored at
	 * the provided key that will return the result of evaluating the provided
	 * {@link ResultHandler} against the full result set when called.
	 *
	 * @param <T>
	 * @param key
	 * @param rh
	 * @return
	 * @throws SQLException
	 */
	<T> Queryable<T> statement(String key, ResultHandler<T> rh)
			throws SQLException;

}


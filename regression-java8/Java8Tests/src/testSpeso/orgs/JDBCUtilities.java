package testSpeso.orgs;
//package com.speso.dbaccess;

//import static com.google.common.base.Preconditions.checkArgument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import testSpeso.ResultHandler;

public class JDBCUtilities {

	/**
	 * Returns a generated key.
	 *
	 * @param st
	 * @return int - the key
	 * @throws SQLException
	 */
	public static int getGeneratedKey(final PreparedStatement st)
			throws SQLException {
		int key = -1;
		try (ResultSet rs = st.getGeneratedKeys()) {
			if (rs.next()) {
				key = rs.getInt(1);
			} else
				throw new IllegalArgumentException(
						"No key to get.  Is RETURN_GENERATED_KEYS on?");
		}
		return key;
	}

	public static List<Integer> getGeneratedKeys(final PreparedStatement st) {
		final List<Integer> keys = new ArrayList<>();
		try (ResultSet rs = st.getGeneratedKeys()) {
			while (rs.next()) {
				keys.add(rs.getInt(1));
			}
			//checkArgument(keys.size() > 0,
			//		"no keys to get.  Is RETURN_GENERATED_KEYS on?");
		} catch (final SQLException e) {
			throw new IllegalStateException(
					"could not get key.  Is RETURN_GENERATED_KEYS on?");
		}
		return keys;
	}

	/**
	 * Fill the parameters of a {@link PreparedStatement} with the values in
	 * args. Supported types include {@link Integer}, {@link Long},
	 * {@link Boolean}, {@link String}, {@link Date}, and {@link File}.
	 * {@link File} objects are represented as a BLOB. Due to constraints in
	 * JDBC, null values for these types may not be represented as {@code null}.
	 * Instead, use one of the values of {@link Nulls}.
	 *
	 * Example:
	 *
	 * <pre>
	 * // Fill a statement with an int, a long, and an empty date
	 * fill(statement, new Object[] { 3, 4L, Nulls.DATE });
	 *
	 * </pre>
	 *
	 * @param st
	 * @param args
	 *            the arguments given to the prepared statement
	 * @throws SQLException
	 */
	public static PreparedStatement fill(final PreparedStatement st,
			final Object... args) throws SQLException {
		int idx = 1;
		for (Object o : args) {
			if (o == null)
				throw new IllegalArgumentException(
						"Parameter may not be null.  Use one of the com.speso.orgDatabase.JDBCUtilities.Nulls enumerable objects instead.");
			else if (o instanceof String) {
				st.setString(idx, (String) o);
			} else if (o instanceof Nulls) {
				switch ((Nulls) o) {
				case DATE:
					// setNullableTimestamp(idx, st, null);
					st.setNull(idx, Types.DATE);
					break;
				case INT:
					// setNullableInt(idx, st, null);
					st.setNull(idx, Types.INTEGER);
					break;
				case DOUBLE:
					// setNullableInt(idx, st, null);
					st.setNull(idx, Types.DOUBLE);
					break;
				case STRING:
					st.setNull(idx, Types.VARCHAR);
					break;
				case BOOLEAN:
					// setNullableString(idx, st, null);
					st.setNull(idx, Types.BOOLEAN);
					break;
				case LONG:
					// setNullableLong(idx, st, null);
					st.setNull(idx, Types.DOUBLE);
					break;
				case FILE:
					st.setClob(idx, (Clob) null);
					break;
				default:
					break;
				}
			} else if (o instanceof Integer) {
				st.setInt(idx, (Integer) o);
			} else if (o instanceof Long) {
				st.setLong(idx, (Long) o);
			} else if (o instanceof Timestamp) {
				st.setTimestamp(idx, (Timestamp) o);
			} else if (o instanceof Date) {
				st.setTimestamp(idx, new Timestamp(((Date) o).getTime()));
			} else if (o instanceof Boolean) {
				st.setBoolean(idx, (Boolean) o);
			} else if (o instanceof Double) {
				st.setDouble(idx, (Double) o);
			} else if (o instanceof File) {
				final File f = (File) o;
				if (f.length() > Integer.MAX_VALUE)
					throw new IllegalArgumentException(
							"File argument too big: " + f);
				try (FileInputStream fin = new FileInputStream(f);) {
					st.setBinaryStream(idx, fin, (int) f.length());
				} catch (IOException e) {
					throw new SQLException(e);
				}
			} else
				throw new IllegalArgumentException(o.getClass()
						+ " can not be interpreted as an SQL parameter.");
			idx++;
		}
		return st;
	}

	/**
	 * Represents {@code null} values for common JDBC types
	 *
	 * @author nathan
	 *
	 */
	public enum Nulls {
		INT, DOUBLE, LONG, STRING, DATE, BOOLEAN, FILE;

		/**
		 * Return a Nulls value of the appropriate type if null.
		 *
		 * @param i
		 * @return
		 */
		public static Object coerce(final Integer i) {
			return i == null ? INT : i;
		}

		/**
		 * Return a Nulls value of the appropriate type if null.
		 *
		 * @param i
		 * @return
		 */
		public static Object coerce(final Double i) {
			return i == null ? DOUBLE : i;
		}

		/**
		 * Return a Nulls value of the appropriate type if null.
		 *
		 * @param i
		 * @return
		 */
		public static Object coerce(final Long i) {
			return i == null ? LONG : i;
		}

		/**
		 * Return a Nulls value of the appropriate type if null.
		 *
		 * @param i
		 * @return
		 */
		public static Object coerce(final String i) {
			return i == null ? STRING : i;
		}

		/**
		 * Return a Nulls value of the appropriate type if null.
		 *
		 * @param i
		 * @return
		 */
		public static Object coerce(final Date i) {
			return i == null ? DATE : i;
		}

		/**
		 * Return a Nulls value of the appropriate type if null.
		 *
		 * @param i
		 * @return
		 */
		public static Object coerce(final Boolean i) {
			return i == null ? BOOLEAN : i;
		}

		/**
		 * Return a Nulls value of the appropriate type if null.
		 *
		 * @param i
		 * @return
		 */
		public static Object coerce(final File f) {
			return f == null ? FILE : f;
		}
	}

	public static final ResultHandler<Integer> intVariableHandler = rs -> {
		rs.next();
		return rs.getInt(1);
	};
}


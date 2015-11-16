package testSpeso.search;

import java.sql.*;

import testSpeso.TIntSet;
import static testSpeso.SpesoCollectors.TIntSetCollector;

public class BatchingThread extends Thread {
	private static TIntSet getAllPmids(DBAccess conn) throws SQLException {
		return conn.query(q -> {
			try (final Queryable<TIntSet> qu = q.prepared("all.pmids",
					rs -> rs.getInt("pmid"), TIntSetCollector)) {
				return qu.call();
			}
		});
	}
}

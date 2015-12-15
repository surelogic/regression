package testSpeso.orgs;

import java.sql.*;
import java.util.SortedSet;
import java.util.concurrent.Callable;

import testSpeso.caching.Condition;
import testSpeso.search.*;

public class OrgPowerScoreGenerator implements Callable<Void> {
	private final Condition cond = null;
	private final DBAccess ca = null;
	
	@Override
	public Void call() throws Exception {
		//logger.info(cond + " beginning generating power score");
		final SortedSet<PSOrg> orgs = null;

		//orgs = populateOrgs(cond, ca);

		ca.transact(t -> {
			t.batchMany("power.score", orgs, new BatchingInstructions<PSOrg>() {
				int index = 0;

				@Override
				public void batch(final PreparedStatement st, final PSOrg org)
						throws SQLException {
					JDBCUtilities.fill(st, cond.getCondId(), org.getId(), ++index,
							org.getPubCount(), org.getPubScore(),
							org.getLogPubScore(), org.getTrialCount(),
							org.getTrialScore(), org.getLogTrialScore(),
							org.getExpCount(), org.getSumScores(),
							org.getSumLogScores(), org.getLogSumScores(),
							org.getCvrScore());
				}
			});
		});

		//logger.info(cond + " scored successfully, " + orgs.size() + " orgs ");
		return null;
	}
}

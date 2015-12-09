package testSpeso.caching;

import java.util.*;

@Deprecated
public class Cacher {
	private final PoolDBAccess sa = null;
	
	public void generatePowerScores() throws Exception {
		//resetPowerScores();

		final List<Condition> conds = sa.query(q -> q.prepared(
				"all.conds.unscored", Condition.ID_AND_NAME_HANDLER).call());
	}
}

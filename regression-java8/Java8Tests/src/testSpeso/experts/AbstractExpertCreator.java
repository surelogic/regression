package testSpeso.experts;

import java.sql.SQLException;
import java.util.List;

import testSpeso.caching.Condition;
import testSpeso.ps.*;

abstract class AbstractExpertCreator<T extends ExpertAttributes> implements
ExpertCreator<T> {
	protected final Condition cond = null;
	
	@Override
	public void run() {
		
	}
	
	List<GlobalExpertEntity<T>> getNormedPhys(List<ScoreableExpert<T>> experts)
			throws SQLException {
		return null;
	}
}

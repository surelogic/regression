package testSpeso.experts;
//package com.speso.experts;

import java.sql.SQLException;
import java.util.List;

import testSpeso.caching.*;
import testSpeso.ps.*;
import testSpeso.search.*;

abstract class AbstractDBExpertCreator<T extends ExpertAttributes> extends
AbstractExpertCreator<T> {
	//private static final Logger logger = LoggerFactory
	//		.getLogger(AbstractDBExpertCreator.class);
	protected final DBAccess conn;

	AbstractDBExpertCreator(DBAccess conn, Condition cond/*,
			ExpertScoresFactory<T> scoresFactory*/) {
		//super(cond, scoresFactory);
		this.conn = conn;
	}

	@Override
	public List<GlobalExpertEntity<T>> call() throws SQLException,
	TransactionException {
		//logger.info("{} extracting experts", cond);
		//final Stopwatch sw = Stopwatch.createStarted();
		final List<ScoreableExpert<T>> physicians = getPhysicianListForCond();
		// logger.info("Extracted {} experts for {}", physicians.size(), cond);
		final List<GlobalExpertEntity<T>> gpes = getNormedPhys(physicians);
		addToDB(gpes);
		// ambiguityToJson(cond.getId(), ambiguities);
		//logger.info("{} added {} experts   {}", cond, gpes.size(), sw.stop());
		return gpes;
	}

	protected abstract List<ScoreableExpert<T>> getPhysicianListForCond()
			throws SQLException;

	protected abstract void addToDB(List<GlobalExpertEntity<T>> gpes)
			throws TransactionException, SQLException;

}


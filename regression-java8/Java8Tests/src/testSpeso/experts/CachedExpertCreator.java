package testSpeso.experts;
//package com.speso.experts;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import testSpeso.*;
import testSpeso.caching.*;
import testSpeso.orgs.*;
import testSpeso.ps.*;
import testSpeso.ps.PowerScores.*;
import testSpeso.search.*;

public class CachedExpertCreator extends AbstractDBExpertCreator<PowerScores> {
	//private static final Logger logger = LoggerFactory
	//		.getLogger(CachedExpertCreator.class);
	//private static final ExpertScoresFactory<PowerScores> SCORES_FACTORY = () -> new PowerScores();

	/**
	 * @param conn
	 * @param cond
	 */
	CachedExpertCreator(DBAccess conn, Condition cond) {
		super(conn, cond/*, SCORES_FACTORY*/);
	}

	@Override
	protected List<ScoreableExpert<PowerScores>> getPhysicianListForCond()
			throws SQLException {
		final List<ScoreableExpert<PowerScores>> physicians = new ArrayList<>();

		final ResultHandler<Integer> pHandler = rs -> {
			int authCount = 0;
			while (rs.next()) {
				final PSPub pub = PSPub.CACHED_HANDLER.handle(rs);
				physicians.add(PSExpert.getAuthHandler(pub).handle(rs));
				authCount++;
			}
			return authCount;
		};

		final ResultHandler<Integer> tHandler = rs -> {
			int invCount = 0;
			while (rs.next()) {
				final PSTrial trial = PSTrial.HANDLER.handle(rs);
				physicians.add(PSExpert.getInvHandler(trial).handle(rs));
				invCount++;
			}
			return invCount;
		};

		// use the handlers
		final int authCount = conn.query(q -> {
			try (Queryable<Integer> qu = q.prepared("ps.auths", pHandler);) {
				return qu.call(cond.getCondId());
			}
		});

		final int invCount = conn.query(q -> {
			try (Queryable<Integer> qu = q.prepared("ps.invs", tHandler);) {
				return qu.call(cond.getCondId());
			}
		});
		/*
		logger.debug("{} authors, {} investigators, {} total found for {}",
				authCount, invCount, physicians.size(), cond);
        */
		return physicians;
	}

	@Override
	protected void addToDB(List<GlobalExpertEntity<PowerScores>> gpes)
			throws SQLException, TransactionException {
		if (Thread.interrupted()) return;
		conn.transact(t -> {
			t.setReadUncommitted();
			t.execute("experts.delete", cond,
					(st, c) -> JDBCUtilities.fill(st, cond.getCondId()));
			final List<PSInvestigator> invs = new ArrayList<>();
			final List<PSAuthor> auths = new ArrayList<>();
			final Multimap<Integer, Integer> ambiguousIds = ArrayListMultimap
					.create();
			final Multimap<Integer, Integer> orgs = ArrayListMultimap.create();
			for (final GlobalExpertEntity<PowerScores> gpe : gpes) {
				PowerScores scores = gpe.getScores();
				// @formatter:off
				gpe.setPhysId(t.insertReturnKey("expert",
						//Nulls.coerce(gpe.getFirstName()),
						gpe.getLastName(),
						cond.getCondId(),
						scores.getPubCount(),
						scores.getTrialCount(),
						scores.getPubScore(),
						scores.getTrialScore(),
						scores.getCvrScoreMax(),
						scores.getCvrScoreMin(),
						scores.getCvrScoreSum(),
						scores.getFirstAuthCount(),
						scores.getLastAuthCount(),
						scores.getJournalArticleCount(),
						scores.getAboutAnimalsCount(),
						scores.getAboutHumansCount(),
						scores.getIsOOCount(),
						scores.getStudyChairCount(),
						scores.getPICount(),
						scores.getLatestYear(),
						//Nulls.coerce(scores.getLatestOrgYear()),
						gpe.isAmbiguous()));
				// @formatter:on
				auths.addAll(scores.getAuthors());
				invs.addAll(scores.getInvestigators());
				orgs.putAll(gpe.getExpId(), scores.getLatestOrgs());

				List<Research> pubs = scores.getLatestResearch();
				for (int orgId : scores.getLatestOrgs()) {
					t.batchMany("expert.latestresearch",
							pubs,
							new BatchingInstructions<Research>() {
						int i = 1;
						@Override
						public void batch(PreparedStatement st,
								Research r) throws SQLException {
							JDBCUtilities.fill(st, cond.getCondId(), orgId,
									gpe.getExpId(), r.getId(), r.getYear(),
									r.isPub(), i++);
						}
					});
				}

			}
			for (GlobalExpertEntity<PowerScores> gpe : gpes) {
				if (gpe.isAmbiguous()) {
					ambiguousIds.putAll(gpe.getExpId(),
							gpe.getAmbiguousPhysIds());
				}
			}
			t.batchMany("author.update", auths, (st, au) -> {
				JDBCUtilities.fill(st, au.getExpId(), au.getSourceId(),
						au.getRltnId());
			});
			t.batchMany(
					"investigator.update",
					invs,
					(st, inv) -> {
						JDBCUtilities.fill(st, inv.getExpId(),
								inv.getSourceId(), inv.getRltnId());
					});
			t.batchMany("expert.ambiguous", ambiguousIds.entries(), (st,
					possible) -> {
						JDBCUtilities.fill(st, possible.getKey(), possible.getValue());
					});
			t.batchMany("expert.latestorgs", orgs.entries(), (st, org) -> {
				JDBCUtilities.fill(st, org.getKey(), org.getValue());
			});
			if (Thread.interrupted()) {
				t.rollback(new InterruptedException());
			}
		});
	}
}


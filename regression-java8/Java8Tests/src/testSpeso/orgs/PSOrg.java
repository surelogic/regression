package testSpeso.orgs;
//package com.speso.ps;

//import static com.speso.util.Utilities.round;

import java.util.Collection;
import java.util.Set;

import testSpeso.ps.*;

public class PSOrg implements Comparable<PSOrg> {
	private final int id;
	// final Set<PSPub> pubs;
	// final Set<PSTrial> trials;
	private final int pubCount;
	private final int trialCount;
	private final int expCount;
	private final double pubScore;
	private final double trialScore;
	private final double logPubScore;
	private final double logTrialScore;
	private final double sumScores;
	private final double sumLogScores;
	private final double logSumScores;
	private final double cvrScore;

	public PSOrg(int orgId, int expCount, Set<PSPub> pubs, Set<PSTrial> trials) {
		pubScore = round(calcValue(pubs));
		trialScore = round(calcValue(trials));
		pubCount = pubs.size();
		trialCount = trials.size();
		id = orgId;
		// this.pubs = pubs;
		// this.trials = trials;
		this.expCount = expCount;
		logPubScore = Math.log(1 + pubScore);
		logTrialScore = Math.log(1 + trialScore);
		sumScores = round(pubScore + trialScore);
		sumLogScores = logPubScore + logTrialScore;
		logSumScores = Math.log(1 + sumScores);
		cvrScore = round(pubs.stream().mapToDouble(PowerScoreable::getCvrScoreMax)
				.sum());
	}

	public int getId() {
		return id;
	}

	public int getPubCount() {
		return pubCount;
	}

	public int getTrialCount() {
		return trialCount;
	}

	public double getPubScore() {
		return pubScore;
	}

	public double getTrialScore() {
		return trialScore;
	}

	public double getLogPubScore() {
		return logPubScore;
	}

	public double getLogTrialScore() {
		return logTrialScore;
	}

	public int getExpCount() {
		return expCount;
	}

	public double getSumScores() {
		return sumScores;
	}

	public double getSumLogScores() {
		return sumLogScores;
	}

	public double getLogSumScores() {
		return logSumScores;
	}

	public double getCvrScore() {
		return cvrScore;
	}

	protected static <T extends PowerScoreable> double calcValue(
			Collection<T> ps) {
		return ps.stream().mapToDouble(PowerScoreable::getValue).sum();
	}

	@Override
	public String toString() {
		return "Org " + id;
	}

	/*
	 * (non-Javadoc) Sorts highest powerScore first, then on id.
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(final PSOrg o) {
		int comp = Double.compare(sumLogScores, o.sumLogScores);
		if (comp == 0) {
			comp = Double.compare(pubScore, o.pubScore);
			if (comp == 0) {
				comp = Double.compare(trialScore, o.trialScore);
				if (comp == 0) {
					comp = Integer.compare(id, o.id);
				}
			}
		}
		return -1 * comp;
	}

	/**
	 * @param x
	 * @return x, rounded to the nearest 10,000th
	 */
	public static double round(double x) {
		return Math.round(x * 10000) / 10000.0;
	}
}


package testSpeso.orgs;

import java.util.*;
import java.util.stream.*;

public class OrgVisibleBuilder implements //Organization,
Comparable<OrgVisibleBuilder> {
//	private final ConditionScale cond;
//	private final int orgId;
//	private final String name;
//	private final int rank;
//	private final double power;
//	private final int pubCount;
//	private final double pubScore;
//	private final int trialCount;
//	private final double trialScore;
//	private final int expCount;
//	private final double cvrScore;
	//private final StreetAddress streetAddress;
	// private final List<PubVisible> pubs = new ArrayList<>();
	private final TIntObjectMap<PubVisible> pubMap = new TIntObjectHashMap<>();
	//private final List<TrialVisible> trials = new ArrayList<>();
	private final List<ExpertVisible> experts = new ArrayList<>();
	private final SetMultimap<Integer, Integer> physMap = TreeMultimap.create();
	//private final String phone;
	private Optional<? extends Npo> npo;
	
	public void/*CenterPageOrg*/ buildToCenterPageOrg(Optional<? extends Npo> npo) {
		
		int numOnPage = 15;
		/*
		int spesoScore = cond.makeSpesoScore(power);

		List<TrialVisible> stTrials = trials.stream().sorted().limit(numOnPage)
				.collect(Collectors.toList());
		*/
		List<ExpertVisible> stExps = experts.stream().sorted().limit(numOnPage)
				.collect(Collectors.toList());

		stExps.stream().flatMap(exp -> physMap.get(exp.getId()).stream())
		.map(pmid -> pubMap.get(pmid))
		.forEach(pub -> pub.setForceDisplay());
		
		//...
	}
	
	@Override
	public int compareTo(final OrgVisibleBuilder o) {
		return 0;
	}
}

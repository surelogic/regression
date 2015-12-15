package testSpeso.ps;

import java.util.*;
import java.util.stream.Stream;

import testSpeso.*;
import static java.util.stream.Collectors.toList;

public class PowerScores extends ExpertAttributes {
	private final Map<PSPub, List<PSAuthor>> auths = new HashMap<>();
	private final Map<PSTrial, List<PSInvestigator>> invs = new HashMap<>();

	@Override
	protected void score() {
		for (List<PSAuthor> auths : auths.values()) {
			// ...
		}
	}
	
	int[] elts;
	Float[] floats;
	
	void foo() {
		for(Integer elts : elts) {			
		}
		for(float floats : floats) {
			
		}
	}
	
	public List<PSAuthor> getAuthors() {
		return auths.values().stream().flatMap(l -> l.stream())
				.collect(toList());
	}
	
	public int getLatestYear() {
		return 0;
	}

	public Integer getLatestOrgYear() {
		return null;
	}

	public Collection<Integer> getLatestOrgs() {
		return null;
	}

	public double getPubScore() {
		return 0;
	}

	public double getTrialScore() {
		return 0;
	}

	public int getPubCount() {
		return auths.size();
	}

	public int getTrialCount() {
		return invs.size();
	}

	public double getCvrScoreMax() {
		return 0;
	}

	public double getCvrScoreMin() {
		return 0;
	}

	public double getCvrScoreSum() {
		return 0;
	}

	public int getFirstAuthCount() {
		return 0;
	}

	public int getLastAuthCount() {
		return 0;
	}

	public int getJournalArticleCount() {
		return 0;
	}

	public int getAboutAnimalsCount() {
		return 0;
	}

	public int getAboutHumansCount() {
		return 0;
	}

	public int getIsOOCount() {
		return 0;
	}

	public int getStudyChairCount() {
		return 0;
	}

	public int getPICount() {
		return 0;
	}
	
	public static abstract class PSExpert extends ScoreableExpert<PowerScores> {
		public static RowHandler<PSAuthor> getAuthHandler(PSPub pub) {
			return null;
		}
		
		public static RowHandler<PSInvestigator> getInvHandler(PSTrial trial) {
			/*
			return rs -> new PSInvestigator(trial, rs.getInt("tfi_id"),
					rs.getString("first_name"), rs.getString("last_name"),
					rs.getInt("org_id"), rs.getInt("role"),
					rs.getBoolean("is_OO"));
					*/
			return null;
		}
	}
	
	public static class PSAuthor extends PSExpert {
		public int getRltnId() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int getSourceId() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int getExpId() {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	public static class PSInvestigator extends PSExpert {

		public int getRltnId() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int getSourceId() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int getExpId() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}

	public List<Research> getLatestResearch_simplified() {	
		//return auths.keySet().stream().map(Research::create)
		Stream<PSPub> stream = null;
		return stream.map(Research::create)
				.sorted((r1, r2) -> -1
						* Integer.compare(r1.getYear(), r2.getYear()))
						.collect(toList());		
	}
	
	public List<Research> getLatestResearch() {
		return Stream
				.concat(auths.keySet().stream().map(Research::create),
						invs.keySet().stream().map(Research::create))
				.sorted((r1, r2) -> -1
						* Integer.compare(r1.getYear(), r2.getYear()))
						.collect(toList());
	}
	
	public List<PSInvestigator> getInvestigators() {
		List<PSInvestigator> exps = new ArrayList<>();
		invs.values().stream().forEach(l -> exps.addAll(l));
		return exps;
	}
}

package testSpeso.ps;

import java.util.*;
import java.util.stream.Stream;
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
	
	public static abstract class PSExpert extends ScoreableExpert<PowerScores> {
		
	}
	
	public static class PSAuthor extends PSExpert {
		
	}
	
	public static class PSInvestigator extends PSExpert {
		
	}
	
	public List<Research> getLatestResearch() {
		return Stream
				.concat(auths.keySet().stream().map(Research::create),
						invs.keySet().stream().map(Research::create))
				.sorted((r1, r2) -> -1
						* Integer.compare(r1.getYear(), r2.getYear()))
						.collect(toList());
	}
}

package testSpeso.experts;

import java.util.*;

import testSpeso.orgs.ExpertVisible;

public class ExpertVisibleDao {
	public static void/*List<CenterPageExpert>*/ getCenterPageExperts(
			/*Condition cond, Organization org,*/ int expBlowoutSize, List<ExpertVisible> exps) {

		Map<Integer, List<ResearchVisible>> expMap = new HashMap<>();
		for (ExpertVisible exp : exps) {
			expMap.put(exp.getId(), new ArrayList<>());
		}
	}
}

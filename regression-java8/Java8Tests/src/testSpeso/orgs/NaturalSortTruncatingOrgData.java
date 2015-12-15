package testSpeso.orgs;

import static java.util.stream.Collectors.toList;
import java.util.*;

class NaturalSortTruncatingOrgData implements OrgData {
	private final List<PubVisible> pubs;
	private final List<TrialVisible> trials;
	private final List<ExpertVisible> experts;
	private final boolean hasActiveTrials;

	NaturalSortTruncatingOrgData(Collection<PubVisible> pubs,
			Collection<TrialVisible> trials, Collection<ExpertVisible> experts) {
		this.pubs = pubs.stream().sorted().limit(5).collect(toList());
		this.trials = trials.stream().sorted().limit(5).collect(toList());
		this.experts = experts.stream().sorted().limit(5).collect(toList());
		hasActiveTrials = this.trials.stream().anyMatch(t -> t.isActive());
	}
}

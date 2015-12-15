package testSpeso.experts;

import java.util.*;
import java.util.stream.Collectors;

import testSpeso.ps.ExpertAttributes;

class Ambiguity<T extends ExpertAttributes>{
	private final GlobalExpertEntity<T> physGpe;
	private final List<GlobalExpertEntity<T>> gpes;
	
	Ambiguity(GlobalExpertEntity<T> physGpe,
			List<GEEMatch<T>> gpes) {
		this.physGpe = physGpe;
		this.gpes = gpes.stream().map(match -> match.gpe())
				.collect(Collectors.toList());
	}
	
	public List<Integer> getPossiblePhysIds() {
		return gpes.stream().map(gpe -> gpe.getExpId())
				.collect(Collectors.toList());
	}
	
}

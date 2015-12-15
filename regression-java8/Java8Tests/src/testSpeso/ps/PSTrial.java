package testSpeso.ps;

import java.util.concurrent.ConcurrentHashMap;

import testSpeso.RowHandler;

public class PSTrial implements PowerScoreable {
	private final int nctId;
	private final int year;
	private final Phase phase;

	public PSTrial(int nctId, int year, int phaseId) {
		this(nctId, year, Phase.getPhase(phaseId));
	}

	PSTrial(int nctId, int year, Phase phase) {
		this.nctId = nctId;
		this.year = year;
		this.phase = phase;
	}
	
	@Override
	public int getYear() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCvrScoreMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	private static final ConcurrentHashMap<Integer, PSTrial> TRIAL_CACHE = new ConcurrentHashMap<>();

	public static PSTrial getExistingOrNew(int nctId, int year, int phaseId) {
		return TRIAL_CACHE.computeIfAbsent(nctId, (key) -> new PSTrial(nctId,
				year, phaseId));
	}
	
	public static final RowHandler<PSTrial> HANDLER = rs -> {
		return getExistingOrNew(rs.getInt("nct_id"), rs.getInt("year"),
				rs.getInt("phase_id"));
	};
}

package testSpeso.ps;

import testSpeso.RowHandler;

public class PSPub implements PowerScoreable {

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

	public static final RowHandler<PSPub> CACHED_HANDLER = rs -> {
		return getExistingOrNew(rs.getInt("pmid"), rs.getInt("year"),
				rs.getString("types"), rs.getBoolean("is_book"),
				rs.getBoolean("about_animals"), rs.getBoolean("about_humans"));
	};
	
	protected static PSPub getExistingOrNew(int pmid, int year,
			String typeList, boolean isBook, boolean aboutAnimals,
			boolean aboutHumans) {
		return null;
	}
}

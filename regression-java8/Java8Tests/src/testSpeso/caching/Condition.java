package testSpeso.caching;

import testSpeso.RowHandler;

public interface Condition {
	public int getCondId();
	
	public static Condition from(int id, String name) {
		return null;
	}
	
	public static final RowHandler<Condition> ID_AND_NAME_HANDLER = rs -> Condition
			.from(rs.getInt("cond_id"), rs.getString("name"));
}

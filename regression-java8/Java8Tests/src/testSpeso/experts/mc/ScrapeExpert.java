package testSpeso.experts.mc;

import static java.util.stream.Collectors.toList;

import java.util.List;

import testSpeso.RowHandler;

//import com.google.common.base.Splitter;

public class ScrapeExpert /*implements MatchableExpert*/ {

	//private final BasicMatchableExpert exp;
	private final List<Integer> orgIds;

	ScrapeExpert(String first, String last, int eId, List<Integer> orgIds) {
		//exp = new BasicMatchableExpert(first, last, eId);
		this.orgIds = orgIds;
	}
	/*
	@Override
	public String getLast() {
		return exp.getLast();
	}

	@Override
	public List<String> getFirstNameList() {
		return exp.getFirstNameList();
	}

	public int geteId() {
		return exp.geteId();
	}

	public List<Integer> getOrgIds() { return orgIds; }

	@Override
	public String toString() {
		return "ScrapeExpert [getLast()=" + getLast() + ", getFirstNameList()="
				+ getFirstNameList() + ", geteId()=" + geteId()
				+ ", getOrgIds()=" + getOrgIds() + "]";
	}
  	*/
	private static final Splitter cSplitter = Splitter.on(",");
	public static final RowHandler<ScrapeExpert> HANDLER = rs -> {
		return new ScrapeExpert(rs.getString("first_name"),
				rs.getString("last_name"), rs.getInt("e_id"), cSplitter
				.splitToList(rs.getString("org_ids")).stream()
				.map(Integer::parseInt).collect(toList()));
	};
}


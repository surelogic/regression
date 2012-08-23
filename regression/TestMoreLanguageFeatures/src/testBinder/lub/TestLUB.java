package testBinder.lub;

public class TestLUB {
	private JobID mapredJobID;

	void main(StringBuilder sb) {
		sb.append("job mapred id:\t").append(this.mapredJobID==null ? "unassigned"
				: this.mapredJobID).append("\n");
	}
}

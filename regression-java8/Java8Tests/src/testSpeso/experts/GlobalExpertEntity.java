package testSpeso.experts;

import java.util.List;

import testSpeso.ps.ExpertAttributes;
import testSpeso.ps.PowerScores;

class GlobalExpertEntity<T extends ExpertAttributes> {
	int getExpId() {
		return 0;
	}
	
	boolean isAmbiguous() {
		return false;
	}

	List<Integer> getAmbiguousPhysIds() {
		return null;
	}

	public PowerScores getScores() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLastName() {
		// TODO Auto-generated method stub
		return null;
		
	}
	
	void setPhysId(int physId) {
		
	}
}

package testSpeso.ps;

public interface Research {
	int getId();

	int getYear();

	boolean isPub();
	
	static Research create(PSPub p) {
		return null;//pub.apply(p);
	}

	static Research create(PSTrial t) {
		return null;
	}
}

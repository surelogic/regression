package test;

import com.surelogic.*;

public class Flight {
	@RegionEffects("reads All")
	public Flight(int number) { }
	
	@Nullable
	public String getDestinationNameOrNull() { 
		return null;
	}
}
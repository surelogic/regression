package testSpeso.experts.mc;

import static testSpeso.SpesoFunctions.toIterable;
import java.util.*;

import testSpeso.search.DBAccess;

public class MCPhysicians {
	private MCPhysicians(
			LookupTable<MCPhysician, String, String, Character> lookup) {		
	}
	
	public static MCPhysicians getPhysicians(DBAccess conn) {
		return new MCPhysicians( new LookupTable<MCPhysician, String, String, Character>(
				null,//queryPhysicians(conn),
				null,//toIterable(phys -> phys.getLast().toLowerCase()),
				null,//MCPhysician::getProviderNumbers, 
				toIterable((mc) -> mc.getFirstNameList().get(0)/*.toLowerCase()*/.charAt(0))));
	}
	
	private static List<MCPhysician> queryPhysicians(DBAccess conn) {
		return null;
	}
}

package testJSure;

import java.util.Arrays;

import testGuava.HashMultimap;
import testGuava.Multimap;

public class ClassAdapter {
	public static final SlotInfo<Object> hashSI = JavaNode.getSlotInfo("MD5 Hash");
	  public static final Multimap<String,Pair<IRNode,IRNode>> conflictingClassWarningsToGenerate = HashMultimap.create();
	
	public static boolean compareHash(String qname, IRNode sd, IRNode td) {
		if (sd.valueExists(hashSI)) {
			if (td.valueExists(hashSI)) {
				byte[] sHash = (byte[]) sd.getSlotValue(hashSI);
				byte[] tHash = (byte[]) td.getSlotValue(hashSI);
				//return Arrays.equals(sHash, tHash);
				IJavaRef sRef = JavaNode.getJavaRef(sd);
				IJavaRef tRef = JavaNode.getJavaRef(td);
				if (!Arrays.equals(sHash, tHash)) {			
					System.out.println("Hashes don't match for "+qname+":\n\t"+sRef.getAbsolutePathOrNull()+"\n\t"+tRef.getAbsolutePathOrNull());
					conflictingClassWarningsToGenerate.put(qname, sd.hashCode() < td.hashCode() ? new Pair<>(sd, td) : new Pair<>(td, sd));
				} else {
					//System.out.println("Hashes match for "+qname+":\n\t"+sRef.getAbsolutePathOrNull()+"\n\t"+tRef.getAbsolutePathOrNull());
				}
				// Eclipse only cares about the name
				return true;
			}
			//return false;
		}
		//return !td.valueExists(hashSI);
		throw new IllegalStateException("No hash for "+JavaNames.getFullTypeName(sd));
	}
}

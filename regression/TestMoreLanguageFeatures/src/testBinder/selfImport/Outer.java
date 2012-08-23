package testBinder.selfImport;

import static testBinder.selfImport.Outer.Inner2.*;

public class Outer {	
	static class Inner extends Super {
		
	}	
	static class Inner2 extends Super2 {
		/* Adding this causes it to not have problems,
		 * since it'll match
		static class Super2 {			
		}
		*/
	}
}

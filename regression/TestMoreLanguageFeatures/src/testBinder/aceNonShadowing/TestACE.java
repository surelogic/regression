package testBinder.aceNonShadowing;

import testBinder.aceNonShadowing.Outer;

public class TestACE {
	// This is why the code in the ACE is confused
	public class
	passwordDetails {
		passwordDetails(String args) {			
		}
	}
	
	public static void main(String[] args) {
		try{
			new Outer() {									
				public passwordDetails getPassword(
							int 		handler_type, 
							int 		action_type, 
							boolean		last_pw_incorrect,
							String 		reason )
					{
						return(new passwordDetails() {});					
					}
					
					public void 
					passwordOK(
						int 				handler_type,
						passwordDetails 	details) 
					{
					}
				};
		} finally {
			
		}
	}
}

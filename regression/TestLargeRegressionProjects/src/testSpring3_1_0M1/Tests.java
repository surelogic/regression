package testSpring3_1_0M1;

import static org.easymock.EasyMock.*;

import java.rmi.RemoteException;

import org.omg.CORBA.portable.ApplicationException;

public class Tests {
	public void testPerformsLookupWithAccessContext() throws Exception {
		RemoteInterface ejb = createMock(RemoteInterface.class);
		expect(ejb.targetMethod()).andReturn(null);
	}
	
	protected interface RemoteInterface extends EJBObject {
		// Also business exception!?
		Object targetMethod() throws RemoteException, ApplicationException;
	}
}

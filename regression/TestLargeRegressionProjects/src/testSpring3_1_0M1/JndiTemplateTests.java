package testSpring3_1_0M1;

import static org.easymock.EasyMock.*;

import javax.naming.Context;
import javax.naming.NameNotFoundException;

public class JndiTemplateTests {
	public void testLookupFails() throws Exception {
		NameNotFoundException ne = new NameNotFoundException();
		String name = "foo";
		final Context context = createMock(Context.class);
		expect(context.lookup(name)).andThrow(ne);
		/*
		context.close();
		replay(context);

		JndiTemplate jt = new JndiTemplate() {
			protected Context createInitialContext() {
				return context;
			}
		};

		try {
			jt.lookup(name);
			fail("Should have thrown NamingException");
		}
		catch (NameNotFoundException ex) {
			// Ok
		}
		verify(context);
		*/
	}
}

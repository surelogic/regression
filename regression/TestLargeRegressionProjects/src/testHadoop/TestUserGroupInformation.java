package testHadoop;

import java.io.IOException;
import java.security.PrivilegedExceptionAction;
import java.util.Collection;

public class TestUserGroupInformation {
	public <T extends TokenIdentifier> void testUGITokens() throws Exception {
		UserGroupInformation ugi = 
				UserGroupInformation.createUserForTesting("TheDoctor", 
						new String [] { "TheTARDIS"});
		/*
		Token<T> t1 = mock(Token.class);
		when(t1.getService()).thenReturn(new Text("t1"));
		Token<T> t2 = mock(Token.class);
		when(t2.getService()).thenReturn(new Text("t2"));

		Credentials creds = new Credentials();
		byte[] secretKey = new byte[]{};
		Text secretName = new Text("shhh");
		creds.addSecretKey(secretName, secretKey);

		ugi.addToken(t1);
		ugi.addToken(t2);
		ugi.addCredentials(creds);

		Collection<Token<? extends TokenIdentifier>> z = ugi.getTokens();
		assertTrue(z.contains(t1));
		assertTrue(z.contains(t2));
		assertEquals(2, z.size());
		Credentials ugiCreds = ugi.getCredentials();
		assertSame(secretKey, ugiCreds.getSecretKey(secretName));
		assertEquals(1, ugiCreds.numberOfSecretKeys());

		try {
			z.remove(t1);
			fail("Shouldn't be able to modify token collection from UGI");
		} catch(UnsupportedOperationException uoe) {
			// Can't modify tokens
		}
        */
		// ensure that the tokens are passed through doAs
		Collection<Token<? extends TokenIdentifier>> otherSet = 
				ugi.doAs(new PrivilegedExceptionAction<Collection<Token<?>>>(){
					@Override
					public Collection<Token<?>> run() throws IOException {
						return UserGroupInformation.getCurrentUser().getTokens();
					}
				});
		//assertTrue(otherSet.contains(t1));
		//assertTrue(otherSet.contains(t2));
	}
}

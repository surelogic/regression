package testHadoop;

import static org.mockito.Mockito.when;

public class TestKeyProviderDelegationTokenExtension {  
	public static abstract class MockKeyProvider extends KeyProvider 
	implements DelegationTokenExtension {
	}

	//@Test
	public void testCreateExtension() throws Exception {	 
		Configuration conf = new Configuration();
		Credentials credentials = new Credentials();    
		/*
    KeyProvider kp = 
        new UserProvider.Factory().createProvider(new URI("user:///"), conf);
    KeyProviderDelegationTokenExtension kpDTE1 = 
        KeyProviderDelegationTokenExtension
        .createKeyProviderDelegationTokenExtension(kp);
    Assert.assertNotNull(kpDTE1);
    // Default implementation should be a no-op and return null
    Assert.assertNull(kpDTE1.addDelegationTokens("user", credentials));
		 */
		MockKeyProvider mock = null;//mock(MockKeyProvider.class);
		when(mock.addDelegationTokens("renewer", credentials)).thenReturn(
				new Token<?>[] { new Token(null, null, new Text("kind"), new Text(
						"service")) });
		/*
    KeyProviderDelegationTokenExtension kpDTE2 =
        KeyProviderDelegationTokenExtension
        .createKeyProviderDelegationTokenExtension(mock);
    Token<?>[] tokens = 
        kpDTE2.addDelegationTokens("renewer", credentials);
    Assert.assertNotNull(tokens);
    Assert.assertEquals("kind", tokens[0].getKind().toString());
		 */

	}
}

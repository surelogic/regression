package testHadoop;

import java.io.IOException;

public interface DelegationTokenExtension {
    public Token<?>[] addDelegationTokens(final String renewer, 
            Credentials credentials) throws IOException;
}

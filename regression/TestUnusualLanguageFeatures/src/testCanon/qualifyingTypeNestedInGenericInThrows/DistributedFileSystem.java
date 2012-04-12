package testCanon.qualifyingTypeNestedInGenericInThrows;

import java.io.IOException;

import testCanon.qualifyingTypeNestedInGenericInThrows.SecretManager.InvalidToken;

public class DistributedFileSystem extends Configured {
	
  public long renewDelegationToken(Token<DelegationTokenIdentifier> token)
      throws InvalidToken, IOException {
    try {
      return token.renew(getConf());
    } catch (InterruptedException ie) {
      throw new RuntimeException("Caught interrupted", ie);
    }
  }
}

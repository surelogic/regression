package testCanon.qualifyingTypeNestedInGenericInThrows;

import java.io.IOException;

public abstract class SecretManager<T extends TokenIdentifier> {
  /**
   * The token was invalid and the message explains why.
   */
  @SuppressWarnings("serial")
  public static class InvalidToken extends IOException {
  }
}

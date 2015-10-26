package testHadoop;

import java.io.IOException;
import java.security.*;
import java.util.Collection;

public class UserGroupInformation {
	public static UserGroupInformation createUserForTesting(String user, 
			String[] userGroups) {
		return null;
	}

	public synchronized
	static UserGroupInformation getCurrentUser() throws IOException {
		return null;
	}

	public Collection<Token<? extends TokenIdentifier>> getTokens() {
		return null;
	}

	public <T> T doAs(PrivilegedAction<T> action) {
		return null;
	}

	/**
	 * Run the given action as the user, potentially throwing an exception.
	 * @param <T> the return type of the run method
	 * @param action the method to execute
	 * @return the value from the run method
	 * @throws IOException if the action throws an IOException
	 * @throws Error if the action throws an Error
	 * @throws RuntimeException if the action throws a RuntimeException
	 * @throws InterruptedException if the action throws an InterruptedException
	 * @throws UndeclaredThrowableException if the action throws something else
	 */
	//@InterfaceAudience.Public
	//@InterfaceStability.Evolving
	public <T> T doAs(PrivilegedExceptionAction<T> action
			) throws IOException, InterruptedException {
		return null;
	}
}
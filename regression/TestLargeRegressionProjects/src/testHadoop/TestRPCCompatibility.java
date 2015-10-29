package testHadoop;

import java.lang.reflect.Method;

public class TestRPCCompatibility {
	public interface TestProtocol3 {
		int echo(String value);
		int echo(int value);
		int echo_alias(int value);
		int echo(int value1, int value2);
	}	

	public void testHashCode() throws Exception {
		// make sure that overriding methods have different hashcodes
		/*
		Method strMethod = TestProtocol3.class.getMethod("echo", String.class);
		int stringEchoHash = ProtocolSignature.getFingerprint(strMethod);
		 */
		Method intMethod = TestProtocol3.class.getMethod("echo", int.class);
		/*
		int intEchoHash = ProtocolSignature.getFingerprint(intMethod);
		assertFalse(stringEchoHash == intEchoHash);

		// make sure methods with the same signature 
		// from different declaring classes have the same hash code
		int intEchoHash1 = ProtocolSignature.getFingerprint(
				TestProtocol2.class.getMethod("echo", int.class));
		assertEquals(intEchoHash, intEchoHash1);

		// Methods with the same name and parameter types but different returning
		// types have different hash codes
		int stringEchoHash1 = ProtocolSignature.getFingerprint(
				TestProtocol2.class.getMethod("echo", String.class));
		assertFalse(stringEchoHash == stringEchoHash1);

		// Make sure that methods with the same returning type and parameter types
		// but different method names have different hash code
		int intEchoHashAlias = ProtocolSignature.getFingerprint(
				TestProtocol3.class.getMethod("echo_alias", int.class));
		assertFalse(intEchoHash == intEchoHashAlias);

		// Make sure that methods with the same returning type and method name but
		// larger number of parameter types have different hash code
		int intEchoHash2 = ProtocolSignature.getFingerprint(
				TestProtocol3.class.getMethod("echo", int.class, int.class));
		assertFalse(intEchoHash == intEchoHash2);

		// make sure that methods order does not matter for method array hash code
		int hash1 = ProtocolSignature.getFingerprint(new Method[] {intMethod, strMethod});
		int hash2 = ProtocolSignature.getFingerprint(new Method[] {strMethod, intMethod});
		assertEquals(hash1, hash2);
		 */
	}
}

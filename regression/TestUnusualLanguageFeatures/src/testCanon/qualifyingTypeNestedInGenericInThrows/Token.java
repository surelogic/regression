package testCanon.qualifyingTypeNestedInGenericInThrows;

import java.io.IOException;

import testBinder.unknownProblem.Writable;

public class Token<T extends TokenIdentifier> implements Writable {
	 public long renew(Configuration conf
     ) throws IOException, InterruptedException {
		 return 0;
	 }
}
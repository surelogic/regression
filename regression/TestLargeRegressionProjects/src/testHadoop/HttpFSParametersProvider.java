package testHadoop;

import java.util.*;

public class HttpFSParametersProvider extends ParametersProvider {
	private static final Map<Enum, Class<Param<?>>[]> PARAMS_DEF =
	    new HashMap<Enum, Class<Param<?>>[]>();
	    
	public HttpFSParametersProvider() {
		super(HttpFSFileSystem.OP_PARAM, HttpFSFileSystem.Operation.class,
				PARAMS_DEF);
	}

}

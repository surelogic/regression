package testBinder.formalInQualfiedName;

import java.io.IOException;

public abstract class FileSystem {
	  public static final String FS_DEFAULT_NAME_KEY = "fs.default.name";

	  public static final Log LOG = null;
	  
	  abstract Object getConf();
	  abstract Object getDelegationToken(Object o);
	  abstract void setDelegationToken(Object o) throws IOException;
}

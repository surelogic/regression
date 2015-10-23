package testHadoop;

import java.io.*;
import java.net.URI;
import java.util.*;

public abstract class FileSystem extends Configured implements Closeable {
	private static final Map<Class<? extends FileSystem>, Statistics> 
	statisticsTable =
	    new IdentityHashMap<Class<? extends FileSystem>, Statistics>();
	
	protected Statistics statistics;

	public void initialize(URI name, Configuration conf) throws IOException {
		statistics = getStatistics(name.getScheme(), getClass());    
		/*
		resolveSymlinks = conf.getBoolean(
				CommonConfigurationKeys.FS_CLIENT_RESOLVE_REMOTE_SYMLINKS_KEY,
				CommonConfigurationKeys.FS_CLIENT_RESOLVE_REMOTE_SYMLINKS_DEFAULT);
		 */
	}

	public static synchronized 
	Statistics getStatistics(String scheme, Class<? extends FileSystem> cls) {
		Statistics result = statisticsTable.get(cls);
		if (result == null) {
			result = null;//new Statistics(scheme);
			statisticsTable.put(cls, result);
		}
		return result;
	}

	public static final class Statistics {

	}
}

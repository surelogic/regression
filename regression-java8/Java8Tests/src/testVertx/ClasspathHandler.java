package testVertx;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

public class ClasspathHandler {
	protected List<String> classpath;
	
	protected synchronized ClassLoader createClassloader() {
		URL[] urls = classpath.stream().map(path -> {
			File file = new File(path);
			try {
				return file.toURI().toURL();
			} catch (MalformedURLException e) {
				throw new IllegalStateException(e);
			}
		}).toArray(URL[]::new);
		return new URLClassLoader(urls, this.getClass().getClassLoader());
	}
}

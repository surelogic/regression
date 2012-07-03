package de.kvconnect.bundle.common;

public abstract class ContextClassloaderOperation<E extends Exception>
{
	protected abstract void operation() throws E;

	public void execute() throws E
	{
		/* ------------------------------------------------------------------
		 *  ClassLoader dark magic
		 *  
		 *  Reflection issue with Apache Felix: 
		 *  http://www.mail-archive.com/users@felix.apache.org/msg01058.html
		 *  -----------------------------------------------------------------
		 */
		final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		try
		{
			Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
			operation();
		}
		finally
		{
			// zuruecksetzen des Classloaders
			Thread.currentThread().setContextClassLoader(contextClassLoader);
		}
	}
}

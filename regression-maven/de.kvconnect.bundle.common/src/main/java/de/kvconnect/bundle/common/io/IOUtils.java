package de.kvconnect.bundle.common.io;

import java.io.File;

/**
 * Helper Klasse fuer IO-Operationen.
 * 
 * @author hartmann_t
 */
public final class IOUtils
{
	private IOUtils()
	{
	}

	/**
	 * Existenzprüfung einer Datei.
	 * 
	 * @param fileName Dateiname
	 * @return <code>true</code> Datei existiert, bei einem Verzeichnis oder Nichtexistenz wird
	 *         <code>false</code> retourniert
	 */
	public static boolean isFileExists(String fileName)
	{
		return new File(fileName).exists() && new File(fileName).isFile();
	}

	/**
	 * Existenzprüfung eines Verzeichnis.
	 * 
	 * @param dirName Verzeichnisname
	 * @return <code>true</code> Verzeichnis existiert, bei einer Datei oder Nichtexistenz wird
	 *         <code>false</code> retourniert
	 */
	public static boolean isDirectoryExists(String dirName)
	{
		return new File(dirName).exists() && new File(dirName).isFile();
	}

}

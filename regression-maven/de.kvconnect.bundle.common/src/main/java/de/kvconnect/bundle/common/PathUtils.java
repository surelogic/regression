package de.kvconnect.bundle.common;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

/**
 * Bietet Hilfsfunktionen zum Umgang mit Dateinamen und Dateipfaden.
 * 
 * @author wojciechowski
 */
public final class PathUtils
{
	/** Unerlaubte Zeichen im Dateinamen unter Windows. */
	public static final String INVALID_FILE_NAME_CHARS_WINDOWS = "\\/:*?\"<>|&";

	public static final String REGEX_INVALID_FILE_NAME_CHARS_WINDOWS = "[" + INVALID_FILE_NAME_CHARS_WINDOWS + "]+";

	private static final String PROPERTY_LOCAL_USERS_DIR = "user.dir";
	private static final String ALL_USERS_DIR = "users";
	private static final String FELIX_CONFIG_DIR = "conf";

	
	/**
	 * Unterdrueckt die Instanziierung von {@link PathUtils}.
	 */
	private PathUtils()
	{
	}

	/**
	 * Entfert alle Zeichen, die im Dateinamen nicht vorkommen duerfen.
	 * 
	 * @param value zu bereinigende Zeichenkette
	 * @param replace
	 * @return Zeichenkette mit entfernten unerlaubten Zeichen
	 */
	public static String normalizeFilename(String filename, String replacement)
	{
		return filename.replaceAll(REGEX_INVALID_FILE_NAME_CHARS_WINDOWS, replacement);
	}

	/**
	 * Fuegt den Dateinamen an den uebergebendem Dateipfad an und liefert den vollstaendigen
	 * Dateinamen zurueck. Zusammengesetzt wird der neue Dateiname durch die Klasse {@link File},
	 * die den systemspezifischen Seperator angefuegt.
	 * 
	 * @param path Basispfad
	 * @param filename anzufuegender Dateiname
	 * @return vollstaendiger neuer Dateiname (bestehende aus Pfad + filename)
	 * @see {@link File}
	 */
	public static String getFinalpath(String path, String filename)
	{
		return FilenameUtils.separatorsToSystem(new File(path, filename).toString());
	}

	public static String assemblePath(final String... pathSegments)
	{
		String result = "";
		for (String eachPathSegment : pathSegments)
		{
			if (StringUtils.isBlank(result))
			{
				result = eachPathSegment.trim();
			}
			else
			{
				result = result.concat(File.separator).concat(eachPathSegment.trim());
			}
		}
		return result;
	}

	
	public static String getBaseDir()
	{
		return System.getProperty(PROPERTY_LOCAL_USERS_DIR);
	}

	public static String getFelixConfigDir()
	{
		return PathUtils.assemblePath(getBaseDir(), FELIX_CONFIG_DIR);
	}

	public static String getAllUsersDir()
	{
		return PathUtils.assemblePath(getBaseDir(), ALL_USERS_DIR);
	}

}

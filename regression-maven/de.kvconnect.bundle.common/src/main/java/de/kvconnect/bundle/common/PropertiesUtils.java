package de.kvconnect.bundle.common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationConverter;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PropertiesUtils
{
	private static final Logger LOG = LoggerFactory.getLogger(PropertiesUtils.class);

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	private PropertiesUtils()
	{
	}

	/**
	 * Falls String-Wet gleich <code>null</code>, wird ein spezifizierter Default-Wert retourniert.
	 * 
	 * @param value String-Wert
	 * @param def Default-Wert
	 * @return Wert oder Default
	 */
	public static String getPropertyDef(String value, String def)
	{
		return StringUtils.defaultString(value, def);
	}

	/**
	 * String-Wert in Integer wandeln und falls String-Wert gleich <code>null</code>, wird ein
	 * spezifizierter Default-Integer retourniert.
	 * 
	 * @param value String-Wert
	 * @param def Default-Integer
	 * @return uebergebener String als Integer
	 */
	public static int getPropertyDefAsInt(String value, int def)
	{
		return Integer.parseInt(getPropertyDef(value, Integer.toString(def)));
	}

	/**
	 * String-Wert in Long wandeln und falls String-Wert gleich <code>null</code>, wird ein
	 * spezifizierter Default-Long retourniert.
	 * 
	 * @param value String-Wert
	 * @param def Default-Long
	 * @return uebergebener String als Long
	 */
	public static long getPropertyDefAsLong(String value, long def)
	{
		return Long.parseLong(getPropertyDef(value, Long.toString(def)));
	}

	/**
	 * Liest Properties aus einer Datei aus.
	 * 
	 * @param fileName Property Dateiname der Propertydatei
	 * @return Properties Objekt
	 * @throws IOException -
	 */
	public static Properties readProperties(String fileName) throws IOException
	{
		Properties ret = null;
		BufferedInputStream stream = null;
		try
		{
			stream = new BufferedInputStream(new FileInputStream(fileName));
			ret = new Properties();
			ret.load(stream);
		}
		finally
		{
			if (stream != null)
			{
				try
				{
					stream.close();
				}
				//CHECKSTYLE:OFF 
				catch (IOException ignore)
				{
				}
				//CHECKSTYLE:ON
			}
		}
		return ret;
	}

	/**
	 * Liest Properties aus einer Datei aus.
	 * 
	 * @param fileName Property Dateiname der Propertydatei
	 * @return Properties Objekt
	 * @throws IOException -
	 */
	public static Properties loadProperties(final String fileName) throws IOException
	{
		return loadProperties(new File(fileName));
	}

	/**
	 * Liest Properties aus einer Datei aus.
	 * 
	 * @param file Propertydatei
	 * @return Properties Objekt
	 * @throws IOException -
	 */

	public static Properties loadProperties(final File file) throws IOException
	{
		Properties ret = null;
		BufferedInputStream stream = null;
		try
		{
			stream = new BufferedInputStream(new FileInputStream(file));
			ret = new Properties();
			ret.load(stream);
		}
		finally
		{
			if (stream != null)
			{
				try
				{
					stream.close();
				}
				catch (IOException ignore)
				{
					LOG.info("Fehler beim schliessen des InputStreams");
				}
			}
		}
		return trimProperties(ret);
	}

	private static Properties trimProperties(Properties properties)
	{
		Properties result = new Properties();
		String value;
		for (String eachPropertyName : properties.stringPropertyNames())
		{
			value = properties.getProperty(eachPropertyName);
			result.setProperty(eachPropertyName.trim(), value.trim());
		}
		return result;
	}

	/**
	 * Verschmilzt eine Reihe von {@link java.util.Properties} Objekten. Dabei werden die Daten
	 * nacheinander in ein neues Propertiesobjekt geschrieben. D.h. wenn der selbe Key in mehreren
	 * Objekten vorhanden ist, so wird im zurückgelieferten Objekt der Wert des letzten Elements der
	 * Parameterliste gesetzt, welche den Schlüssel enthält,
	 * 
	 * @param properties
	 * @return
	 */
	public static Properties mergeProperties(final Properties... properties)
	{
		Properties result = new Properties();
		for (Properties eachProperty : properties)
		{
			Collection<String> keys = eachProperty.stringPropertyNames();
			for (String eachPropertyKey : keys)
			{
				result.setProperty(eachPropertyKey, eachProperty.getProperty(eachPropertyKey));
			}
		}
		return result;
	}

	/**
	 * Loggt Properties mit Log-Level <code>info</code>.
	 * 
	 * @param properties zu loggende Properties
	 * @param prefix Prefix String vor der Ausgabe
	 */
	public static void logProperties(final PropertiesConfiguration properties, final String prefix)
	{
		logProperties(ConfigurationConverter.getProperties(properties), prefix);
	}

	/**
	 * Loggt Properties mit Log-Level <code>info</code>.
	 * 
	 * @param properties zu loggende Properties
	 * @param prefix Prefix String vor der Ausgabe
	 */
	public static void logProperties(final Properties properties, final String prefix)
	{
		final StringBuilder sb = new StringBuilder(LINE_SEPARATOR + prefix + LINE_SEPARATOR);
		for (Object key : properties.keySet())
		{
			sb.append(generatePropertyLine(key.toString(), properties.getProperty((String) key)));
		}
		LOG.info(sb.toString());
	}

	private static String generatePropertyLine(final String name, final String value)
	{
		final StringBuilder sb = new StringBuilder();
		sb.append("\t");
		sb.append(name);
		sb.append(" = ");
		sb.append(value);
		sb.append(LINE_SEPARATOR);
		return sb.toString();
	}

}

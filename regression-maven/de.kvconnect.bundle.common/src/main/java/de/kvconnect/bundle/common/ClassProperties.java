package de.kvconnect.bundle.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import org.apache.commons.io.IOUtils;

public class ClassProperties extends Properties
{
	private static final long serialVersionUID = 1L;

	public ClassProperties(Class<?> clazz)
	{
		InputStream in = null;

		try
		{
			try
			{
				try
				{
					in = clazz.getResourceAsStream(clazz.getSimpleName() + ".properties");
					if (in != null)
					{
						load(in);
					}
					else
					{
						in = clazz.getResourceAsStream(clazz.getSimpleName() + ".xml");
						loadFromXML(in);
					}
				}
				finally
				{
					IOUtils.closeQuietly(in);
				}
			}
			catch (InvalidPropertiesFormatException e)
			{
				throw new RuntimeException(e);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}
}
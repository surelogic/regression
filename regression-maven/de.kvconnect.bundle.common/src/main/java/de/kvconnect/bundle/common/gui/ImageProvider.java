package de.kvconnect.bundle.common.gui;

import java.awt.Image;
import java.awt.Toolkit;

import org.apache.commons.io.FilenameUtils;

import de.kvconnect.bundle.common.ClassProperties;
import de.kvconnect.bundle.common.PathUtils;
import de.kvconnect.bundle.common.io.IOUtils;

/**
 * Diese Klasse stellt Images fuer die Applikation bereit.
 * 
 * @author hartmann_t
 */
public final class ImageProvider
{
	public static final String RESOURCE_TRAY_ICON = "resource.tray.icon";

	public static final String DEFAULT_TRAY_ICON = "teleblue_02_16x16.png";

	static ClassProperties classProperties = new ClassProperties(ImageProvider.class);

	/**
	 * Singleton
	 */
	private ImageProvider()
	{
	}

	/**
	 * @return {@link Image} Objekt mit dem Tray Icon, falls keins vorhanden, wird ein Default aus
	 *         dem Jar genommen.
	 */
	public static Image getTrayIcon()
	{
		String resourceTrayIcon = DEFAULT_TRAY_ICON;
		String iconPath = (String) classProperties.get(RESOURCE_TRAY_ICON);
		if (iconPath != null)
		{
			resourceTrayIcon = FilenameUtils.concat(PathUtils.getBaseDir(), iconPath);
			if (!IOUtils.isFileExists(resourceTrayIcon))
			{
				resourceTrayIcon = DEFAULT_TRAY_ICON;
			}
		}
		return Toolkit.getDefaultToolkit().getImage(resourceTrayIcon);
	}
}

package de.kvconnect.bundle.common.mail;

/**
 * Definiert gaengige ContentType Werte als Konstante.
 * 
 * @author wojciechowski_a
 */
public enum ContentType {
	TYPE_MESSAGE_RFC822("message/rfc822"), TYPE_TEXT_PLAIN("text/plain"), TYPE_MULTIPART_PREFIX("multipart/"), TYPE_IMAGE(
		"image/gif");

	private String value;

	private ContentType(String value)
	{
		this.value = value;
	}

	public boolean isType(String value)
	{
		return value.toLowerCase().startsWith(this.value);
	}

	@Override
	public String toString()
	{
		return value;
	}
}

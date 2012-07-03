package de.kvconnect.bundle.common.mail;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.Validate;

/**
 * Spezifiziert allgemeine Mail-Header als Konstanten.
 * 
 * @author wojciechowski_a
 */
public enum Headers {

	DISPOSITION_NOTIFICATION_TO("Disposition-Notification-To"), //
	MESSAGE_ID("Message-Id"), //
	FROM("From"), //
	TO("To"), //
	RETURN_PATH("Return-Path"), //
	RECEIVED("Received"), //
	RESENT_FROM("Resent-From"), //
	RESENT_SENDER("Resent-Sender"), //
	RESENT_TO("Resent-To"), //
	RESENT_CC("Resent-Cc"), //
	RESENT_BCC("Resent-Bcc"), //
	DATE("Date"), //
	SENDER("Sender"), //
	REPLY_TO("Reply-To"), //
	CC("Cc"), //
	BCC("Bcc"), //
	REFERENCES("References"), //
	SUBJECT("Subject"), //
	COMMENTS("Comments"), //
	KEYWORDS("Keywords"), //
	ERRORS_TO("Errors-To"), //
	MIME_VERSION("MIME-Version"), //
	CONTENT_TYPE("Content-Type"), //
	CONTENT_TRANSFER_ENCODING("Content-Transfer-Encoding"), //
	CONTENT_MD5("Content-MD5"), //
	CONTENT_LENGTH("Content-Length"), //
	STATUS("Status");

	/** Zuordnungstabelle von Namen (in Kleinbuchstaben) und Konstante. */
	private static final Map<String, Headers> LOOKUP = new HashMap<String, Headers>();

	static
	{
		for (Headers header : EnumSet.allOf(Headers.class))
		{
			LOOKUP.put(header.toString().toLowerCase(), header);
		}
	}

	/** Name des Headers */
	private String value;

	/**
	 * Erzeugt eine Instanz von {@link Headers}.
	 * 
	 * @param value Name des Headers
	 */
	private Headers(String value)
	{
		this.value = value;
	}

	/**
	 * <pre>
	 * Headers.MESSAGE_ID.toString() -> "Message-Id"
	 * Headers.get("Blub").toString() -> NullPointerException
	 * </pre>
	 * 
	 * @return name des Headers, null bei nicht definierten Headern.
	 */
	@Override
	public String toString()
	{
		return value;
	}

	/**
	 * Ermittelt den Header den die Zeichenkette repraesentiert.
	 * 
	 * <pre>
	 * Headers.get("Message-id") -> Headers.MESSAGE_Id
	 * Headers.get("Message-ID") -> Headers.MESSAGE_Id
	 * Headers.get("message-id") -> Headers.MESSAGE_Id
	 * Headers.get("Message") -> null
	 * Headers.get("") -> IllegalArgumentException
	 * Headers.get(null) -> IllegalArgumentException
	 * </pre>
	 * 
	 * @param string
	 * @return
	 */
	public static Headers get(String string)
	{
		Validate.notEmpty(string);
		return LOOKUP.get(string.toLowerCase());
	}

	/**
	 * Liefert die definierte Schreibweise des Headernamens, sofern sie als Header spezifiziert ist,
	 * sonst die uebergebenen Wert.
	 * 
	 * <pre>
	 * Headers.getName("Message-id") -> "Message-Id"
	 * Headers.getName("Message-ID") -> "Message-Id"
	 * Headers.getName("message-id") -> "Message-Id"
	 * Headers.getName("Message") -> "Message"
	 * Headers.getName("") -> IllegalArgumentException
	 * Headers.getName(null) -> IllegalArgumentException
	 * </pre>
	 * 
	 * @param value zu suchender Header Name als String. Der Wert darf weder null noch leer sein.
	 * @return definierter Headername; sont value
	 */
	public static String getName(String value)
	{
		Headers hd = get(value);
		if (hd == null)
		{
			return value;
		}
		return hd.toString();
	}
}

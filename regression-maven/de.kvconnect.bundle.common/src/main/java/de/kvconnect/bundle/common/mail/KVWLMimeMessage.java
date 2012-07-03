package de.kvconnect.bundle.common.mail;

import java.io.InputStream;

import javax.mail.Flags;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.ArrayUtils;

/**
 * MimeMessage mit konstanter MessageID.
 * 
 * @author Birgit Haas
 */
public class KVWLMimeMessage extends MimeMessage
{

	/**
	 * Parst und erstellt eine Mime Nachricht aus einem gegebenem MIME InputStream. Der InputStream
	 * wird dabei zum Ende der Nachrichtendaten verschoben. Der Parse-Vorgang wird direkt im
	 * Konstruktor ausgefuehrt. Der Input stream enthaelt eine vollstaendig formattierte MIME
	 * Nachricht mit allen Header- und Textdaten.
	 * 
	 * @param session Session fuer diese Nachricht
	 * @param is der InputStream der Nachricht
	 * @throws MessagingException wenn die MIME Nachricht nicht erstellt werden konnte
	 */
	public KVWLMimeMessage(Session session, InputStream is) throws MessagingException
	{
		super(session, is);
	}

	/**
	 * Standard Konstruktor. Erstellt ein leeres Nachrichtenobjekt. Die Headerfelder werden auf ein
	 * leeres {@link InternetHeaders} Objekt gesetzt. Das Flag-Feld wird auf ein leeres
	 * {@link Flags} Objekt gesetzt. Das Modified-Flag wird gesetzt.
	 * 
	 * @param session Session fuer diese Nachricht
	 * @throws MessagingException wenn die MIME Nachricht nicht erstellt werden konnte
	 */
	public KVWLMimeMessage(Session session) throws MessagingException
	{
		super(session);
	}

	/**
	 * Ueberschreiben der Methode MimeMessage.setHeader. Falls der angegebene Header die Message-ID
	 * angibt, wird super.setHeader nur ausgefuehrt, wenn noch keine Message-ID gesetzt wurde. Fuer
	 * alle anderen Header wird super.setHeader aufgerufen.
	 * 
	 * @param name Name des Headers
	 * @param value Wert des Headers
	 */
	@Override
	public void setHeader(String name, String value)
	{
		if (Headers.get(name) == Headers.MESSAGE_ID)
		{
			String[] values = headers.getHeader(name);
			if (ArrayUtils.isEmpty(values))
			{
				headers.setHeader(name, value);
			}
		}
		else
		{
			headers.setHeader(name, value);
		}
	}

}

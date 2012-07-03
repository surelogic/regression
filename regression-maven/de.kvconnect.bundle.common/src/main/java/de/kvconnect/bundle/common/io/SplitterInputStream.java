package de.kvconnect.bundle.common.io;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Hilfsklasse um einen InputStream mit einem spezifizierten Trenner einzulesen, um ihn dann
 * unterteilt wieder auslesen zu können.
 * 
 * @author tran_l, hartmann_t
 * 
 * @see InputStream
 * @see InputStreamReader
 */
public class SplitterInputStream extends InputStreamReader
{
	private final Scanner scan;

	public SplitterInputStream(InputStream inStream, String delimiter)
	{
		super(inStream);
		scan = new Scanner(this).useDelimiter(delimiter);
	}

	public boolean hasNext()
	{
		return scan.hasNext();
	}

	public String next()
	{
		return scan.next();
	}
}

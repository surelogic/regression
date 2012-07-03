package de.kvconnect.bundle.common.io;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

/**
 * Die Klasse bietet mehrere InputStreams zu einem InputStream zu vereinigen
 * 
 * @author tran_l
 */
public class ConcatInputStreamWithDelimiter extends ConcatInputStream
{
	private String delimiter;

	public ConcatInputStreamWithDelimiter(String delimiter)
	{
		super();
		this.delimiter = delimiter;
	}

	public ConcatInputStreamWithDelimiter(InputStream in1, InputStream in2, String delimiter)
	{
		this(delimiter);
		addInputStream(in1);
		addInputStream(in2);
	}

	public ConcatInputStreamWithDelimiter(InputStream in, String delimiter)
	{
		this(delimiter);
		addInputStream(in);
	}

	public ConcatInputStreamWithDelimiter(InputStream[] in, String delimiter)
	{
		this(delimiter);
		addInputStreams(in);
	}

	@Override
	public void addInputStreams(InputStream[] in)
	{
		for (InputStream element : in)
		{
			addInputStream(element);
		}
	}

	@Override
	public void addInputStream(InputStream in)
	{
		if (StringUtils.isBlank(delimiter))
		{
			throw new IllegalStateException("Delimiter is not defined");
		}

		if (!super.isEmpty())
		{
			super.addInputStream(IOUtils.toInputStream(delimiter));
		}

		super.addInputStream(in);
	}

	/**
	 * Gibt die InputStreams als einen einzigen InputStream zurück
	 * 
	 * @return {@link InputStream}
	 * @throws IOException
	 */
	public InputStream getInputStream() throws IOException
	{
		lastInputStreamAdded();
		return this;
	}

	@Override
	public int read() throws IOException
	{
		return super.read();
	}
}

package de.kvconnect.bundle.common.io;

import java.io.IOException;

import junit.framework.Assert;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

public class ConcatInputStreamWithDelimiterTest
{
	private String delimiter = "xxx 0123456789 xxx";

	ConcatInputStreamWithDelimiter classUnderTest;

	@Before
	public void startup()
	{
		classUnderTest = new ConcatInputStreamWithDelimiter(delimiter);
	}

	@Test
	public void test() throws IOException
	{
		String[] values = new String[] { "Klaus", "Hugo", "Oskar", "Asso" };

		classUnderTest.addInputStream(IOUtils.toInputStream(values[0]));
		classUnderTest.addInputStream(IOUtils.toInputStream(values[1]));
		classUnderTest.addInputStream(IOUtils.toInputStream(values[2]));
		classUnderTest.addInputStream(IOUtils.toInputStream(values[3]));
		Assert.assertFalse(classUnderTest.isEmpty());

		SplitterInputStream splitterInputStream = new SplitterInputStream(classUnderTest.getInputStream(), delimiter);

		int counter = 0;
		while (splitterInputStream.hasNext())
		{
			// Prüfe Anzahl
			Assert.assertTrue(counter++ <= values.length);

			// Prüfe Inhalt
			String nextString = splitterInputStream.next();
			Assert.assertFalse(nextString == null);
			Assert.assertTrue(nextString.length() > 0);
		}
		splitterInputStream.close();
	}
}

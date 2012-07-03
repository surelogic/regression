package de.kvconnect.bundle.common.mail;

import junit.framework.Assert;

import org.junit.Test;

public class HeadersTest
{
	static final String UNDEFINED_HEADER = "blub";

	@Test
	public void testToString()
	{
		Assert.assertEquals(Headers.MESSAGE_ID.toString(), Headers.getName("message-id"));
	}

	@Test
	public void testGet()
	{
		Assert.assertEquals(Headers.MESSAGE_ID, Headers.get("message-id"));
		Assert.assertEquals(Headers.MESSAGE_ID, Headers.get("message-ID"));
		Assert.assertEquals(Headers.MESSAGE_ID, Headers.get("MESSAGE-ID"));
		Assert.assertEquals(Headers.MESSAGE_ID, Headers.get("Message-Id"));
		Assert.assertEquals(null, Headers.get(UNDEFINED_HEADER));
	}

	@Test
	public void testGetName()
	{
		Assert.assertEquals(Headers.MESSAGE_ID.toString(), Headers.getName("message-id"));
		Assert.assertEquals(Headers.MESSAGE_ID.toString(), Headers.getName("message-ID"));
		Assert.assertEquals(Headers.MESSAGE_ID.toString(), Headers.getName("MESSAGE-ID"));
		Assert.assertEquals(Headers.MESSAGE_ID.toString(), Headers.getName("Message-Id"));
		Assert.assertEquals(UNDEFINED_HEADER, Headers.getName(UNDEFINED_HEADER));
	}

}

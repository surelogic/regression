package de.kvconnect.bundle.common;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.kvconnect.bundle.common.PasswordUtil.PasswordCheckResponse;

public class PasswordUtilTest
{

	private static PasswordUtil classUnderTest;

	@BeforeClass
	public static void setup()
	{
		classUnderTest = new PasswordUtil();
	}

	@Before
	public void initTest()
	{
		classUnderTest.setPasswordLength(8);
		classUnderTest.setNroLowerCharacters(2);
		classUnderTest.setNroUpperCharacters(2);
		classUnderTest.setNroNumbers(1);
		classUnderTest.setNroSpecial(0);
	}

	@Test
	public void simpleRandomPassswordTest() throws Exception
	{
		char[] randomPassword = classUnderTest.createRandomPassword();
		Assert.assertNotNull(randomPassword);
		Assert.assertFalse(randomPassword.length == 0);
		Assert.assertTrue(randomPassword.length == classUnderTest.getPasswordLength());
	}

	@Test
	public void lengthRandomPassswordTest() throws Exception
	{
		int len = 20;
		classUnderTest.setPasswordLength(len);
		char[] randomPassword = classUnderTest.createRandomPassword();
		Assert.assertNotNull(randomPassword);
		Assert.assertFalse(randomPassword.length == 0);
		Assert.assertTrue(randomPassword.length == len);
	}

	@Test
	public void checkPassswordOKTest() throws Exception
	{
		String password = "AB2abcde";
		checkResponse(password, PasswordCheckResponse.OK);
		password = "AAAAAA2ab";
		checkResponse(password, PasswordCheckResponse.OK);
		password = "ABCDEFGHIJKLMNOPQRSTUVWXYZxxx1";
		checkResponse(password, PasswordCheckResponse.OK);
		password = "1abcABCD";
		checkResponse(password, PasswordCheckResponse.OK);
		password = "0123456789xxAA";
		checkResponse(password, PasswordCheckResponse.OK);
	}

	@Test
	public void checkNullTest() throws Exception
	{
		checkResponse(null, PasswordCheckResponse.TOO_SHORT);
	}

	@Test
	public void checkTooShortTest() throws Exception
	{
		String password = "";
		checkResponse(password, PasswordCheckResponse.TOO_SHORT);
		password = " ";
		checkResponse(password, PasswordCheckResponse.TOO_SHORT);
		password = "xxxxxx";
		checkResponse(password, PasswordCheckResponse.TOO_SHORT);
		password = "  a  ";
		checkResponse(password, PasswordCheckResponse.TOO_SHORT);
	}

	@Test
	public void checkNeSpecialCharsTest() throws Exception
	{
		classUnderTest.setNroSpecial(2);
		String password = "ABcdefg1";
		checkResponse(password, PasswordCheckResponse.NE_SPECIAL_CHARACTERS);
	}

	private void checkResponse(String password, PasswordCheckResponse state)
	{
		char[] testPwd;
		if (password == null)
		{
			testPwd = null;
		}
		else
		{
			testPwd = password.toCharArray();
		}

		PasswordCheckResponse checkResponse = classUnderTest.check(testPwd);

		Assert.assertEquals(state, checkResponse);
	}
}

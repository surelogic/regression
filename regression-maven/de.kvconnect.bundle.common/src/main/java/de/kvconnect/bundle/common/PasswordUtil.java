package de.kvconnect.bundle.common;

import java.security.SecureRandom;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class PasswordUtil
{
	// Der einfachheithalber an dieser Stelle die Passwort Richtlinien eingetragen:
	//
	// "Das Passwort muss aus
	// mindestens acht Zeichen bestehen und mindestens
	// zwei Kleinbuchstaben,
	// zwei Groﬂbuchstaben und 
	// und eine Zahl enthalten."
	//
	private int passwordLength = 8;
	private int nroUpperCharacters = 2;
	private int nroLowerCharacters = 2;
	private int nroNumbers = 1;
	private int nroSpecial = 0;

	private static final String ALLOWED_UPPER_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String ALLOWED_LOWER_CHARS = "abcdefghijklmnopqrstuvwxyz";
	private static final String ALLOWED_NUMBERS = "0123456789";
	private static final String ALLOWED_SPECIALS = "!$%&()=?+#*~-_.,;:<>|@^{[]}";
	private static final String GP_NUMBERS = "23456789";
	private static final String GP_SPECIALS = "$%&()=?+#*-<>@[]";

	private static final String PREFIX_SHA256 = "{SHA256}";

	public static enum PasswordCheckResponse {
		OK, //
		TOO_SHORT, //
		NE_UPPER_CHARACTERS, //
		NE_LOWER_CHARACTERS, //
		NE_NUMBERS, //
		NE_SPECIAL_CHARACTERS;
	}

	public PasswordCheckResponse check(char[] password)
	{
		if (password == null || password.length < passwordLength)
		{
			return PasswordCheckResponse.TOO_SHORT;
		}

		if (!contains(password, ALLOWED_UPPER_CHARS.toCharArray(), nroUpperCharacters))
		{
			return PasswordCheckResponse.NE_UPPER_CHARACTERS;
		}

		if (!contains(password, ALLOWED_LOWER_CHARS.toCharArray(), nroLowerCharacters))
		{
			return PasswordCheckResponse.NE_LOWER_CHARACTERS;
		}

		if (!contains(password, ALLOWED_NUMBERS.toCharArray(), nroNumbers))
		{
			return PasswordCheckResponse.NE_NUMBERS;
		}

		if (!contains(password, ALLOWED_SPECIALS.toCharArray(), nroSpecial))
		{
			return PasswordCheckResponse.NE_SPECIAL_CHARACTERS;
		}

		return PasswordCheckResponse.OK;
	}

	public char[] createRandomPassword()
	{
		char[] result = new char[passwordLength];
		boolean[] isSpecial = new boolean[passwordLength];

		SecureRandom rand = new SecureRandom();

		for (int i = 0; i < passwordLength; ++i)
		{
			result[i] = ALLOWED_LOWER_CHARS.charAt(rand.nextInt(ALLOWED_LOWER_CHARS.length()));
		}

		fillSpecial(result, isSpecial, rand, GP_SPECIALS, nroSpecial);
		fillSpecial(result, isSpecial, rand, GP_NUMBERS, nroNumbers);
		fillSpecial(result, isSpecial, rand, ALLOWED_UPPER_CHARS, nroUpperCharacters);

		return result;
	}

	private void fillSpecial(char[] result, boolean[] isSpecial, SecureRandom rand, String list, int count)
	{
		for (int i = 0; i < count; ++i)
		{
			int r;
			do
			{
				r = rand.nextInt(result.length);
			}
			while (isSpecial[r]);
			isSpecial[r] = true;
			result[r] = list.charAt(rand.nextInt(list.length()));
		}
	}

	private boolean contains(char[] test, char[] elements, int count)
	{
		if (elements.length == 0)
		{
			return true;
		}

		char[] elementsCopy = Arrays.copyOf(elements, elements.length);

		Arrays.sort(elementsCopy);
		for (int i = 0; i < test.length; ++i)
		{
			if (Arrays.binarySearch(elementsCopy, test[i]) >= 0)
			{
				--count;
			}
		}

		return count <= 0;
	}

	public static String getPasswordHashSHA256(String password)
	{
		byte[] hash = DigestUtils.sha256(password);
		return PREFIX_SHA256 + new String(Base64.encodeBase64(hash));
	}

	public int getPasswordLength()
	{
		return passwordLength;
	}

	public void setPasswordLength(int passwordLength)
	{
		this.passwordLength = passwordLength;
	}

	public int getNroNumbers()
	{
		return nroNumbers;
	}

	public void setNroNumbers(int nroNumbers)
	{
		this.nroNumbers = nroNumbers;
	}

	public int getNroSpecial()
	{
		return nroSpecial;
	}

	public void setNroSpecial(int nroSpecial)
	{
		this.nroSpecial = nroSpecial;
	}

	public int getNroUpperCharacters()
	{
		return nroUpperCharacters;
	}

	public int getNroLowerCharacters()
	{
		return nroLowerCharacters;
	}

	public void setNroUpperCharacters(int nroUpperCharacters)
	{
		this.nroUpperCharacters = nroUpperCharacters;
	}

	public void setNroLowerCharacters(int nroLowerCharacters)
	{
		this.nroLowerCharacters = nroLowerCharacters;
	}

	/**
	 * String-Ziffern in 'x' umwandeln, um z.B. Passwoerter zu loggen.
	 * 
	 * @param in umzuwandelnder String
	 * @return Umgewandelter String, bei der Eingabe von <code>null</code> wird ein leerer String
	 *         retourniert
	 */
	public static String blindString(String in)
	{
		if (in == null)
		{
			return "";
		}
		return in.replaceAll(".", "x");
	}
}
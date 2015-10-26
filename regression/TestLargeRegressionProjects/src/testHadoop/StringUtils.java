package testHadoop;

public class StringUtils {
	public static String join(CharSequence separator, Iterable<?> strings) {
		/*
		Iterator<?> i = strings.iterator();
		if (!i.hasNext()) {
			return "";
		}
		StringBuilder sb = new StringBuilder(i.next().toString());
		while (i.hasNext()) {
			sb.append(separator);
			sb.append(i.next().toString());
		}
		return sb.toString();
		*/
		return null;
	}

	/**
	 * Concatenates strings, using a separator.
	 *
	 * @param separator to join with
	 * @param strings to join
	 * @return  the joined string
	 */
	public static String join(CharSequence separator, String[] strings) {
		return null;
	}
}

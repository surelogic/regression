package testVertx.cli;

import java.util.*;
import java.util.stream.Collectors;

public class DefaultCommandLine {
	public static <T> List<T> createFromList(String raw, TypedOption<T> option) {
		if (raw == null) {
			return Collections.emptyList();
		}
		final String[] segments = raw.split(option.getListSeparator());
		return Arrays.stream(segments).map(s -> create(s.trim(), option)).collect(Collectors.toList());
	}
	
	public static <T> T create(String value, TypedOption<T> option) {
		return null;
	}
}

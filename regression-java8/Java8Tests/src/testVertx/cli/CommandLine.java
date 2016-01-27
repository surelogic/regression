package testVertx.cli;

import java.util.List;

import testVertx.Nullable;

public interface CommandLine {
	/**
	 * @return the ordered list of arguments. Arguments are command line arguments not matching an option.
	 */
	List<String> allArguments();

	/**
	 * Gets the value of an option with the matching name (can be the long name, short name or arg name).
	 *
	 * @param name the name
	 * @param <T>  the expected type
	 * @return the value, {@code null} if not set
	 */
	@Nullable
	<T> T getOptionValue(String name);
}

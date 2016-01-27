package testVertx.cli;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.fail;

public class IntensiveDefaultParserTest {
	private /*Default*/CLI cli;

	public void testSimpleShort() throws Exception {
		String[] args = new String[]{
				"-a",
				"-b", "toast",
				"foo", "bar"};
		CommandLine evaluated = cli.parse(Arrays.asList(args));

		assertThat(getBooleanOption(evaluated, "a")).isTrue();
		assertThat(getStringOption(evaluated, "b")).isEqualTo("toast");
		assertThat(getBooleanOption(evaluated, "c")).isFalse();
		assertThat(evaluated.allArguments()).contains("foo", "bar").hasSize(2);
	}

	private boolean getBooleanOption(CommandLine evaluatedCLI, String name) {
		return evaluatedCLI.getOptionValue(name);
	}

	private String getStringOption(CommandLine evaluatedCLI, String name) {
		return evaluatedCLI.getOptionValue(name);
	}
}

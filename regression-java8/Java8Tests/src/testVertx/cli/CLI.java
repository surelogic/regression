package testVertx.cli;

import java.util.List;

public interface CLI {
	public CommandLine parse(List<String> arguments);
}

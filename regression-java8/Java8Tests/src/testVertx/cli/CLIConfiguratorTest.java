package testVertx.cli;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

public class CLIConfiguratorTest {
	private CommandLine parse(CLI cli, String... args) throws CLIException {
		return null;
	}
	
	public void testMultiValuesInjection() throws CLIException {
		CLIWithMultipleValues command = new CLIWithMultipleValues();
		CLI cli = CLIConfigurator.define(command.getClass());

		CommandLine evaluatedCLI = parse(cli, "--persons=x", "--persons", "y", "z");
		CLIConfigurator.inject(evaluatedCLI, command);
		assertThat(command.persons).hasSize(3);

		evaluatedCLI = parse(cli, "--persons2=x", "--persons2", "y", "z");
		CLIConfigurator.inject(evaluatedCLI, command);
		assertThat(command.persons2).hasSize(3);

		evaluatedCLI = parse(cli, "--persons3=x", "--persons3", "y", "z");
		CLIConfigurator.inject(evaluatedCLI, command);
		assertThat(command.persons3).hasSize(3);

		evaluatedCLI = parse(cli, "--persons4=x:y:z");
		CLIConfigurator.inject(evaluatedCLI, command);
		assertThat(command.persons4).hasSize(3);

		evaluatedCLI = parse(cli, "--states=NEW", "--states", "BLOCKED", "RUNNABLE");
		CLIConfigurator.inject(evaluatedCLI, command);
		assertThat(command.states).hasSize(3).containsExactly(Thread.State.NEW, Thread.State.BLOCKED,
				Thread.State.RUNNABLE);
		//...
	}
	
	private class CLIWithMultipleValues {		
	    List<Person> persons;
	    List<Person> persons2;
	    List<Person> persons3;
	    Set<Thread.State> states;		
	    
	    Collection<Integer> ints;
	    Set<String> strings;
	    List<Short> shorts;
	    double[] doubles;

	    List<Person> persons4;
	}
}
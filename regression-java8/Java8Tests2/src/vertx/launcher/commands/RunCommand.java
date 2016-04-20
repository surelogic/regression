package vertx.launcher.commands;

import java.util.*;
import java.util.stream.Collectors;

import vertx.core.Handler;

public class RunCommand extends BareCommand {
	protected void startAsBackgroundApplication(Handler<Void> onCompletion) {
		// We need to copy all options and arguments.
		List<String> args = new ArrayList<>();
		/*
		// Prepend the command.
		args.add("run");
		args.add("--vertx-id=" + vertxApplicationBackgroundId);
		args.addAll(executionContext.commandLine().allArguments());
		// No need to add the main-verticle as it's part of the allArguments list.
		if (cluster) {
			args.add("--cluster");
		}
		if (clusterHost != null) {
			args.add("--cluster-host=" + clusterHost);
		}
		if (clusterPort != 0) {
			args.add("--cluster-port=" + clusterPort);
		}
		if (ha) {
			args.add("--ha");
		}
		if (haGroup != null && !haGroup.equals("__DEFAULT__")) {
			args.add("--hagroup=" + haGroup);
		}
		if (quorum != -1) {
			args.add("--quorum=" + quorum);
		}
		if (classpath != null && !classpath.isEmpty()) {
			args.add("--classpath=" + classpath.stream().collect(Collectors.joining(File.pathSeparator)));
		}
		if (config != null) {
			args.add("--conf=" + config);
		}
		if (instances != 1) {
			args.add("--instances=" + instances);
		}
		if (worker) {
			args.add("--worker");
		}
		*/
		if (systemProperties != null) {
			args.addAll(systemProperties.stream().map(s -> "-D" + s).collect(Collectors.toList()));
		}
		/*
		// Enable stream redirection
		args.add("--redirect-output");

		executionContext.execute("start", args.toArray(new String[args.size()]));
		if (onCompletion != null) {
			onCompletion.handle(null);
		}
		*/
	}
}

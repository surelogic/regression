package testHadoop;

import java.util.Map;

public class TimedOutTestsListener /*extends RunListener*/ {
	static String buildThreadDump() {
		StringBuilder dump = new StringBuilder();
		Map<Thread, StackTraceElement[]> stackTraces = Thread.getAllStackTraces();
		for (Map.Entry<Thread, StackTraceElement[]> e : stackTraces.entrySet()) {
			Thread thread = e.getKey();
			dump.append(String.format(
					"\"%s\" %s prio=%d tid=%d %s\njava.lang.Thread.State: %s",
					thread.getName(),
					(thread.isDaemon() ? "daemon" : ""),
					thread.getPriority(),
					thread.getId(),
					Thread.State.WAITING.equals(thread.getState()) ? 
							"in Object.wait()" : thread.getState().name().toLowerCase(),
							Thread.State.WAITING.equals(thread.getState()) ? 
									"WAITING (on object monitor)" : thread.getState()));
			for (StackTraceElement stackTraceElement : e.getValue()) {
				dump.append("\n        at ");
				dump.append(stackTraceElement);
			}
			dump.append("\n");
		}
		return dump.toString();
	}
}

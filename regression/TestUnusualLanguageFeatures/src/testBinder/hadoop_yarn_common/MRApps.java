package testBinder.hadoop_yarn_common;

import static testBinder.hadoop_yarn_common.StringHelper.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Helper class for MR applications
 */
public class MRApps extends Apps {
  public static final String JOB = "job";
  public static final String TASK = "task";
  public static final String ATTEMPT = "attempt";

  public static String toString(JobId jid) {
    return null;
  }

  public static JobId toJobID(String jid) {
    Iterator<String> it = _split(jid).iterator();
    return toJobID(JOB, jid, it);
  }

  // mostly useful for parsing task/attempt id like strings
  public static JobId toJobID(String prefix, String s, Iterator<String> it) {
    return null;
  }
  
  public static void setClasspath(Map<String, String> environment,
      Configuration conf) throws IOException {
  }

  
  /**
   * Add the JVM system properties necessary to configure {@link ContainerLogAppender}.
   * @param logLevel the desired log level (eg INFO/WARN/DEBUG)
   * @param logSize See {@link ContainerLogAppender#setTotalLogFileSize(long)}
   * @param vargs the argument list to append to
   */
  public static void addLog4jSystemProperties(
      String logLevel, long logSize, List<String> vargs) {
  }
}

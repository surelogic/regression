package testBinder.hadoop_yarn_common;

import java.util.Iterator;
import java.util.Map;

import static testBinder.hadoop_yarn_common.StringHelper.*;

/**
 * Yarn application related utilities
 */
public class Apps {
  public static final String APP = "application";
  public static final String ID = "ID";

  public static ApplicationId toAppID(String aid) {
    Iterator<String> it = _split(aid).iterator();
    return toAppID(APP, aid, it);
  }

  public static ApplicationId toAppID(String prefix, String s, Iterator<String> it) {
    if (!it.hasNext() || !it.next().equals(prefix)) {
      throwParseException(sjoin(prefix, ID), s);
    }
    shouldHaveNext(prefix, s, it);
    ApplicationId appId = RecordFactoryProvider.getRecordFactory(null).newRecordInstance(ApplicationId.class);
    appId.setClusterTimestamp(Long.parseLong(it.next()));
    shouldHaveNext(prefix, s, it);
    appId.setId(Integer.parseInt(it.next()));
    return appId;
  }

  public static void shouldHaveNext(String prefix, String s, Iterator<String> it) {
    if (!it.hasNext()) {
      throwParseException(sjoin(prefix, ID), s);
    }
  }

  public static void throwParseException(String name, String s) {
    throw new YarnException(join("Error parsing ", name, ": ", s));
  }

  public static void setEnvFromInputString(Map<String, String> env,
      String envString) {
    if (envString != null && envString.length() > 0) {
      String childEnvs[] = envString.split(",");
      for (String cEnv : childEnvs) {
        String[] parts = cEnv.split("="); // split on '='
        String value = env.get(parts[0]);

        if (value != null) {
          // Replace $env with the child's env constructed by NM's
          // For example: LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/tmp
          value = parts[1].replace("$" + parts[0], value);
        } else {
          // example PATH=$PATH:/tmp
          value = System.getenv(parts[0]);
          if (value != null) {
            // the env key is present in the tt's env
            value = parts[1].replace("$" + parts[0], value);
          } else {
            // check for simple variable substitution
            // for e.g. ROOT=$HOME
            String envValue = System.getenv(parts[1].substring(1));
            if (envValue != null) {
              value = envValue;
            } else {
              // the env key is note present anywhere .. simply set it
              // example X=$X:/tmp or X=/tmp
              value = parts[1].replace("$" + parts[0], "");
            }
          }
        }
        addToEnvironment(env, parts[0], value);
      }
    }
  }

  private static final String SYSTEM_PATH_SEPARATOR =
      System.getProperty("path.separator");

  public static void addToEnvironment(
      Map<String, String> environment,
      String variable, String value) {
    String val = environment.get(variable);
    if (val == null) {
      val = value;
    } else {
      val = val + SYSTEM_PATH_SEPARATOR + value;
    }
    environment.put(variable, val);
  }
}

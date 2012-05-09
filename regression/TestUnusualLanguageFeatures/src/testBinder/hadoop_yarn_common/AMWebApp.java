package testBinder.hadoop_yarn_common;

import static testBinder.hadoop_yarn_common.StringHelper.pajoin;

/**
 * Application master webapp
 */
public class AMWebApp extends WebApp implements AMParams {
  //@Override
  public void setup() {
    bind(JAXBContextResolver.class);
    bind(GenericExceptionHandler.class);
    bind(AMWebServices.class);
    route("/", AppController.class);
    route("/app", AppController.class);
    route(pajoin("/job", JOB_ID), AppController.class, "job");
    route(pajoin("/conf", JOB_ID), AppController.class, "conf");
    route(pajoin("/jobcounters", JOB_ID), AppController.class, "jobCounters");
    route(pajoin("/singlejobcounter",JOB_ID, COUNTER_GROUP, COUNTER_NAME),
        AppController.class, "singleJobCounter");
    route(pajoin("/tasks", JOB_ID, TASK_TYPE), AppController.class, "tasks");
    route(pajoin("/attempts", JOB_ID, TASK_TYPE, ATTEMPT_STATE),
        AppController.class, "attempts");
    route(pajoin("/task", TASK_ID), AppController.class, "task");
    route(pajoin("/taskcounters", TASK_ID), AppController.class, "taskCounters");
    route(pajoin("/singletaskcounter",TASK_ID, COUNTER_GROUP, COUNTER_NAME),
        AppController.class, "singleTaskCounter");
  }
}

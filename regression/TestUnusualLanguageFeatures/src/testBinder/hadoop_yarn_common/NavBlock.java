package testBinder.hadoop_yarn_common;

import java.util.List;

import static testBinder.hadoop_yarn_common.AMWebApp.*;

import testBinder.hadoop_yarn_common.Hamlet.*;

public class NavBlock extends HtmlBlock {
  final App app;

  NavBlock(App app) { this.app = app; }

  @Override protected void render(Block html) {
    String rmweb = $(RM_WEB);
    DIV<Hamlet> nav;
    UL<DIV<Hamlet>> temp = html.
      div("#nav").
        h3("Cluster").
        ul().
          li().a(url(rmweb, "cluster", "cluster"), "About")._();//.
    
    LI<UL<DIV<Hamlet>>> test = temp.li().a(url(rmweb, "cluster", "apps"), "Applications");
    test._().li();
    
    UL<DIV<Hamlet>> temp2 = temp.
          li().a(url(rmweb, "cluster", "apps"), "Applications")._().
          li().a(url(rmweb, "cluster", "scheduler"), "Scheduler")._()._().
        h3("Application").
        ul();//.
    UL<DIV<Hamlet>> temp3 = temp2.
          li().a(url("app/info"), "About")._();//.
    nav = temp3.
          li().a(url("app"), "Jobs")._()._();
    if (app.getJob() != null) {
      String jobid = MRApps.toString(app.getJob().getID());
      List<AMInfo> amInfos = app.getJob().getAMInfos();
      AMInfo thisAmInfo = amInfos.get(amInfos.size()-1);
      String nodeHttpAddress = thisAmInfo.getNodeManagerHost() + ":" 
          + thisAmInfo.getNodeManagerHttpPort();
      nav.
        h3("Job").
        ul().
          li().a(url("job", jobid), "Overview")._().
          li().a(url("jobcounters", jobid), "Counters")._().
          li().a(url("conf", jobid), "Configuration")._().
          li().a(url("tasks", jobid, "m"), "Map tasks")._().
          li().a(url("tasks", jobid, "r"), "Reduce tasks")._().
          li().a(".logslink", url("http://", nodeHttpAddress, "node",
              "containerlogs", thisAmInfo.getContainerId().toString(), 
              app.getJob().getUserName()), 
              "AM Logs")._()._();
      if (app.getTask() != null) {
        String taskid = MRApps.toString(app.getTask().getID());
        nav.
          h3("Task").
          ul().
            li().a(url("task", taskid), "Task Overview")._().
            li().a(url("taskcounters", taskid), "Counters")._()._();
      }
    }
    nav.
      h3("Tools").
      ul().
        li().a("/conf", "Configuration")._().
        li().a("/logs", "Local logs")._().
        li().a("/stacks", "Server stacks")._().
        li().a("/metrics", "Server metrics")._()._()._().
    div("#themeswitcher")._();
  }
}

package testBinder.hadoop_yarn_common;

public interface AMInfo {
  public ApplicationAttemptId getAppAttemptId();
  public long getStartTime();
  public ContainerId getContainerId();
  public String getNodeManagerHost();
  public int getNodeManagerPort();
  public int getNodeManagerHttpPort();

  public void setAppAttemptId(ApplicationAttemptId appAttemptId);
  public void setStartTime(long startTime);
  public void setContainerId(ContainerId containerId);
  public void setNodeManagerHost(String nmHost);
  public void setNodeManagerPort(int nmPort);
  public void setNodeManagerHttpPort(int mnHttpPort);
}
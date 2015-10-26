package testHadoop;

import testHadoop.Counters.Counter;

import java.io.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

public class TestTaskAttemptListenerImpl {
	public void testCheckpointIDTracking()
			throws IOException, InterruptedException{	
		/*
		SystemClock clock = new SystemClock();

		org.apache.hadoop.mapreduce.v2.app.job.Task mockTask =
				mock(org.apache.hadoop.mapreduce.v2.app.job.Task.class);
		when(mockTask.canCommit(any(TaskAttemptId.class))).thenReturn(true);
		Job mockJob = mock(Job.class);
		when(mockJob.getTask(any(TaskId.class))).thenReturn(mockTask);

		Dispatcher dispatcher = mock(Dispatcher.class);
		EventHandler ea = mock(EventHandler.class);
		when(dispatcher.getEventHandler()).thenReturn(ea);

		RMHeartbeatHandler rmHeartbeatHandler =
				mock(RMHeartbeatHandler.class);

		AppContext appCtx = mock(AppContext.class);
		when(appCtx.getJob(any(JobId.class))).thenReturn(mockJob);
		when(appCtx.getClock()).thenReturn(clock);
		when(appCtx.getEventHandler()).thenReturn(ea);
		JobTokenSecretManager secret = mock(JobTokenSecretManager.class);
		final TaskHeartbeatHandler hbHandler = mock(TaskHeartbeatHandler.class);
		when(appCtx.getEventHandler()).thenReturn(ea);
		CheckpointAMPreemptionPolicy policy = new CheckpointAMPreemptionPolicy();
		policy.init(appCtx);
		TaskAttemptListenerImpl listener = new MockTaskAttemptListenerImpl(
				appCtx, secret, rmHeartbeatHandler, policy) {
			@Override
			protected void registerHeartbeatHandler(Configuration conf) {
				taskHeartbeatHandler = hbHandler;
			}
		};

		Configuration conf = new Configuration();
		conf.setBoolean(MRJobConfig.TASK_PREEMPTION, true);
		//conf.setBoolean("preemption.reduce", true);

		listener.init(conf);
		listener.start();

		TaskAttemptID tid = new TaskAttemptID("12345", 1, TaskType.REDUCE, 1, 0);

		List<Path> partialOut = new ArrayList<Path>();
		partialOut.add(new Path("/prev1"));
		partialOut.add(new Path("/prev2"));
		*/
		Counters counters = null;//mock(Counters.class);
		/*
		final long CBYTES = 64L * 1024 * 1024;
		final long CTIME = 4344L;
		final Path CLOC = new Path("/test/1");
		*/
		Counter cbytes = null;//mock(Counter.class);
		//when(cbytes.getValue()).thenReturn(CBYTES);
		Counter ctime = null;//mock(Counter.class);
		//when(ctime.getValue()).thenReturn(CTIME);
		when(counters.findCounter(eq(EnumCounter.CHECKPOINT_BYTES)))
		.thenReturn(cbytes);
		when(counters.findCounter(eq(EnumCounter.CHECKPOINT_MS)))
		.thenReturn(ctime);
		/*
		// propagating a taskstatus that contains a checkpoint id
		TaskCheckpointID incid = new TaskCheckpointID(new FSCheckpointID(
				CLOC), partialOut, counters);
		listener.setCheckpointID(
				org.apache.hadoop.mapred.TaskID.downgrade(tid.getTaskID()), incid);

		// and try to get it back
		CheckpointID outcid = listener.getCheckpointID(tid.getTaskID());
		TaskCheckpointID tcid = (TaskCheckpointID) outcid;
		assertEquals(CBYTES, tcid.getCheckpointBytes());
		assertEquals(CTIME, tcid.getCheckpointTime());
		assertTrue(partialOut.containsAll(tcid.getPartialCommittedOutput()));
		assertTrue(tcid.getPartialCommittedOutput().containsAll(partialOut));

		//assert it worked
		assert outcid == incid;

		listener.stop();
		*/
	}
}

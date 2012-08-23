package testBinder.overloadingStaticGenericMethods;

import static org.mockito.Mockito.*;
import static testBinder.overloadingStaticGenericMethods.MockitoMaker.*;

public class TestToo {
	void testMock() {
		Task mapTask = make(stub(Task.class).returning(TaskType.MAP).
				from.getType());
	}
	
	static class Task {		
		public TaskType getType() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	enum TaskType {
		MAP		
	}
	
	public void testNumInputFiles() throws Exception {
		Configuration conf = spy(new Configuration());
		Job job = make(stub(Job.class).returning(conf).from.getConfiguration());
	}
}

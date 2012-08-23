package testBinder.unknownProblem;

import java.io.IOException;

public abstract class TaskInputOutputContext<KEYIN,VALUEIN,KEYOUT,VALUEOUT> {
	public void write(KEYOUT key, VALUEOUT value
    ) throws IOException, InterruptedException {
		
	}
}

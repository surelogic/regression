package testBinder.methodWithSameNameAsType;

public class Test {
	private final class CheckStartedThread extends Thread
	{
		//CheckStartedThread() {}
		
	    public void CheckStartedThread()    {}
	    
	    public void run()
	    {
	    	//...
	    }
	}
	
	protected void start() {
		(new CheckStartedThread()).start();
	}
}

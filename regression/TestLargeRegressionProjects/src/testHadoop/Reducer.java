package testHadoop;

public class Reducer<KEYIN,VALUEIN,KEYOUT,VALUEOUT> {

	  /**
	   * The <code>Context</code> passed on to the {@link Reducer} implementations.
	   */
	  public abstract class Context 
	    implements ReduceContext<KEYIN,VALUEIN,KEYOUT,VALUEOUT> {
		  
	  }

}

package testBinder;

import com.surelogic.Containable;
import com.surelogic.Unique;

@Containable(whenContainable={"A", "D"})
public class TestWhen<A, B, C> {

	@Unique("return") public TestWhen(){}

}

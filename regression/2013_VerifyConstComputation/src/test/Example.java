package test;

import com.surelogic.*;
import static test.Constants.*;

interface Constants {
	String RETURN_VALUE = "return";
	String RECEIVER = "this";
	String OBJECT =	"java.lang.Object";

	// For use in scoped promises
	String FOR_INSTANCE_FIELDS = " for !static * *";
	String FOR_CONSTRUCTORS = " for new(**)";

	String PROTECTS_ITSELF = "L is this protects Instance";
}

@Promise("@NonNull"+FOR_INSTANCE_FIELDS)
@Region(Example.CONTENTS)
public abstract class Example {
	static final String CONTENTS = "Contents";
	
	@InRegion(CONTENTS)
	Integer i;
	
	@UniqueInRegion(CONTENTS)
	Object o;
	
	Example() {
		m(0);
	}

	@Initialized(through=OBJECT, value=RECEIVER)
	protected abstract void m(int x);
}

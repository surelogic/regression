package rootIsThreadSafe.classes.rootIsNothing;

import com.surelogic.ThreadSafe;
import com.surelogic.Part;

public class C {}

class D extends C {} // GOOD

@ThreadSafe(appliesTo=Part.Instance)
class E extends C {} // BAD

@ThreadSafe(appliesTo=Part.Static)
class F extends C {} // GOOD

@ThreadSafe(appliesTo=Part.InstanceAndStatic)
class G extends C {} // BAD

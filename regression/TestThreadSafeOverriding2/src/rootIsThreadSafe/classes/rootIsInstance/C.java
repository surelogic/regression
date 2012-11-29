package rootIsThreadSafe.classes.rootIsInstance;

import com.surelogic.ThreadSafe;
import com.surelogic.Part;

@ThreadSafe(appliesTo=Part.Instance)
public class C {}

class D extends C {} // BAD

@ThreadSafe(appliesTo=Part.Instance)
class E extends C {} // GOOD

@ThreadSafe(appliesTo=Part.Static)
class F extends C {} // BAD

@ThreadSafe(appliesTo=Part.InstanceAndStatic)
class G extends C {} // GOOD

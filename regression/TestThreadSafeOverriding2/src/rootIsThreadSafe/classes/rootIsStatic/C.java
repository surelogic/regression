package rootIsThreadSafe.classes.rootIsStatic;

import com.surelogic.ThreadSafe;
import com.surelogic.Part;

@ThreadSafe(appliesTo=Part.Static)
public class C {}

class D extends C {} // GOOD

@ThreadSafe(appliesTo=Part.Instance)
class E extends C {} // BAD

@ThreadSafe(appliesTo=Part.Static)
class F extends C {} // GOOD

@ThreadSafe(appliesTo=Part.InstanceAndStatic)
class G extends C {} // BAD

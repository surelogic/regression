package rootIsThreadSafe.classes.rootIsInstance;

import com.surelogic.Immutable;
import com.surelogic.Part;
import com.surelogic.ThreadSafe;

@ThreadSafe(appliesTo=Part.Instance)
public class C {}

class D extends C {} // BAD

@Immutable(appliesTo=Part.Instance)
class E extends C {} // BAD

@Immutable(appliesTo=Part.Static)
class F extends C {} // BAD

@Immutable(appliesTo=Part.InstanceAndStatic)
class G extends C {} // BAD

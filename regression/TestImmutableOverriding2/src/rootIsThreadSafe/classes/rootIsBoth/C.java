package rootIsThreadSafe.classes.rootIsBoth;

import com.surelogic.Immutable;
import com.surelogic.Part;
import com.surelogic.ThreadSafe;

@ThreadSafe(appliesTo=Part.InstanceAndStatic)
public class C {}

class D extends C {} // Bad, not @immutable

@Immutable(appliesTo=Part.Instance)
class E extends C {} // BAD

@Immutable(appliesTo=Part.Static)
class F extends C {} // BAD

@Immutable(appliesTo=Part.InstanceAndStatic)
class G extends C {} // BAD

package rootIsThreadSafe.classes.rootIsBoth;

import com.surelogic.ThreadSafe;
import com.surelogic.Part;

@ThreadSafe(appliesTo=Part.InstanceAndStatic)
public class C {}

class D extends C {} // Bad, not @ThreadSafe

@ThreadSafe(appliesTo=Part.Instance)
class E extends C {} // Good

@ThreadSafe(appliesTo=Part.Static)
class F extends C {} // BAD

@ThreadSafe(appliesTo=Part.InstanceAndStatic)
class G extends C {} // GOOD

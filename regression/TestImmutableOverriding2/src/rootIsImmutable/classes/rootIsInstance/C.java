package rootIsImmutable.classes.rootIsInstance;

import com.surelogic.Immutable;
import com.surelogic.Part;

@Immutable(appliesTo=Part.Instance)
public class C {}

class D extends C {} // BAD

@Immutable(appliesTo=Part.Instance)
class E extends C {} // GOOD

@Immutable(appliesTo=Part.Static)
class F extends C {} // BAD

@Immutable(appliesTo=Part.InstanceAndStatic)
class G extends C {} // GOOD

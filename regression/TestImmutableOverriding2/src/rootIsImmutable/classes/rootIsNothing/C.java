package rootIsImmutable.classes.rootIsNothing;

import com.surelogic.Immutable;
import com.surelogic.Part;

public class C {}

class D extends C {} // GOOD

@Immutable(appliesTo=Part.Instance)
class E extends C {} // BAD

@Immutable(appliesTo=Part.Static)
class F extends C {} // GOOD

@Immutable(appliesTo=Part.InstanceAndStatic)
class G extends C {} // BAD

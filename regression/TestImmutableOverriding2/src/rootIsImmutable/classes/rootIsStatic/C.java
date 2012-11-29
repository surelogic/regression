package rootIsImmutable.classes.rootIsStatic;

import com.surelogic.Immutable;
import com.surelogic.Part;

@Immutable(appliesTo=Part.Static)
public class C {}

class D extends C {} // GOOD

@Immutable(appliesTo=Part.Instance)
class E extends C {} // BAD

@Immutable(appliesTo=Part.Static)
class F extends C {} // GOOD

@Immutable(appliesTo=Part.InstanceAndStatic)
class G extends C {} // BAD

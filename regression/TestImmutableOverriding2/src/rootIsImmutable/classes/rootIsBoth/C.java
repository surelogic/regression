package rootIsImmutable.classes.rootIsBoth;

import com.surelogic.Immutable;
import com.surelogic.Part;

@Immutable(appliesTo=Part.InstanceAndStatic)
public class C {}

class D extends C {} // Bad, not @immutable

@Immutable(appliesTo=Part.Instance)
class E extends C {} // Good

@Immutable(appliesTo=Part.Static)
class F extends C {} // BAD

@Immutable(appliesTo=Part.InstanceAndStatic)
class G extends C {} // GOOD

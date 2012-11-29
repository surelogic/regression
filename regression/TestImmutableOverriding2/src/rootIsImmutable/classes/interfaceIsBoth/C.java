package rootIsImmutable.classes.interfaceIsBoth;

import com.surelogic.Immutable;
import com.surelogic.Part;

@Immutable(appliesTo=Part.InstanceAndStatic)
public interface C {}

class D implements C {} // BAD

@Immutable(appliesTo=Part.Instance)
class E implements C {} // GOOD

@Immutable(appliesTo=Part.Static)
class F implements C {} // BAD

@Immutable(appliesTo=Part.InstanceAndStatic)
class G implements C {} // GOOD

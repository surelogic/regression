package rootIsImmutable.classes.interfaceIsNothing;

import com.surelogic.Immutable;
import com.surelogic.Part;

public interface C {}

class D implements C {} // GOOD

@Immutable(appliesTo=Part.Instance)
class E implements C {} // GOOD

@Immutable(appliesTo=Part.Static)
class F implements C {} // GOOD

@Immutable(appliesTo=Part.InstanceAndStatic)
class G implements C {} // GOOD

package rootIsThreadSafe.classes.interfaceIsStatic;

import com.surelogic.Immutable;
import com.surelogic.Part;
import com.surelogic.ThreadSafe;

@ThreadSafe(appliesTo=Part.Static)
public interface C {}

class D implements C {} // GOOD

@Immutable(appliesTo=Part.Instance)
class E implements C {} // GOOD

@Immutable(appliesTo=Part.Static)
class F implements C {} // GOOD

@Immutable(appliesTo=Part.InstanceAndStatic)
class G implements C {} // GOOD

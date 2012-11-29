package rootIsThreadSafe.classes.interfaceIsInstance;

import com.surelogic.ThreadSafe;
import com.surelogic.Part;

@ThreadSafe(appliesTo=Part.Instance)
public interface C {}

class D implements C {} // BAD

@ThreadSafe(appliesTo=Part.Instance)
class E implements C {} // GOOD

@ThreadSafe(appliesTo=Part.Static)
class F implements C {} // BAD

@ThreadSafe(appliesTo=Part.InstanceAndStatic)
class G implements C {} // GOOD

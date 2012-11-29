package rootIsThreadSafe.classes.interfaceIsStatic;

import com.surelogic.ThreadSafe;
import com.surelogic.Part;

@ThreadSafe(appliesTo=Part.Static)
public interface C {}

class D implements C {} // GOOD

@ThreadSafe(appliesTo=Part.Instance)
class E implements C {} // GOOD

@ThreadSafe(appliesTo=Part.Static)
class F implements C {} // GOOD

@ThreadSafe(appliesTo=Part.InstanceAndStatic)
class G implements C {} // GOOD

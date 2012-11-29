package rootIsThreadSafe.interfaces.rootIsStatic;

import com.surelogic.ThreadSafe;
import com.surelogic.Part;

@ThreadSafe(appliesTo=Part.Static)
public interface C {}

interface D extends C {} // GOOD

@ThreadSafe(appliesTo=Part.Instance)
interface E extends C {} // GOOD

@ThreadSafe(appliesTo=Part.Static)
interface F extends C {} // GOOD

@ThreadSafe(appliesTo=Part.InstanceAndStatic)
interface G extends C {} // GOOD

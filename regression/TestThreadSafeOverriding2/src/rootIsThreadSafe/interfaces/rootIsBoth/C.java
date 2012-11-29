package rootIsThreadSafe.interfaces.rootIsBoth;

import com.surelogic.ThreadSafe;
import com.surelogic.Part;

@ThreadSafe(appliesTo=Part.InstanceAndStatic)
public interface C {}

interface D extends C {} // BAD

@ThreadSafe(appliesTo=Part.Instance)
interface E extends C {} // GOOD

@ThreadSafe(appliesTo=Part.Static)
interface F extends C {} // BAD

@ThreadSafe(appliesTo=Part.InstanceAndStatic)
interface G extends C {} // GOOD

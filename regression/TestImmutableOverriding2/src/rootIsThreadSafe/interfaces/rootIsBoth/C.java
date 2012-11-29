package rootIsThreadSafe.interfaces.rootIsBoth;

import com.surelogic.Immutable;
import com.surelogic.Part;
import com.surelogic.ThreadSafe;

@ThreadSafe(appliesTo=Part.InstanceAndStatic)
public interface C {}

interface D extends C {} // BAD

@Immutable(appliesTo=Part.Instance)
interface E extends C {} // GOOD

@Immutable(appliesTo=Part.Static)
interface F extends C {} // BAD

@Immutable(appliesTo=Part.InstanceAndStatic)
interface G extends C {} // GOOD

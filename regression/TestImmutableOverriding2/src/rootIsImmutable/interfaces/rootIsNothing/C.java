package rootIsImmutable.interfaces.rootIsNothing;

import com.surelogic.Immutable;
import com.surelogic.Part;

public interface C {}

interface D extends C {} // GOOD

@Immutable(appliesTo=Part.Instance)
interface E extends C {} // GOOD

@Immutable(appliesTo=Part.Static)
interface F extends C {} // GOOD

@Immutable(appliesTo=Part.InstanceAndStatic)
interface G extends C {} // GOOD

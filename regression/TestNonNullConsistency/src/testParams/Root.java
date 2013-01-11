package testParams;

import com.surelogic.NonNull;
import com.surelogic.Nullable;
import com.surelogic.Raw;

public class Root {
  public void nullableArg(final @Nullable C p) {}
  
  public void nonNullArg(final @NonNull C p) {}
  
  public void rawStarArg(final @Raw C p) {}
  
  public void rawAArg(final @Raw(upTo="testParams.A") C p) {}
  
  public void rawBArg(final @Raw(upTo="testParams.B") C p) {}

  public void rawCArg(final @Raw(upTo="testParams.C") C p) {}

  public void rawDArg(final @Raw(upTo="testParams.D") D p) {}

  public void unannotatedArg(final C p) {}
}

class NullableArg extends Root {
  // Good
  @Override
  public void nullableArg(final @Nullable C p) {}
  
  // Good
  @Override
  public void nonNullArg(final @Nullable C p) {}
  
  // Bad
  @Override
  public void rawStarArg(final @Nullable C p) {}
  
  // Bad
  @Override
  public void rawAArg(final @Nullable C p) {}

  // Bad
  @Override
  public void rawBArg(final @Nullable C p) {}

  // Bad
  @Override
  public void rawCArg(final @Nullable C p) {}

  // Bad
  @Override
  public void rawDArg(final @Nullable D p) {}

  // Good
  @Override
  public void unannotatedArg(final @Nullable C p) {}
}

class NonNullArg extends Root {
  // Bad
  @Override
  public void nullableArg(final @NonNull C p) {}
  
  // Good
  @Override
  public void nonNullArg(final @NonNull C p) {}
  
  // Bad
  @Override
  public void rawStarArg(final @NonNull C p) {}
  
  // Bad
  @Override
  public void rawAArg(final @NonNull C p) {}

  // Bad
  @Override
  public void rawBArg(final @NonNull C p) {}

  // Bad
  @Override
  public void rawCArg(final @NonNull C p) {}

  // Bad
  @Override
  public void rawDArg(final @NonNull D p) {}

  // Bad
  @Override
  public void unannotatedArg(final @NonNull C p) {}
}

class RawStarArg extends Root {
  // Bad
  @Override
  public void nullableArg(final @Raw C p) {}
  
  // Good
  @Override
  public void nonNullArg(final @Raw C p) {}
  
  // Good
  @Override
  public void rawStarArg(final @Raw C p) {}
  
  // Good
  @Override
  public void rawAArg(final @Raw C p) {}

  // Good
  @Override
  public void rawBArg(final @Raw C p) {}

  // Good
  @Override
  public void rawCArg(final @Raw C p) {}

  // Good
  @Override
  public void rawDArg(final @Raw D p) {}

  // Good
  @Override
  public void unannotatedArg(final @Raw C p) {}
}

class RawAArg extends Root {
  // Bad
  @Override
  public void nullableArg(final @Raw(upTo="testParams.A") C p) {}
  
  // Good
  @Override
  public void nonNullArg(final @Raw(upTo="testParams.A") C p) {}
  
  // Bad
  @Override
  public void rawStarArg(final @Raw(upTo="testParams.A") C p) {}
  
  // Good
  @Override
  public void rawAArg(final @Raw(upTo="testParams.A") C p) {}

  // Good
  @Override
  public void rawBArg(final @Raw(upTo="testParams.A") C p) {}

  // Good
  @Override
  public void rawCArg(final @Raw(upTo="testParams.A") C p) {}

  // Good
  @Override
  public void rawDArg(final @Raw(upTo="testParams.A") D p) {}

  // Bad
  @Override
  public void unannotatedArg(final @Raw(upTo="testParams.A") C p) {}
}

class RawBArg extends Root {
  // Bad
  @Override
  public void nullableArg(final @Raw(upTo="testParams.C") C p) {}
  
  // Good
  @Override
  public void nonNullArg(final @Raw(upTo="testParams.C") C p) {}
  
  // Bad
  @Override
  public void rawStarArg(final @Raw(upTo="testParams.C") C p) {}
  
  // Bad
  @Override
  public void rawAArg(final @Raw(upTo="testParams.C") C p) {}

  // Good
  @Override
  public void rawBArg(final @Raw(upTo="testParams.C") C p) {}

  // Good
  @Override
  public void rawCArg(final @Raw(upTo="testParams.C") C p) {}

  // Good
  @Override
  public void rawDArg(final @Raw(upTo="testParams.C") D p) {}

  // Bad
  @Override
  public void unannotatedArg(final @Raw(upTo="testParams.C") C p) {}
}

class RawCArg extends Root {
  // Bad
  @Override
  public void nullableArg(final @Raw(upTo="testParams.C") C p) {}
  
  // Good
  @Override
  public void nonNullArg(final @Raw(upTo="testParams.C") C p) {}
  
  // Bad
  @Override
  public void rawStarArg(final @Raw(upTo="testParams.C") C p) {}
  
  // Bad
  @Override
  public void rawAArg(final @Raw(upTo="testParams.C") C p) {}

  // Bad
  @Override
  public void rawBArg(final @Raw(upTo="testParams.C") C p) {}

  // Good
  @Override
  public void rawCArg(final @Raw(upTo="testParams.C") C p) {}

  // Bad -- cannot eve name testParams.C
  @Override
  public void rawDArg(final @Raw(upTo="testParams.C") D p) {}

  // Bad
  @Override
  public void unannotatedArg(final @Raw(upTo="testParams.C") C p) {}
}

class RawDArg extends Root {
  // Bad -- cannot even name testParams.D here
  @Override
  public void nullableArg(final @Raw(upTo="testParams.D") C p) {}
  
  // Bad -- cannot even name testParams.D here
  @Override
  public void nonNullArg(final @Raw(upTo="testParams.D") C p) {}
  
  // Bad -- cannot even name testParams.D here
  @Override
  public void rawStarArg(final @Raw(upTo="testParams.D") C p) {}
  
  // Bad -- cannot even name testParams.D here
  @Override
  public void rawAArg(final @Raw(upTo="testParams.D") C p) {}

  // Bad -- cannot even name testParams.D here
  @Override
  public void rawBArg(final @Raw(upTo="testParams.D") C p) {}

  // Bad -- cannot even name testParams.D here
  @Override
  public void rawCArg(final @Raw(upTo="testParams.D") C p) {}

  // Good
  @Override
  public void rawDArg(final @Raw(upTo="testParams.D") D p) {}

  // Bad -- cannot even name testParams.D here
  @Override
  public void unannotatedArg(final @Raw(upTo="testParams.D") C p) {}
}

class Unannotated extends Root {
  // Good
  @Override
  public void nullableArg(final C p) {}
  
  // Good
  @Override
  public void nonNullArg(final C p) {}
  
  // Bad
  @Override
  public void rawStarArg(final C p) {}
  
  // Bad
  @Override
  public void rawAArg(final C p) {}

  // Bad
  @Override
  public void rawBArg(final C p) {}

  // Bad
  @Override
  public void rawCArg(final C p) {}

  // Bad
  @Override
  public void rawDArg(final D p) {}

  // Good
  @Override
  public void unannotatedArg(final C p) {}
}


class A {}
class B extends A {}
class C extends B {}
class D extends B {}

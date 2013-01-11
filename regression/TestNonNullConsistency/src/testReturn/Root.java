package testReturn;

import com.surelogic.NonNull;
import com.surelogic.Nullable;
import com.surelogic.Raw;

public class Root {
  @Nullable
  public Object nullableReturn() { return new Object(); }
  
  @NonNull
  public Object nonNullReturn() { return new Object(); }
  
  @Raw(value="return")
  public Object rawStarReturn() { return new Object(); }
  
  @Raw(upTo="testReturn.A", value="return")
  public A rawAReturn() { return new A(); }
  
  @Raw(upTo="testReturn.B", value="return")
  public B rawBReturn() { return new B(); }
  
  @Raw(upTo="testReturn.C", value="return")
  public C rawCReturn() { return new C(); }
  
  @Raw(upTo="testReturn.D", value="return")
  public D rawDReturn() { return new D(); }
  
  public Object unannotatedReturn() { return new Object(); }
}

class NullableReturn extends Root {
  // good
  @Override
  @Nullable
  public Object nullableReturn() { return new Object(); }
  
  // bad
  @Override
  @Nullable
  public Object nonNullReturn() { return new Object(); }
  
  // bad
  @Override
  @Nullable
  public Object rawStarReturn() { return new Object(); }
  
  // bad
  @Override
  @Nullable
  public A rawAReturn() { return new A(); }
  
  // bad
  @Override
  @Nullable
  public B rawBReturn() { return new B(); }
  
  // bad
  @Override
  @Nullable
  public C rawCReturn() { return new C(); }
  
  // bad
  @Override
  @Nullable
  public D rawDReturn() { return new D(); }
  
  // good
  @Override
  @Nullable
  public Object unannotatedReturn() { return new Object(); }
}

class NonNullReturn extends Root {
  // good
  @Override
  @NonNull
  public Object nullableReturn() { return new Object(); }
  
  // good
  @Override
  @NonNull
  public Object nonNullReturn() { return new Object(); }
  
  // good
  @Override
  @NonNull
  public Object rawStarReturn() { return new Object(); }

  // good
  @Override
  @NonNull
  public A rawAReturn() { return new A(); }
  
  // good
  @Override
  @NonNull
  public B rawBReturn() { return new B(); }
  
  // good
  @Override
  @NonNull
  public C rawCReturn() { return new C(); }

  // good
  @Override
  @NonNull
  public D rawDReturn() { return new D(); }

  // good
  @Override
  @NonNull
  public Object unannotatedReturn() { return new Object(); }
}

class RawStarReturn extends Root {
  // bad
  @Override
  @Raw(value="return")
  public Object nullableReturn() { return new Object(); }
  
  // bad
  @Override
  @Raw(value="return")
  public Object nonNullReturn() { return new Object(); }
  
  // good
  @Override
  @Raw(value="return")
  public Object rawStarReturn() { return new Object(); }
  
  // bad
  @Override
  @Raw(value="return")
  public A rawAReturn() { return new A(); }
  
  // bad
  @Override
  @Raw(value="return")
  public B rawBReturn() { return new B(); }
  
  // bad
  @Override
  @Raw(value="return")
  public C rawCReturn() { return new C(); }

  // bad
  @Override
  @Raw(value="return")
  public D rawDReturn() { return new D(); }

  // bad
  @Override
  @Raw(value="return")
  public Object unannotatedReturn() { return new Object(); }
}

class RawAReturn extends Root {
  // bad
  @Override
  @Raw(upTo="testReturn.A", value="return")
  public A nullableReturn() { return new A(); }
  
  // bad
  @Override
  @Raw(upTo="testReturn.A", value="return")
  public A nonNullReturn() { return new A(); }
  
  // good
  @Override
  @Raw(upTo="testReturn.A", value="return")
  public A rawStarReturn() { return new A(); }
  
  // good
  @Override
  @Raw(upTo="testReturn.A", value="return")
  public A rawAReturn() { return new A(); }
  
  // bad
  @Override
  @Raw(upTo="testReturn.A", value="return")
  public B rawBReturn() { return new B(); }
  
  // bad
  @Override
  @Raw(upTo="testReturn.A", value="return")
  public C rawCReturn() { return new C(); }

  // bad
  @Override
  @Raw(upTo="testReturn.A", value="return")
  public D rawDReturn() { return new D(); }

  // bad
  @Override
  @Raw(upTo="testReturn.A", value="return")
  public A unannotatedReturn() { return new A(); }
}

class RawBReturn extends Root {
  // bad
  @Override
  @Raw(upTo="testReturn.B", value="return")
  public B nullableReturn() { return new B(); }
  
  // bad
  @Override
  @Raw(upTo="testReturn.B", value="return")
  public B nonNullReturn() { return new B(); }
  
  // good
  @Override
  @Raw(upTo="testReturn.B", value="return")
  public B rawStarReturn() { return new B(); }
  
  // good
  @Override
  @Raw(upTo="testReturn.B", value="return")
  public B rawAReturn() { return new B(); }
  
  // good
  @Override
  @Raw(upTo="testReturn.B", value="return")
  public B rawBReturn() { return new B(); }
  
  // bad
  @Override
  @Raw(upTo="testReturn.B", value="return")
  public C rawCReturn() { return new C(); }

  // bad
  @Override
  @Raw(upTo="testReturn.B", value="return")
  public D rawDReturn() { return new D(); }

  // bad
  @Override
  @Raw(upTo="testReturn.B", value="return")
  public B unannotatedReturn() { return new B(); }
}

class RawCReturn extends Root {
  // bad
  @Override
  @Raw(upTo="testReturn.C", value="return")
  public C nullableReturn() { return new C(); }
  
  // bad
  @Override
  @Raw(upTo="testReturn.C", value="return")
  public C nonNullReturn() { return new C(); }
  
  // good
  @Override
  @Raw(upTo="testReturn.C", value="return")
  public C rawStarReturn() { return new C(); }
  
  // good
  @Override
  @Raw(upTo="testReturn.C", value="return")
  public C rawAReturn() { return new C(); }
  
  // good
  @Override
  @Raw(upTo="testReturn.C", value="return")
  public C rawBReturn() { return new C(); }
  
  // good
  @Override
  @Raw(upTo="testReturn.C", value="return")
  public C rawCReturn() { return new C(); }

  // bad -- cannot even use testReturn.C here.
  @Override
  @Raw(upTo="testReturn.C", value="return")
  public D rawDReturn() { return new D(); }

  // bad
  @Override
  @Raw(upTo="testReturn.C", value="return")
  public C unannotatedReturn() { return new C(); }
}

class RawDReturn extends Root {
  // bad
  @Override
  @Raw(upTo="testReturn.D", value="return")
  public D nullableReturn() { return new D(); }
  
  // bad
  @Override
  @Raw(upTo="testReturn.D", value="return")
  public D nonNullReturn() { return new D(); }
  
  // good
  @Override
  @Raw(upTo="testReturn.D", value="return")
  public D rawStarReturn() { return new D(); }
  
  // good
  @Override
  @Raw(upTo="testReturn.D", value="return")
  public D rawAReturn() { return new D(); }
  
  // good
  @Override
  @Raw(upTo="testReturn.D", value="return")
  public D rawBReturn() { return new D(); }
  
  // bad -- cannot even name testReturn.D here
  @Override
  @Raw(upTo="testReturn.D", value="return")
  public C rawCReturn() { return new C(); }

  // good
  @Override
  @Raw(upTo="testReturn.D", value="return")
  public D rawDReturn() { return new D(); }

  // bad
  @Override
  @Raw(upTo="testReturn.D", value="return")
  public D unannotatedReturn() { return new D(); }
}

class Unannotated extends Root {
  // good
  @Override
  public Object nullableReturn() { return new Object(); }
  
  // bad
  @Override
  public Object nonNullReturn() { return new Object(); }
  
  // bad
  @Override
  public Object rawStarReturn() { return new Object(); }
  
  // bad
  @Override
  public A rawAReturn() { return new A(); }
  
  // bad
  @Override
  public B rawBReturn() { return new B(); }
  
  // bad
  @Override
  public C rawCReturn() { return new C(); }

  // bad
  @Override
  public D rawDReturn() { return new D(); }

  // good
  @Override
  public Object unannotatedReturn() { return new Object(); }
}

class A {}
class B extends A {}
class C extends B {}
class D extends B {}

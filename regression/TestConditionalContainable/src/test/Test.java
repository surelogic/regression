package test;

import com.surelogic.AnnotationBounds;
import com.surelogic.Borrowed;
import com.surelogic.Containable;
import com.surelogic.ReferenceObject;
import com.surelogic.Unique;

@Containable
public class Test {
  @Borrowed("this")
  public Test() {
    super();
  }
  
  private @Unique C1 f1;
  private @Unique C2<String> f2_good;
  private @Unique C2<Thread> f2_bad;
  private @Unique C3<String> f3_good;
  private @Unique C3<Thread> f3_bad;
  private @Unique C4<String> f4_good;
  private @Unique C4<RefObj> f4_good2;
  private @Unique C4<Thread> f4_bad;
}

class Test2 {
  private @Unique C1 f1;
  private @Unique C2<String> f2_good;
  private @Unique C2<Thread> f2_bad;
  private @Unique C3<String> f3_good;
  private @Unique C3<Thread> f3_bad;
  private @Unique C4<String> f4_good;
  private @Unique C4<RefObj> f4_good2;
  private @Unique C4<Thread> f4_bad;
}


@Containable
class C1 {
  @Borrowed("this")
  public C1() {
    super();
  }
}

@AnnotationBounds(immutable="T")
@Containable
class C2<T> {
  @Borrowed("this")
  public C2() {
    super();
  }
}

@Containable
// T is implicitly thread safe
class C3<T> {
  @Borrowed("this")
  public C3() {
    super();
  }
  
  private Other<T> testField = null; // Other<T> should be okay; the field is not containble though
}

@Containable(allowReferenceObject=true)
// T is implicitly thread safe || reference object
class C4<T> {
  @Borrowed("this")
  public C4() {
    super();
  }
  
  private Other2<T> testField2 = null; // Other2<T> should be okay; the field is not containble though
}

@AnnotationBounds(threadSafe="X")
class Other<X> {}

@AnnotationBounds(threadSafe="X", referenceObject="X")
class Other2<X> {}

@ReferenceObject
class RefObj {}

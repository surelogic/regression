package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;
import com.surelogic.Raw;

public class TestInstanceMethod {
  public void s(int x, B p1, @Nullable B p2, @NonNull B p3) {
    // do nothing
  }
  
  private static B getB_unannotated() { return new B(); }
  private static @Nullable B getB_nullable() { return new B(); }
  private static @NonNull B getB_nonNull() { return new B(); }
  private static @Raw("return") B getB_rawStar() { return new B(); }
  
  private static C getC_unannotated() { return new C(); }
  private static @Nullable C getC_nullable() { return new C(); }
  private static @NonNull C getC_nonNull() { return new C(); }
  private static @Raw("return") C getC_rawStar() { return new C(); }
  
  private static D getD_unannotated() { return new D(); }
  private static @Nullable D getD_nullable() { return new D(); }
  private static @NonNull D getD_nonNull() { return new D(); }
  private static @Raw("return") D getD_rawStar() { return new D(); }
  
  private static @Raw(value="return", upTo="A") D getDupToA() { return new D(); }
  private static @Raw(value="return", upTo="B") D getDupToB() { return new D(); }
  private static @Raw(value="return", upTo="C") D getDupToC() { return new D(); }
  
  private static @Raw(value="return", upTo="A") E getEupToA() { return new E(); }
  private static @Raw(value="return", upTo="B") E getEupToB() { return new E(); }
  private static @Raw(value="return", upTo="C") E getEupToC() { return new E(); }
  private static @Raw(value="return", upTo="D") E getEupToD() { return new E(); }
  

  
  public void testImplicitReceiver() {
    s(0, getB_unannotated(), getB_unannotated(), getB_unannotated());    // good, good, bad
    s(0, getB_nullable(), getB_nullable(), getB_nullable()); // good, good, bad
    s(0, getB_nonNull(), getB_nonNull(), getB_nonNull()); // good, good, good

    s(0, getC_unannotated(), getC_unannotated(), getC_unannotated());    // good, good, bad
    s(0, getC_nullable(), getC_nullable(), getC_nullable()); // good, good, bad
    s(0, getC_nonNull(), getC_nonNull(), getC_nonNull()); // good, good, good

    s(0, getD_unannotated(), getD_unannotated(), getD_unannotated());    // good, good, bad
    s(0, getD_nullable(), getD_nullable(), getD_nullable()); // good, good, bad
    s(0, getD_nonNull(), getD_nonNull(), getD_nonNull()); // good, good, good
  }
  
  public void testExplicitReceiver() {
    this.s(0, getB_unannotated(), getB_unannotated(), getB_unannotated());    // good, good, bad
    this.s(0, getB_nullable(), getB_nullable(), getB_nullable()); // good, good, bad
    this.s(0, getB_nonNull(), getB_nonNull(), getB_nonNull()); // good, good, good

    this.s(0, getC_unannotated(), getC_unannotated(), getC_unannotated());    // good, good, bad
    this.s(0, getC_nullable(), getC_nullable(), getC_nullable()); // good, good, bad
    this.s(0, getC_nonNull(), getC_nonNull(), getC_nonNull()); // good, good, good

    this.s(0, getD_unannotated(), getD_unannotated(), getD_unannotated());    // good, good, bad
    this.s(0, getD_nullable(), getD_nullable(), getD_nullable()); // good, good, bad
    this.s(0, getD_nonNull(), getD_nonNull(), getD_nonNull()); // good, good, good
  }
  
  @SuppressWarnings("null")
  public void testReceivers() {
    getB_unannotated().notAnnotated(); // good
    getB_unannotated().rawStar(); // bad
    getB_nullable().notAnnotated(); // good
    getB_nullable().rawStar(); // bad
    getB_nonNull().notAnnotated(); // good
    getB_nonNull().rawStar(); // good
    getB_rawStar().notAnnotated(); // bad
    getB_rawStar().rawStar(); // good
    getEupToC().notAnnotated(); // bad
    
    getC_unannotated().notAnnotated(); // good
    getC_unannotated().rawStar(); // bad
    getC_nullable().notAnnotated(); // good
    getC_nullable().rawStar(); // bad
    getC_nonNull().notAnnotated(); // good
    getC_nonNull().rawStar(); // good
    getC_rawStar().notAnnotated(); // bad
    getC_rawStar().rawStar(); // good

    getD_unannotated().notAnnotated(); // good
    getD_unannotated().rawStar(); // bad
    getD_nullable().notAnnotated(); // good
    getD_nullable().rawStar(); // bad
    getD_nonNull().notAnnotated(); // good
    getD_nonNull().rawStar(); // good
    getD_rawStar().notAnnotated(); // bad
    getD_rawStar().rawStar(); // good
   
    getD_unannotated().rawA(); // bad
    getD_nullable().rawA(); // bad
    getD_nonNull().rawA(); // good
    getD_rawStar().rawA(); // bad
    getDupToA().rawA(); // good
    getDupToB().rawA(); // good
    getDupToC().rawA(); // good
    getEupToA().rawA(); // good
    getEupToB().rawA(); // good
    getEupToC().rawA(); // good
    getEupToD().rawA(); // good
    
    getD_unannotated().rawB(); // bad
    getD_nullable().rawB(); // bad
    getD_nonNull().rawB(); // good
    getD_rawStar().rawB(); // bad
    getDupToA().rawB(); // bad
    getDupToB().rawB(); // good
    getDupToC().rawB(); // good
    getEupToA().rawB(); // bad
    getEupToB().rawB(); // good
    getEupToC().rawB(); // good
    getEupToD().rawB(); // good
    
    getD_unannotated().rawC(); // bad
    getD_nullable().rawC(); // bad
    getD_nonNull().rawC(); // good
    getD_rawStar().rawC(); // bad
    getDupToA().rawC(); // bad
    getDupToB().rawC(); // bad
    getDupToC().rawC(); // good
    getEupToA().rawC(); // bad
    getEupToB().rawC(); // bad
    getEupToC().rawC(); // good
    getEupToD().rawC(); // good

    // Test this last because otherwise the exception poisons the rest of
    // the results with IMPOSSIBLE
    final B nullB = null;
    nullB.notAnnotated(); // bad
  }
}

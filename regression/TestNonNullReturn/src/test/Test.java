package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;
import com.surelogic.Raw;

public class Test {
  // Nullable
  public B maybeNullImplied(int x,
      B b, C c,
      @Raw B rawB, @Raw C rawC,
      @Raw(upTo="A") B rawB2, @Raw(upTo="C") D rawD2) {
    D nullD = null;
    switch (x) {
    case 0:
      return b; // good: @Nullable B
    case 1:
      return c; // good: @Nullable C
    case 2:
      return new B(); // good: @NonNull B
    case 3:
      return new C(); // good: @NonNull C
    case 4:
      return rawB; // bad: @Raw B
    case 5:
      return rawC; // bad: @Raw C
    case 6:
      return rawB2; // bad: @Raw(A) B
    case 7:
      return rawD2; // bad: @Raw(C) D
    default:
      return nullD; // good: null
    }
  }

  @Nullable
  public B maybeNull(int x,
      B b, C c,
      @Raw B rawB, @Raw C rawC,
      @Raw(upTo="A") B rawB2, @Raw(upTo="C") D rawD2) {
    switch(x) {
    case 0: 
      return b; // good: @Nullable B
    case 1:
      return c; // good: @Nullable C
    case 2:
      return new B(); // good: @NonNull B
    case 3:
      return new C(); // good: @NonNull C
    case 4: 
      return rawB; // bad: @Raw B
    case 5:
      return rawC; // bad: @Raw C
    case 6:
      return rawB2; // bad: @Raw(A) B
    case 7:
      return rawD2; // bad: @Raw(C) D
    default:
      return null; // good: null
    }
  }
  
  @NonNull
  public B nonNull(int x,
      B b, C c,
      @Raw B rawB, @Raw C rawC,
      @Raw(upTo="A") B rawB2, @Raw(upTo="C") D rawD2) {
    switch(x) {
    case 0: 
      return b; // bad: @Nullable B
    case 1:
      return c; // bad: @Nullable C
    case 2:
      return new B(); // good: @NonNull B
    case 3:
      return new C(); // good: @NonNull C
    case 4: 
      return rawB; // bad: @Raw B
    case 5:
      return rawC; // bad: @Raw C
    case 6:
      return rawB2; // bad: @Raw(A) B
    case 7:
      return rawD2; // bad: @Raw(C) D
    default:
      return null; // bad: NULL!
    }
  }
  
  @Raw("return")
  public B rawStar(int x,
      B b, C c,
      @Raw B rawB, @Raw C rawC,
      @Raw(upTo="A") B rawB2, @Raw(upTo="C") D rawD2) {
    switch(x) {
    case 0: 
      return b; // bad: @Nullable B
    case 1:
      return c; // bad: @Nullable C
    case 2:
      return new B(); // good: @NonNull B
    case 3:
      return new C(); // good: @NonNull C
    case 4: 
      return rawB; // good: @Raw B
    case 5:
      return rawC; // good: @Raw C
    case 6:
      return rawB2; // good: @Raw(A) B
    case 7:
      return rawD2; // good: @Raw(C) D
    default:
      return null; // bad: NULL!
    }
  }
  
  @Raw(upTo="B", value="return")
  public C rawB(int x,
      C c, D d,
      @Raw C rawC, @Raw D rawD,
      @Raw(upTo="A") C rawA_C, @Raw(upTo="B") C rawB_C,
      @Raw(upTo="A") D rawA_D, @Raw(upTo="B") D rawB_D, @Raw(upTo="C") D rawC_D) {
    switch(x) {
    case 0: 
      return c; // bad: @Nullable C
    case 1:
      return d; // bad: @Nullable D
    case 2:
      return new C(); // good: @NonNull C
    case 3:
      return new D(); // good: @NonNull D
    case 4: 
      return rawC; // bad: @Raw C
    case 5:
      return rawD; // bad: @Raw D
    case 6:
      return rawA_C; // bad: @Raw(A) C
    case 7:
      return rawB_C; // good: @Raw(B) C
    case 8:
      return rawA_D; // bad: @Raw(A) D
    case 9:
      return rawB_D; // good: @Raw(B) D
    case 10:
      return rawC_D; // good: @Raw(C) D
    default:
      return null; // bad: NULL!
    }
  }
}


package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;
import com.surelogic.Initialized;

public class Test {
  // Nullable
  public B maybeNullImplied(int x,
      B b, C c,
      @Initialized(through="*") B rawB, @Initialized(through="*") C rawC,
      @Initialized(through="A") B rawB2, @Initialized(through="C") D rawD2) {
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
      return rawB; // bad: @Initialized(through="*") B
    case 5:
      return rawC; // bad: @Initialized(through="*") C
    case 6:
      return rawB2; // bad: @Initialized(A) B
    case 7:
      return rawD2; // bad: @Initialized(C) D
    default:
      return nullD; // good: null
    }
  }

  @Nullable
  public B maybeNull(int x,
      B b, C c,
      @Initialized(through="*") B rawB, @Initialized(through="*") C rawC,
      @Initialized(through="A") B rawB2, @Initialized(through="C") D rawD2) {
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
      return rawB; // bad: @Initialized(through="*") B
    case 5:
      return rawC; // bad: @Initialized(through="*") C
    case 6:
      return rawB2; // bad: @Initialized(A) B
    case 7:
      return rawD2; // bad: @Initialized(C) D
    default:
      return null; // good: null
    }
  }
  
  @NonNull
  public B nonNull(int x,
      B b, C c,
      @Initialized(through="*") B rawB, @Initialized(through="*") C rawC,
      @Initialized(through="A") B rawB2, @Initialized(through="C") D rawD2) {
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
      return rawB; // bad: @Initialized(through="*") B
    case 5:
      return rawC; // bad: @Initialized(through="*") C
    case 6:
      return rawB2; // bad: @Initialized(A) B
    case 7:
      return rawD2; // bad: @Initialized(C) D
    default:
      return null; // bad: NULL!
    }
  }
  
  @Initialized(through="*", value=" return")
  public B rawStar(int x,
      B b, C c,
      @Initialized(through="*") B rawB, @Initialized(through="*") C rawC,
      @Initialized(through="A") B rawB2, @Initialized(through="C") D rawD2) {
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
      return rawB; // good: @Initialized(through="*") B
    case 5:
      return rawC; // good: @Initialized(through="*") C
    case 6:
      return rawB2; // good: @Initialized(A) B
    case 7:
      return rawD2; // good: @Initialized(C) D
    default:
      return null; // bad: NULL!
    }
  }
  
  @Initialized(through="B", value="return")
  public C rawB(int x,
      C c, D d,
      @Initialized(through="*") C rawC, @Initialized(through="*") D rawD,
      @Initialized(through="A") C rawA_C, @Initialized(through="B") C rawB_C,
      @Initialized(through="A") D rawA_D, @Initialized(through="B") D rawB_D, @Initialized(through="C") D rawC_D) {
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
      return rawC; // bad: @Initialized(through="*") C
    case 5:
      return rawD; // bad: @Initialized(through="*") D
    case 6:
      return rawA_C; // bad: @Initialized(A) C
    case 7:
      return rawB_C; // good: @Initialized(B) C
    case 8:
      return rawA_D; // bad: @Initialized(A) D
    case 9:
      return rawB_D; // good: @Initialized(B) D
    case 10:
      return rawC_D; // good: @Initialized(C) D
    default:
      return null; // bad: NULL!
    }
  }
}


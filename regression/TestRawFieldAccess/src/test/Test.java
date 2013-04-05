package test;

import com.surelogic.NonNull;
import com.surelogic.Raw;

public class Test {
  @SuppressWarnings("unused")
  public void testRawStar1(@Raw D p) {
    Object nn1 = p.notNull1; // MAYBE_NULL
    Object nn2 = p.notNull2; // MAYBE_NULL
    Object nn3 = p.notNull3; // MAYBE_NULL
    Object nn4 = p.notNull4; // MAYBE_NULL
  }
  
  @SuppressWarnings("unused")
  public void testRawStar2(@Raw D p) {
    Object mb1 = p.mayBeNull1; // MAYBE_NULL
    Object mb2 = p.mayBeNull2; // MAYBE_NULL
    Object mb3 = p.mayBeNull3; // MAYBE_NULL
    Object mb4 = p.mayBeNull4; // MAYBE_NULL
  }
      
  @SuppressWarnings("unused")
  public void testRawObject1(@Raw(upTo="java.lang.Object") D p) {
    Object nn1 = p.notNull1; // MAYBE_NULL
    Object nn2 = p.notNull2; // MAYBE_NULL
    Object nn3 = p.notNull3; // MAYBE_NULL
    Object nn4 = p.notNull4; // MAYBE_NULL
  }
  
  @SuppressWarnings("unused")
  public void testRawObject2(@Raw(upTo="java.lang.Object") D p) {
    Object mb1 = p.mayBeNull1; // MAYBE_NULL
    Object mb2 = p.mayBeNull2; // MAYBE_NULL
    Object mb3 = p.mayBeNull3; // MAYBE_NULL
    Object mb4 = p.mayBeNull4; // MAYBE_NULL
  }
      
  @SuppressWarnings("unused")
  public void testRawA1(@Raw(upTo="A") D p) {
    Object nn1 = p.notNull1; // NOT_NULL
    Object nn2 = p.notNull2; // MAYBE_NULL
    Object nn3 = p.notNull3; // MAYBE_NULL
    Object nn4 = p.notNull4; // MAYBE_NULL
  }    
  
  @SuppressWarnings("unused")
  public void testRawA2(@Raw(upTo="A") D p) {
    Object mb1 = p.mayBeNull1; // MAYBE_NULL
    Object mb2 = p.mayBeNull2; // MAYBE_NULL
    Object mb3 = p.mayBeNull3; // MAYBE_NULL
    Object mb4 = p.mayBeNull4; // MAYBE_NULL
  }
      
  @SuppressWarnings("unused")
  public void testRawB1(@Raw(upTo="B") D p) {
    Object nn1 = p.notNull1; // NOT_NULL
    Object nn2 = p.notNull2; // NOT_NULL
    Object nn3 = p.notNull3; // MAYBE_NULL
    Object nn4 = p.notNull4; // MAYBE_NULL
  }

  @SuppressWarnings("unused")
  public void testRawB2(@Raw(upTo="B") D p) {
    Object mb1 = p.mayBeNull1; // MAYBE_NULL
    Object mb2 = p.mayBeNull2; // MAYBE_NULL
    Object mb3 = p.mayBeNull3; // MAYBE_NULL
    Object mb4 = p.mayBeNull4; // MAYBE_NULL
  }
      
  @SuppressWarnings("unused")
  public void testRawC1(@Raw(upTo="C") D p) {
    Object nn1 = p.notNull1; // NOT_NULL
    Object nn2 = p.notNull2; // NOT_NULL
    Object nn3 = p.notNull3; // NOT_NULL
    Object nn4 = p.notNull4; // MAYBE_NULL
  }
  
  @SuppressWarnings("unused")
  public void testRawC2(@Raw(upTo="C") D p) {
    Object mb1 = p.mayBeNull1; // MAYBE_NULL
    Object mb2 = p.mayBeNull2; // MAYBE_NULL
    Object mb3 = p.mayBeNull3; // MAYBE_NULL
    Object mb4 = p.mayBeNull4; // MAYBE_NULL
  }
      
  @SuppressWarnings("unused")
  public void testRawD1(@Raw(upTo="D") D p) {
    Object nn1 = p.notNull1; // NOT_NULL
    Object nn2 = p.notNull2; // NOT_NULL
    Object nn3 = p.notNull3; // NOT_NULL
    Object nn4 = p.notNull4; // NOT_NULL
  }
  
  @SuppressWarnings("unused")
  public void testRawD2(@Raw(upTo="D") D p) {
    Object mb1 = p.mayBeNull1; // MAYBE_NULL
    Object mb2 = p.mayBeNull2; // MAYBE_NULL
    Object mb3 = p.mayBeNull3; // MAYBE_NULL
    Object mb4 = p.mayBeNull4; // MAYBE_NULL
  }
      
  @SuppressWarnings("unused")
  public void testNonNull1(@NonNull D p) {
    Object nn1 = p.notNull1; // NOT_NULL
    Object nn2 = p.notNull2; // NOT_NULL
    Object nn3 = p.notNull3; // NOT_NULL
    Object nn4 = p.notNull4; // NOT_NULL
  }
  
  @SuppressWarnings("unused")
  public void testNonNull2(@NonNull D p) {
    Object mb1 = p.mayBeNull1; // MAYBE_NULL
    Object mb2 = p.mayBeNull2; // MAYBE_NULL
    Object mb3 = p.mayBeNull3; // MAYBE_NULL
    Object mb4 = p.mayBeNull4; // MAYBE_NULL
  }
      
  @SuppressWarnings("unused")
  public void testMaybeNull1(D p) {
    Object nn1 = p.notNull1; // NOT_NULL
    Object nn2 = p.notNull2; // NOT_NULL
    Object nn3 = p.notNull3; // NOT_NULL
    Object nn4 = p.notNull4; // NOT_NULL
  }
  
  @SuppressWarnings("unused")
  public void testMaybeNull2(D p) {
    Object mb1 = p.mayBeNull1; // MAYBE_NULL
    Object mb2 = p.mayBeNull2; // MAYBE_NULL
    Object mb3 = p.mayBeNull3; // MAYBE_NULL
    Object mb4 = p.mayBeNull4; // MAYBE_NULL
  }
}

class A {
  public Object mayBeNull1;
  public @NonNull Object notNull1;
}

class B extends A {
  public Object mayBeNull2;
  public @NonNull Object notNull2;
}

class C extends B {
  public Object mayBeNull3;
  public @NonNull Object notNull3;
}

class D extends C {
  public Object mayBeNull4;
  public @NonNull Object notNull4;
}
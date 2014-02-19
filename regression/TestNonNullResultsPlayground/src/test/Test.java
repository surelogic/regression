package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;
import com.surelogic.Initialized;

public class Test {
  private C unannotatedF;
  private @Nullable C nullableF;
  private @NonNull C nonNullF = new C();
  
  private static C unannotatedM() { return null; }
  private @Nullable C nullableM() { return null; }
  private @NonNull C nonNullM() { return new C(); }
  private @Initialized(through="Object", value=" return") C rawM() { return new C(); }
  
  public void m1(
      final int v,
      final C unannotatedP,
      final @Nullable C nullableP,
      final @NonNull C nonNullP,
      final @Initialized(through="Object") C rawP) {
    @SuppressWarnings("unused")
    int x = 
        (v == 0 ? unannotatedP :
          (v == 1 ? nullableP :
            (v == 2 ? nonNullP :
              (v == 3 ? rawP :
                (v == 4 ? this.unannotatedF :
                  (v == 5 ? this.nullableF :
                    (v == 6 ? this.nonNullF :
                      (v == 7 ? unannotatedM() :
                        (v == 8 ? nullableM() :
                          (v == 9 ? nonNullM() :
                            rawM())))))))))).f;
  }
  
  public void m2(
      final int v,
      final C unannotatedP,
      final @Nullable C nullableP,
      final @NonNull C nonNullP,
      final @Initialized(through="Object") C rawP) {
    C v1 = unannotatedP;
    C v2 = nullableP;
    C v3 = nonNullP;
    C v4 = rawP;
    C v5 = this.unannotatedF;
    C v90 = v == 8 ? nullableM() :
      (v == 9 ? nonNullM() :
        rawM());
    C v100 = v == 5 ? this.nullableF :
      (v == 6 ? this.nonNullF :
        (v == 7 ? unannotatedM() :
          v90));
    final C c =
        v == 0 ? v1 :
          (v == 1 ? v2 :
            (v == 2 ? v3 :
              (v == 3 ? v4 :
                (v == 4 ? v5 :
                  v100))));
    callme(c); // bad
  }
  
  public void m3(
      final int v,
      final C unannotatedP,
      final @Nullable C nullableP,
      final @NonNull C nonNullP,
      final @Initialized(through="Object") C rawP) {
    callme(
        v == 0 ? unannotatedP :
          (v == 1 ? nullableP :
            (v == 2 ? nonNullP :
              (v == 3 ? rawP :
                (v == 4 ? this.unannotatedF :
                  (v == 5 ? this.nullableF :
                    (v == 6 ? this.nonNullF :
                      (v == 7 ? unannotatedM() :
                        (v == 8 ? nullableM() :
                          (v == 9 ? nonNullM() :
                            rawM()))))))))));
  }
  
  public void moreCalls(final C unannotatedP) {
    callme(new C()); // good
    int xxx = unannotatedP.h;
    callme(unannotatedP); // good, because 'unannotatedP' is now non null due to dereference on previous line
  }

  public static void callme(final @NonNull C param) {
    // do stuff
  }
  
  public void testUnbox(boolean f,
      final Integer unannotated,
      final @Nullable Integer nullable, final @Nullable Integer nullable2,
      final @NonNull Integer nonNull,
      final @Initialized(through="Object") Integer raw) {
    int a = unannotated;
    int c = nonNull;
    int d = raw;
    
    Integer i = f ? nullable : nullable2;
    int e = i;
  }
}

class A {
  public int f;
}

class B extends A {
  public int g;
}

class C extends B {
  public int h;
  
  public void doStuff(final @NonNull Object other) {
    // do stuff
  }
  
  public void testNonNullReceiver() {
    doStuff(this);
    doStuff(this + "B");
  }
  
  @Initialized(through="Object", value=" this")
  public void testRawReceiver() {
    doStuff(this);
  }
}
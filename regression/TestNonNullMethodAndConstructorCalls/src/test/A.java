package test;

import com.surelogic.Initialized;

class A {}

class B extends A {
  public void notAnnotated() {}
  public @Initialized(through="*", value=" this") void rawStar() {}
}

class C extends B {
}

class D extends C {
  public @Initialized(value="this", through="A") void rawA() {}
  public @Initialized(value="this", through="B") void rawB() {}
  public @Initialized(value="this", through="C") void rawC() {}
}

class E extends D {}
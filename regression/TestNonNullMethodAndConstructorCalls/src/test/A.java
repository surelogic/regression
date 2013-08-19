package test;

import com.surelogic.Raw;

class A {}

class B extends A {
  public void notAnnotated() {}
  public @Raw("this") void rawStar() {}
}

class C extends B {
}

class D extends C {
  public @Raw(value="this", upTo="A") void rawA() {}
  public @Raw(value="this", upTo="B") void rawB() {}
  public @Raw(value="this", upTo="C") void rawC() {}
}

class E extends D {}
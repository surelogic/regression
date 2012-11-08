package test;

public class Test2 {
  protected P<
  V,
  I> g1; // bad
  protected P<
  V,
  I> g2; // bad
  protected P<
  I,
  V> g3; // good
}

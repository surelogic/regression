package test;

public class Test1 {
  protected P<
  I,
  V> f1; // good
  protected P<
  I,
  V> f2; // good
  protected P<
  V,
  I> f3; // bad
}

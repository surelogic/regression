package test;

public class Test<X extends C<?, int[], ?>> extends C<X, Float, Float> {
  public void doStuff(final C<Integer, Object, String> p) {
    new C<String, String, Integer>();
  }
}

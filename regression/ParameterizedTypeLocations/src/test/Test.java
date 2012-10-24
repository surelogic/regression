package test;

import com.surelogic.AnnotationBounds;

public class Test {
  private Other<String> f = new Other<String>();
  
  public Other<Long> method(final Other<Float> p) {
    final Other<Byte> lv = (Other<Byte>) null;
    new Other<Double>() {};
    return null;
  }
  
  private Other<Other<Integer>> f2;
}

@AnnotationBounds(threadSafe="T")
class Other<T> {}
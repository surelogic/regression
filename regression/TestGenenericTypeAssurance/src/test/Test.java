package test;

import com.surelogic.AnnotationBounds;

@AnnotationBounds(immutable="D")
public class Test<C, D> {
  private Foo<String> list1; // Foo<String> is good, and should have 4 occurrences
  private Foo<String> list2;
  private Foo<String> list3;
  
  private Foo<Foo<String>> f1; // Foo<Foo<String>> is good and should have 1 occurrence
  
  private Foo<C> b1; // Foo<C> is bad and should have 3 occurrences
  private Foo<C> b2;
  private Foo<C> b3;
  
  private Foo<D> b10; // Foo<D> is good and should have 3 occurrences
  private Foo<D> b20;
  private Foo<D> b30;
}

@AnnotationBounds(immutable="C")
class Test2<C> {
  private Foo<C> b1; // Foo<C> (distinct from the one above) is good, and should have 3 occurrences
  private Foo<C> b2;
  private Foo<C> b3;
}

@AnnotationBounds(immutable="T")
class Foo<T> {
  
}
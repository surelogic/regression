package test;

import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;

import com.surelogic.AnnotationBounds;

public class Test {
  private Hashtable<String, Object> ht = new Hashtable<String, Object>();
  private Stack<Integer> stack;
  private Vector<Vector<String>> vv;
  private X<Object> f;
}

@AnnotationBounds(containable="C")
class X<C> {}
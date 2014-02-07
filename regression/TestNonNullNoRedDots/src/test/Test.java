package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;
import com.surelogic.Raw;

public class Test {
  @Nullable
  private Object f;
  
  @NonNull
  private Object nn; // error
  
  
  
  @Nullable
  public Object uncalled1(@Nullable Object a, @NonNull Object b, @Raw Object c) {
    throw new RuntimeException();
  }
  
  @NonNull
  public Object uncalled2(@Nullable Object a, @NonNull Object b, @Raw Object c) {
    throw new RuntimeException();
  }
  
  @Raw(value="return")
  public Object uncalled3(@Nullable Object a, @NonNull Object b, @Raw Object c) {
    throw new RuntimeException();
  }
  
  
  @Raw(upTo="java.lang.Object", value="this")
  public void uncalled4() {
    // empty
  }
  
  
  
  @NonNull
  public Object called(@NonNull Object x, @Nullable Object y, @Raw Object z, boolean f) {
    if (f) return x; else return new Object();
  }
  
  public void callIt() {
    Object o = called(new int[10], null, new Object(), true);
  }
}
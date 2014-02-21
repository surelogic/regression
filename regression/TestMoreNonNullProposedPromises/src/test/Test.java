package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;

public class Test {
  private @NonNull Object field1 = new Object();
  private @NonNull Object field2 = new Object();
  private @NonNull Object field3 = new Object();
  
  private Object field11;
  private Object field12;
  private Object field13;
  
  private void method1(@NonNull Object x) {}
  
  private void method2(Object y) {}
  
  
  
  public void test1(
      Object a1, @Nullable Object b1, @NonNull Object c1,
      Object a2, @Nullable Object b2, @NonNull Object c2,
      Object a3, @Nullable Object b3, @NonNull Object c3,
      Object a4, @Nullable Object b4, @NonNull Object c4) {
    // Assignment to @NonNull field
    field1 = a1; // Error, Propose that a1 be @NonNull
    field2 = b1; // Error, no proposal because b1 is annotated @Nullable
    field3 = c1; // Good because c1 is @NonNull
    
    // Assignment to nullable field
    field11 = a2; 
    field12 = b2;
    field13 = c2;
    
    // Assignment to @NonNull formal
    method1(a3); // Error, Propose that a3 be @NonNull
    method1(b3); // Error, no proposal because b3 is annotated @Nullable
    method1(c3); // Good because c3 is @NonNull
    
    // Assignment to nullable formal
    method2(a4);
    method2(b4);
    method2(c4);
  }
}

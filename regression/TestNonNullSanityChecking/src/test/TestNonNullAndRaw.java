package test;

import com.surelogic.NonNull;
import com.surelogic.Raw;

public class TestNonNullAndRaw {
  // Raw may not be used on fields
 
  
  
  @SuppressWarnings("unused")
  private void testParams(
      @NonNull Object nonNull,
      @Raw Object raw,
      @NonNull @Raw Object both) {
    // foo
  }
  
  @SuppressWarnings("unused")
  private void testLocals() {
    @NonNull Object nonNull;
    @Raw Object raw;
    @NonNull @Raw Object both;
    
    // foo
  }
  
  // 
  
  @NonNull
  private Object returnNonNull() {
    return "String";
  }
  
  @Raw("return")
  private Object returnRaw() {
    return "String";
  }
  
  @NonNull
  @Raw("return")
  private Object returnBoth() {
    return "String";
  }
}

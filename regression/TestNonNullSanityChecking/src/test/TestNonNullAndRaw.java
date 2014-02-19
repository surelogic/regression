package test;

import com.surelogic.NonNull;
import com.surelogic.Initialized;

public class TestNonNullAndRaw {
  // Raw may not be used on fields
 
  
  
  @SuppressWarnings("unused")
  private void testParams(
      @NonNull Object nonNull,
      @Initialized(through="*") Object raw,
      @NonNull @Initialized(through="*") Object both) {
    // foo
  }
  
  @SuppressWarnings("unused")
  private void testLocals() {
    @NonNull Object nonNull;
    @Initialized(through="*") Object raw;
    @NonNull @Initialized(through="*") Object both;
    
    // foo
  }
  
  // 
  
  @NonNull
  private Object returnNonNull() {
    return "String";
  }
  
  @Initialized(through="*", value=" return")
  private Object returnRaw() {
    return "String";
  }
  
  @NonNull
  @Initialized(through="*", value=" return")
  private Object returnBoth() {
    return "String";
  }
}

package test;

import com.surelogic.NonNull;
import com.surelogic.Initialized;

public class TestNonNullAndRaw {
  // Raw may not be used on fields
 
  
  
  @SuppressWarnings("unused")
  private void testParams(
      @NonNull Object nonNull,
      @Initialized(through="Object") Object raw,
      @NonNull @Initialized(through="Object") Object both) {
    // foo
  }
  
  @SuppressWarnings("unused")
  private void testLocals() {
    @NonNull Object nonNull;
    @Initialized(through="Object") Object raw;
    @NonNull @Initialized(through="Object") Object both;
    
    // foo
  }
  
  // 
  
  @NonNull
  private Object returnNonNull() {
    return "String";
  }
  
  @Initialized(through="Object", value=" return")
  private Object returnRaw() {
    return "String";
  }
  
  @NonNull
  @Initialized(through="Object", value=" return")
  private Object returnBoth() {
    return "String";
  }
}

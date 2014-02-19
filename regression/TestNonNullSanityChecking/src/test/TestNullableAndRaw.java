package test;

import com.surelogic.Nullable;
import com.surelogic.Initialized;

public class TestNullableAndRaw {
  // Raw may not be used on fields
 
  
  
  @SuppressWarnings("unused")
  private void testParams(
      @Nullable Object nonNull,
      @Initialized(through="Object") Object raw,
      @Nullable @Initialized(through="Object") Object both) {
    // foo
  }
  
  @SuppressWarnings("unused")
  private void testLocals() {
    @Nullable Object nonNull;
    @Initialized(through="Object") Object raw;
    @Nullable @Initialized(through="Object") Object both;
    
    // foo
  }
  
  // 
  
  @Nullable
  private Object returnNullable() {
    return "String";
  }
  
  @Initialized(through="Object", value=" return")
  private Object returnRaw() {
    return "String";
  }
  
  @Nullable
  @Initialized(through="Object", value=" return")
  private Object returnBoth() {
    return "String";
  }
}

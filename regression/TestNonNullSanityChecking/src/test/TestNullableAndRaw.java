package test;

import com.surelogic.Nullable;
import com.surelogic.Raw;

public class TestNullableAndRaw {
  // Raw may not be used on fields
 
  
  
  @SuppressWarnings("unused")
  private void testParams(
      @Nullable Object nonNull,
      @Raw Object raw,
      @Nullable @Raw Object both) {
    // foo
  }
  
  @SuppressWarnings("unused")
  private void testLocals() {
    @Nullable Object nonNull;
    @Raw Object raw;
    @Nullable @Raw Object both;
    
    // foo
  }
  
  // 
  
  @Nullable
  private Object returnNullable() {
    return "String";
  }
  
  @Raw("return")
  private Object returnRaw() {
    return "String";
  }
  
  @Nullable
  @Raw("return")
  private Object returnBoth() {
    return "String";
  }
}

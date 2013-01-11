package test;

import com.surelogic.NonNull;
import com.surelogic.Nullable;

public class TestNonNullAndNullable {
  @NonNull
  private Object nonNull = "String";
  
  @Nullable
  private Object nullable = "String";
  
  @NonNull
  @Nullable
  private Object both = "String";
  
  
  
  @SuppressWarnings("unused")
  private void testParams(
      @NonNull Object nonNull,
      @Nullable Object nullable,
      @NonNull @Nullable Object both) {
    // foo
  }
  
  @SuppressWarnings("unused")
  private void testLocals() {
    @NonNull Object nonNull;
    @Nullable Object nullable;
    @NonNull @Nullable Object both;
    
    // foo
  }
  
  @NonNull
  private Object returnNonNull() {
    return "String";
  }
  
  @Nullable
  private Object reutrnNullable() {
    return "String";
  }
  
  @NonNull
  @Nullable
  private Object returnBoth() {
    return "String";
  }
}
